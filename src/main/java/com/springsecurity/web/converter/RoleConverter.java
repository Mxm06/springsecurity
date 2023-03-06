package com.springsecurity.web.converter;

import com.springsecurity.web.service.RoleService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.springsecurity.web.model.Role;


@Component
public class RoleConverter implements Converter<String, Role> {

    private RoleService roleService;

    public RoleConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role convert(String source) {
        Role role = roleService.getRoleByName(source);
        return role;
    }
}
