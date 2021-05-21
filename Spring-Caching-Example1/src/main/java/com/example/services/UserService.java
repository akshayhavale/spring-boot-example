package com.example.services;

import java.util.List;

import com.example.model.User;

public interface UserService {
	
	List<User> getAllUsers() throws InterruptedException;

}
