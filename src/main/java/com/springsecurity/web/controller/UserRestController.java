package com.springsecurity.web.controller;

import com.springsecurity.web.model.User;
import com.springsecurity.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsersList() {
        List<User> allUsers = userService.getUsersList();
        return ResponseEntity.ok(allUsers);
    }


    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/users/authorized")
    public ResponseEntity<User> getAuthorizedUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(currentUser);
    }


    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/users")
    public ResponseEntity patchUser(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().build();
    }
}
