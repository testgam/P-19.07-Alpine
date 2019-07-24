package me.m11m.p1907.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.m11m.p1907.model.KDocument;
import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.service.BookService;
import me.m11m.p1907.service.SearchHistoryService;

/**
 * BookController
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    SearchHistoryService searchHistoryService;



    @GetMapping("/apis/books")
    ResponseEntity<KDocument> getBooksByTitle(@RequestParam(required = true) String keyword, @RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "true") boolean changed){
        User principal =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        KDocument result = bookService.findBookByTitle(keyword,page);
        
        if(changed){
            //TODO: CustomEvent Async를 사용하여 반응성 향상 필요
            searchHistoryService.addAHistory(SearchHistory.builder().keyword(keyword).userId(principal.getUsername()).build());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}