package com.springsecurity.web.service;

import com.springsecurity.web.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    void delete(Role role);

    List<Role> getRolesList();

    public Role getRoleByName(String name);
}
