package me.m11m.p1907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("name", "Hello");
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
