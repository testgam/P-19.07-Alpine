package me.m11m.p1907.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import me.m11m.p1907.model.Book;

/**
 * BookService
 */
@Service
public class BookService {

    @Autowired
    RestTemplate restTemplate;

    public List<Book> findBookByTitle(String title){
        Book[] books = restTemplate.getForObject("", Book[].class);
        return Arrays.asList(books);
    }
}