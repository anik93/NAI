package com.simpleproject.service;

import java.util.List;

import com.simpleproject.domain.Address;
import com.simpleproject.domain.User;
import com.simpleproject.dto.UserDTO;

public interface UserService {

	public User getByName(String name) throws Exception;

	public User saveUser(String name, String mail, String password);

	public void deleteUser(long id);

	public User updateUser(long id, String name, String mail);

	public List<UserDTO> getAll();

	public User getById(Long id);

	public void addAddressToUser(Long id, Address address);

}
