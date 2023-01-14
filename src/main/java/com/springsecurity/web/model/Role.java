package com.springsecurity.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name ="name")
    private String name;
    public Role() {

    }
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return name;
    }

    public void setRoleName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
