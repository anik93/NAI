package com.simpleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simpleproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUser(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "mail", required = true) String mail,
			@RequestParam(value = "password", required = true) String password) {
		return "/user/get?name=" + userService.saveUser(name, mail, password).getName();
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getUser(@RequestParam(value = "name", required = true) String name, Model model) throws Exception {
		model.addAttribute("user", userService.getByName(name));
		return "/user";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam(value = "id", required = true) String id, Model model) {
		userService.deleteUser(Long.parseLong(id));
		return "/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateUser(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "name") String name, @RequestParam(value = "mail") String mail, Model model) {
		return "/user/get?name=" + userService.updateUser(Long.parseLong(id), name, mail).getName();
	}

}
