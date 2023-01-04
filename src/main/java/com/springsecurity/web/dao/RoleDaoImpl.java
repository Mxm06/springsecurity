package springboot.hibernatemvcboot.web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springboot.hibernatemvcboot.web.model.Role;

import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public List<Role> listAllRoles() {
        return entityManager.createQuery("from Role").getResultList();
    }
}
