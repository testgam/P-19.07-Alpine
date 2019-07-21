package me.m11m.p1907.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.m11m.p1907.model.Book;
import me.m11m.p1907.service.BookService;

/**
 * BookController
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/{title}")
    ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title){
        List<Book> results = bookService.findBookByTitle(title);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}