package com.springsecurity.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @GetMapping("/user")
    private String getUserPage() {
        return "user";
    }
}
