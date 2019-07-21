package me.m11m.p1907.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.m11m.p1907.model.Book;
import me.m11m.p1907.model.KDocument;
import me.m11m.p1907.service.BookService;

/**
 * BookController
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    ResponseEntity<KDocument> getBooksByTitle(@RequestParam(required = false) String keyword){
        KDocument result = bookService.findBookByTitle(keyword);

        //TODO: respoese Header로 Pagination 처리


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}