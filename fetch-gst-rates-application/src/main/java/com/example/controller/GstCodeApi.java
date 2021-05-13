package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restclient.RestClient;

@RestController
public class GstCodeApi {
	
	@Autowired
	private RestClient client;
	
	@GetMapping("/gsts")
	public Object getRates(){
		return client.getGstRate();
	}

}
