package com.springsecurity.web.dao;


import com.springsecurity.web.model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);

    void delete(Role role);

    List<Role> getRolesList();

    Role getRoleByName(String name);
}

