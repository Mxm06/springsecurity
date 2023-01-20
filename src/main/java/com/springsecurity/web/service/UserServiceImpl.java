package com.springsecurity.web.service;

import com.springsecurity.web.dao.UserDao;
import com.springsecurity.web.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserDao userDao;
    private RoleService roleService;
    private PasswordEncoder encoder;

    public UserServiceImpl(UserDao userDao, RoleService roleService, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @Transactional
    public void addRoleAndSave(User user, String role) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (role.contains("ADMIN")) {
            user.addRoles(roleService.getRoleByName("ROLE_ADMIN"));
        }
        if (role.contains("USER")) {
            user.addRoles(roleService.getRoleByName("ROLE_USER"));
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
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.update(user);
    }

    @Override
    @Transactional
    public void addRoleAndUpdate(User user, String role) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (role.contains("ADMIN")) {
            user.addRoles(roleService.getRoleByName("ROLE_ADMIN"));
        }
        if (role.contains("USER")) {
            user.addRoles(roleService.getRoleByName("ROLE_USER"));
        }
        userDao.update(user);
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
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

