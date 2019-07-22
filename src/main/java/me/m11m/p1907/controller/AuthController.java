package me.m11m.p1907.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.m11m.p1907.model.MyUser;
import me.m11m.p1907.service.MyUserService;


/**
 * AuthController
 */
@Controller
public class AuthController {

    @Autowired
    MyUserService myUserService;


    @GetMapping(value="/login")
    public String loginPage() {
        return new String("login");
    }

    @GetMapping(value="/register")
    public String registerPage() {
        return new String("register");
    }

    @PostMapping(value="/register")
    @ResponseBody
    public MyUser registerPage(MyUser myUser) throws Exception {
        return myUserService.registerUser(myUser);
    }
}