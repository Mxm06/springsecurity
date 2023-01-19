package com.springsecurity.web.controller;


import com.springsecurity.web.model.User;

import com.springsecurity.web.service.RoleService;
import com.springsecurity.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin")
    private String getAdminPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patchingUser", new User());
        model.addAttribute("deletingUser", new User());
        model.addAttribute("userList", userService.getUsersList());
        return "admin";
    }

    @PostMapping("admin")
    private String createUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        if (role.contains("ADMIN")) {
            user.addRoles(roleService.getRoleByName("ROLE_ADMIN"));
        }
        if (role.contains("USER")) {
            user.addRoles(roleService.getRoleByName("ROLE_USER"));
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("admin")
    private String patchUser(@ModelAttribute("patchingUser") User user, @RequestParam(value = "role") String role) {
        if (role.contains("ADMIN")) {
            user.addRoles(roleService.getRoleByName("ROLE_ADMIN"));
        }
        if (role.contains("USER")) {
            user.addRoles(roleService.getRoleByName("ROLE_USER"));
        }
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin")
    private String deleteUser(@ModelAttribute("deletingUser") User user) {
        userService.deleteById(user.getId());
        return "redirect:/admin";
    }
}
