package com.simpleproject.service;

import com.simpleproject.domain.User;

public interface UserService {

	public User getByName(String name) throws Exception;

	public User saveUser(String name, String mail, String password);

	public void deleteUser(long id);

	public User updateUser(long id, String name, String mail);

}
