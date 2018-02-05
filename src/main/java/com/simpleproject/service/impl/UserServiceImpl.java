package com.simpleproject.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleproject.domain.Address;
import com.simpleproject.domain.User;
import com.simpleproject.dto.UserDTO;
import com.simpleproject.repository.AddressRepository;
import com.simpleproject.repository.UserRepository;
import com.simpleproject.service.DTOService;
import com.simpleproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DTOService dtoService;

	@Override
	public User getByName(String name) throws Exception {
		return userRepository.findByName(name).map(user -> user).orElseThrow(() -> new Exception("User Not Found"));
	}

	@Override
	public User saveUser(String name, String mail, String password) {
		return userRepository.save(new User(name, mail, password, new HashSet<>()));
	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	@Override
	public User updateUser(long id, String name, String mail) {
		User user = userRepository.findOne(id);
		if (name != null)
			user.setName(name);
		if (mail != null)
			user.setMail(mail);
		return userRepository.save(user);
	}

	@Override
	public List<UserDTO> getAll() {
		return userRepository.findAll().stream()
				.map(x -> dtoService.<User, UserDTO>generateDTOResponse(x, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void addAddressToUser(Long id, Address address) {
		User user = userRepository.findOne(id);
		address.setUser(user);
		addressRepository.save(address);
	}

}
