package springboot.hibernatemvcboot.web.dao;

import springboot.hibernatemvcboot.web.model.Role;

import java.util.List;

public interface RoleDao {
    public void save(Role role);
    public void delete(Role role);
    public void update(Role role);
    public List<Role> listAllRoles();
}

