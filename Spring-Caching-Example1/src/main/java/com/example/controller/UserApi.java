
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserApi {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAll() throws InterruptedException {
		return userService.getAllUsers();

	}

}
