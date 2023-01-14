package com.springsecurity.web.service;

import com.springsecurity.web.model.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);
    public void delete(Role role);
    public void update(Role role);
    public List<Role> listAllRoles();
}
