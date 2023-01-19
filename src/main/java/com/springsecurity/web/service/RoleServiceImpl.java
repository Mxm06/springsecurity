package com.springsecurity.web.service;

import com.springsecurity.web.dao.RoleDao;
import com.springsecurity.web.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDao.delete(role);
    }

    @Override
    public List<Role> getRolesList() {
        return roleDao.getRolesList();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
