package me.m11m.p1907.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import me.m11m.p1907.model.Book;
import me.m11m.p1907.model.KDocument;
import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.service.BookService;
import me.m11m.p1907.service.SearchHistoryService;

/**
 * BookControllerTest
 */
@WebMvcTest(controllers =  {BookController.class}, secure = false)
@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Mock
    User principal;

    @MockBean
    SearchHistoryService searchHistoryService;

    @Autowired
    BookController bookController;

    @Mock
    User applicationUser;
    @Mock
    Authentication authentication;
    @Mock
    SecurityContext securityContext;

    @Before
    public void setup(){
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);
    }


    @Test
    public void whenSearchByTitle_thenBooksWithPagination() throws Exception {
        // Arrange
        List<Book> books = Arrays.asList(Book.builder().title("my day").isbn("123345").build(),
                Book.builder().title("my night").isbn("54321").build());
        KDocument docuemnt = KDocument.builder().books(books).meta(KDocument.Meta.builder().endTF(false).pageableCount(2).totalCount(3).build()).build();
       
        when(bookService.findBookByTitle("my",1)).thenReturn(docuemnt);
        when(searchHistoryService.addAHistory(any(SearchHistory.class))).thenReturn(null);

        // Actl
        // ResultActions result = mockMvc.perform(get("/books/{title}", "my").accept(MediaType.APPLICATION_JSON_VALUE));
        ResultActions result = mockMvc.perform(get("/apis/books?keyword={keyword}", "my").accept(MediaType.APPLICATION_JSON_VALUE));

        // Assert
        result.andExpect(jsonPath("$.books", hasSize(2)))
        .andDo(print());
    }


}