package me.m11m.p1907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HistoryController
 */
@Controller
public class HistoryPageController {

    @GetMapping("/search-histories")
    public String historyPage(){
        return "search-histories";
    }

    @GetMapping("/top-search")
    public String topSearch(){
        return "top-search";
    }


    
}