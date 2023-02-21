package com.springsecurity.web.controller;

import com.springsecurity.web.model.User;
import com.springsecurity.web.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springsecurity.web.service.UserService;

@Controller
public class UserController {
    UserService userService;
    RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    private String getUserPage() {
        return "user";
    }



}
