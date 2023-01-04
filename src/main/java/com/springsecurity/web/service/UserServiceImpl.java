package springboot.hibernatemvcboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.hibernatemvcboot.web.dao.UserDao;
import springboot.hibernatemvcboot.web.model.User;


import java.util.List;
    @Service
    public class UserServiceImpl implements UserService, UserDetailsService {
        private UserDao userDao;
        @Autowired
        public UserServiceImpl(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        @Transactional
        public void save(User user) {
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
            return userDao.getByUsername(username);
        }
    }

