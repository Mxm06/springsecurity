package com.springsecurity.web.service;


import com.springsecurity.web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(User user);

    void deleteById(Long id);

    void update(User user);

    List<User> getUsersList();
}
