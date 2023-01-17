package com.springsecurity.web.controller;


import com.springsecurity.web.model.User;

import com.springsecurity.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {
    private UserService userService;

    AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("admin")
    String userPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patchingUser", new User());
        model.addAttribute("deletingUser", new User());
        model.addAttribute("userList", userService.listAllUsers());
        return "admin";
    }

    @PostMapping("admin")
    String createUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        userService.save(user, role);
        return "redirect:/admin";
    }

    @PatchMapping("admin")
    String patch(@ModelAttribute("patchingUser") User user, @RequestParam(value = "role") String role) {
        userService.update(user, role);
        return "redirect:/admin";
    }

    @DeleteMapping("admin")
    String delete(@ModelAttribute("deletingUser") User user) {
        userService.delete(user);
        return "redirect:/admin";
    }
}
