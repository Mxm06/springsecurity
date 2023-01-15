package com.springsecurity.web.service;

import com.springsecurity.web.dao.UserDao;
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
        private UserDao userDao;
        PasswordEncoder encoder;
        @Autowired
        public UserServiceImpl(UserDao userDao,PasswordEncoder encoder) {
            this.userDao = userDao;
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
        public void delete(User user) {
            userDao.delete(user);
        }

        @Override
        @Transactional
        public void update(User user) {
            user.setPassword(encoder.encode(user.getPassword()));

            userDao.update(user);
        }
        @Override
        @Transactional
        public List<User> listAllUsers() {
            return userDao.listAllUsers();
        }

        @Override
        @Transactional
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userDao.getByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return user;
        }
    }

