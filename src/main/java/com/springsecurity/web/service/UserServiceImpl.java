package com.springsecurity.web.service;

import com.springsecurity.web.dao.UserDao;
import com.springsecurity.web.model.Role;
import com.springsecurity.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private Role adminRole = new Role((long) 1, "ROLE_ADMIN");
    private Role userRole = new Role((long) 2, "ROLE_USER");
    private UserDao userDao;
    private PasswordEncoder encoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void save(User user, String role) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (role.contains("ADMIN")) {
            user.addRoles(adminRole);
        }
        if (role.contains("USER")) {
            user.addRoles(userRole);
        }
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void update(User user, String role) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (role.contains("ADMIN")) {
            user.addRoles(adminRole);
        }
        if (role.contains("USER")) {
            user.addRoles(userRole);
        }
        userDao.update(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

