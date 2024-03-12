package com.security.Authentication.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Integer roleId;

    private String authority;

    public Role(Integer roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", authority='" + authority + '\'' +
                '}';
    }
}
