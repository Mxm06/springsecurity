package com.springsecurity.web.service;


import com.springsecurity.web.model.User;

import java.util.List;

public interface UserService {
    void save(User user, String role);

    void delete(User user);

    void update(User user, String role);

    List<User> listAllUsers();
}
