package springboot.hibernatemvcboot.web.service;

import springboot.hibernatemvcboot.web.model.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);
    public void delete(Role role);
    public void update(Role role);
    public List<Role> listAllRoles();
}
