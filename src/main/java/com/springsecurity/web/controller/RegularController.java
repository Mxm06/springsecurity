package com.springsecurity.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegularController {
    @GetMapping("/admin")
    private String getAdminPage() {
        return "admin";
    }
}
