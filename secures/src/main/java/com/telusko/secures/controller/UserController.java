package com.telusko.secures.controller;

import com.telusko.secures.model.Data;
import com.telusko.secures.service.MyUserDetailsService;
import com.telusko.secures.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public Data register(@RequestBody Data data) {
        return service.register(data);
    }

    @PostMapping("/login")
    public String login(@RequestBody Data data) {
        return service.verify(data);
    }

}
