package me.m11m.p1907.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import me.m11m.p1907.model.Book;
import me.m11m.p1907.service.BookService;

/**
 * BookControllerTest
 */
@WebMvcTest(BookController.class)
@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Autowired
    BookController bookController;

    @Test
    public void testFindByTitle() throws Exception {
        // Arrange
        List<Book> books = Arrays.asList(Book.builder().title("my day").isbn("123345").build(),
                Book.builder().title("my night").isbn("54321").build());
        
        when(bookService.findBookByTitle("my")).thenReturn(books);

        // Act
        ResultActions result = mockMvc.perform(get("/books/{title}", "my").accept(MediaType.APPLICATION_JSON_VALUE));

        // Assert
        result.andExpect(jsonPath("$", hasSize(2)))
        .andDo(print());
    }

}