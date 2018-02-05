package com.simpleproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleproject.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
