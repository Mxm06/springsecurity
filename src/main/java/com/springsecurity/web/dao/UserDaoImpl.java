package com.springsecurity.web.dao;

import com.springsecurity.web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public void deleteById(Long id) {
        entityManager.createQuery("delete from User where id =: id").setParameter("id", id).executeUpdate();
    }

    public User getByUsername(String username) {
        return (User) entityManager.createQuery("from User u join fetch u.roles where u.username =:username")
                .setParameter("username", username).getSingleResult();
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> getUsersList() {
        return entityManager.createQuery("from User").getResultList();
    }
}
