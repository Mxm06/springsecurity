package com.springsecurity.web.dao;


import com.springsecurity.web.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }

    @Override
    public List<Role> getRolesList() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("from Role r where r.name=:name").setParameter("name", name).getSingleResult();
    }
}
