package com.telusko.secures.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api")
    public String greeting(HttpServletRequest request) {
        return "Welcome to  spring security" ; //+ request.getSession().getId();
    }

}
