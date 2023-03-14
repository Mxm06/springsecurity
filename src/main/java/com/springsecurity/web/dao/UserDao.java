package com.springsecurity.web.dao;


import com.springsecurity.web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void delete(User user);

    void deleteById(Long id);

    void update(User user);

    List<User> getUsersList();

    User getByUsername(String username);
    User getUserById(Long id);
}
