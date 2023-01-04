package springboot.hibernatemvcboot.web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import springboot.hibernatemvcboot.web.model.User;


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
        entityManager.createQuery("delete from User where id =:id").setParameter("id",user.getId()).executeUpdate();
    }
    public User getByUsername(String username) throws UsernameNotFoundException {
        User user = (User) entityManager.createQuery("from User where username = username").getSingleResult();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> listAllUsers() {
        return entityManager.createQuery(FROM_USER).getResultList();
    }
}
