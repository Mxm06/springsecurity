package com.springsecurity.web.dao;

import com.springsecurity.web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    final private String FROM_USER = "From User";
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.createQuery("delete from User where id =: id").setParameter("id",user.getId()).executeUpdate();
    }
    public User getByUsername(String username) {
        return (User) entityManager.createQuery("from User u join fetch u.roles where u.username =:username")
                .setParameter("username",username).getSingleResult();
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> listAllUsers() {
        return entityManager.createQuery(FROM_USER).getResultList();
    }
}
