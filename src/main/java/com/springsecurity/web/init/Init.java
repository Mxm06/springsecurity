package com.springsecurity.web.init;

import com.springsecurity.web.model.Role;
import com.springsecurity.web.model.User;
import com.springsecurity.web.service.RoleService;
import com.springsecurity.web.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Init {
    private UserService userService;
    private RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        User userWithAdminRole = new User("admin", "123");
        User userWithDefaultRole = new User("user", "1234");
        User userWithBothRoles = new User("userAdmin", "12345");
        roleService.save(new Role((long) 1, "ROLE_ADMIN"));
        roleService.save(new Role((long) 2, "ROLE_USER"));
        userService.save(userWithAdminRole, "ADMIN");
        userService.save(userWithDefaultRole, "USER");
        userService.save(userWithBothRoles, "ADMIN USER");
    }
}
