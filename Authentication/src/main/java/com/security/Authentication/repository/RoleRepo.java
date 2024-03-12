package com.security.Authentication.repository;

import com.security.Authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
        Optional<Role> findByAuthority(String authority);
}
