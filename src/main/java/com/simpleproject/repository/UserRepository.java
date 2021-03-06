package com.simpleproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleproject.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);

}
