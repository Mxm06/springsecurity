package com.springsecurity.web.dao;



import com.springsecurity.web.model.Role;

import java.util.List;

public interface RoleDao {
     void save(Role role);
     void delete(Role role);
     void update(Role role);
     List<Role> listAllRoles();
}

