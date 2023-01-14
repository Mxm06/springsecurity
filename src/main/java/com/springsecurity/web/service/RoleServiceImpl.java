package com.springsecurity.web.service;

import com.springsecurity.web.dao.RoleDao;
import com.springsecurity.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;
    @Autowired
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
    @Transactional
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    @Transactional
    public List<Role> listAllRoles() {
        return roleDao.listAllRoles();
    }
}
