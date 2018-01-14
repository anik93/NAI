package com.simpleproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleproject.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
