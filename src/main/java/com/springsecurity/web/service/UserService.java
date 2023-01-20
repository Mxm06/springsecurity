package com.springsecurity.web.service;


import com.springsecurity.web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void addRoleAndSave(User user, String role);

    void delete(User user);

    void deleteById(Long id);

    void update(User user);
    void addRoleAndUpdate(User user, String role);


    List<User> getUsersList();
}
