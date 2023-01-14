package com.springsecurity.web.dao;



import com.springsecurity.web.model.Role;

import java.util.List;

public interface RoleDao {
    public void save(Role role);
    public void delete(Role role);
    public void update(Role role);
    public List<Role> listAllRoles();
}

