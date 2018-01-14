package com.simpleproject.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleproject.domain.Role;
import com.simpleproject.domain.User;
import com.simpleproject.repository.RoleRepository;
import com.simpleproject.repository.UserRepository;
import com.simpleproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User getByName(String name) throws Exception {
		return userRepository.findByName(name).map(user -> user).orElseThrow(() -> new Exception("User Not Found"));
	}

	@Override
	public User saveUser(String name, String mail, String password) {
		Role role = roleRepository.findOne((long) 1);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		return userRepository.save(new User(name, mail, password, roles));
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
			user.setMail(mail + "@dw.dw");
		return userRepository.save(user);
	}

}
