package com.springsecurity.web.controller;

import com.springsecurity.web.model.Role;
import com.springsecurity.web.model.User;
import com.springsecurity.web.service.RoleService;
import com.springsecurity.web.service.UserService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private Role adminRole = new Role((long) 2, "ROLE_ADMIN");
    private Role userRole = new Role((long) 1, "ROLE_USER");


    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin")
    public String userPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patchingUser", new User());
        model.addAttribute("deletingUser", new User());
        model.addAttribute("userList", userService.listAllUsers());
        return "admin";
    }

    @PostMapping("admin")
    public String createUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        if (role.contains("ADMIN")) {
            user.addRoles(adminRole);
        }
        if (role.contains("USER")) {
            user.addRoles(userRole);
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("admin")
    public String patch(@ModelAttribute("patchingUser") User user, @RequestParam(value = "role") String role) {
        if (role.contains("ADMIN")) {
            user.addRoles(adminRole);
        }
        if (role.contains("USER")) {
            user.addRoles(userRole);
        }
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin")
    public String delete(@ModelAttribute("deletingUser") User user) {
        userService.delete(user);
        return "redirect:/admin";
    }

}
