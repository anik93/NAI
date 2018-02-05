package com.simpleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simpleproject.domain.Address;
import com.simpleproject.domain.User;
import com.simpleproject.dto.UserDTO;
import com.simpleproject.service.DTOService;
import com.simpleproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	private UserService userService;

	@Autowired
	private DTOService dtoService;

	@GetMapping("/create")
	public String createUser(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "mail", required = true) String mail,
			@RequestParam(value = "password", required = true) String password) {
		userService.saveUser(name, mail, password);
		return "redirect:/user/getAll";
	}

	@GetMapping("/get")
	public String getUser(@RequestParam(value = "name", required = true) String name, Model model) throws Exception {
		model.addAttribute("user",
				dtoService.<User, UserDTO>generateDTOResponse(userService.getByName(name), UserDTO.class));
		return "/user";
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = true) String id, Model model) {
		userService.deleteUser(Long.parseLong(id));
		return "redirect:/user/getAll";
	}

	@GetMapping("/update/{id}")
	public String updateUserGet(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("user",
				dtoService.<User, UserDTO>generateDTOResponse(userService.getById(id), UserDTO.class));
		return "editUser";
	}

	@PostMapping("/update/{id}")
	public String updateUserPost(@PathVariable(value = "id") Long id, @ModelAttribute User user, Model model) {
		userService.updateUser(id, user.getName(), user.getMail());
		return "redirect:/user/getAll";
	}

	@PostMapping("/address/{id}")
	public String addAddress(@PathVariable(value = "id") Long id, @ModelAttribute Address address, Model model) {
		userService.addAddressToUser(id, address);
		return "redirect:/user/getAll";
	}

	@GetMapping("/getAll")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getAll());
		model.addAttribute("user", new User());
		return "/users";
	}

	@PostMapping("/createPost")
	public String createUserPost(@ModelAttribute User user, Model model) {
		userService.saveUser(user.getName(), user.getMail(), user.getPassword());
		return "redirect:/user/getAll";
	}

}
