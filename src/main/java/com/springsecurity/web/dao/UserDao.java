package com.springsecurity.web.dao;



import com.springsecurity.web.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public List<User> listAllUsers();
    public User getByUsername(String username);
}
