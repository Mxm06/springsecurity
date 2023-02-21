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
    public void postConstruct() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        User userWithAdminRole = new User("admin", "123");
        userWithAdminRole.setAge((byte) 30);
        userWithAdminRole.setFirstName("Alex");
        userWithAdminRole.setLastName("Wilson");
        User userWithDefaultRole = new User("user", "1234");
        userWithDefaultRole.setAge((byte) 20);
        userWithDefaultRole.setFirstName("Billy");
        userWithDefaultRole.setLastName("Davidson");
        roleService.save(adminRole);
        roleService.save(userRole);
        userWithAdminRole.addRoles(adminRole);
        userWithAdminRole.addRoles(userRole);
        userWithDefaultRole.addRoles(userRole);
        userService.save(userWithAdminRole);
        userService.save(userWithDefaultRole);
    }
}
