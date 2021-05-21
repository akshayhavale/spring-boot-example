package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface UserRepository {
	
	List<User> findAll();

}
