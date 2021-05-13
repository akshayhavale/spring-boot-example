package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.GstClientService;

@RestController
public class GstController {

	@Autowired
	private GstClientService gstClientService;

	@GetMapping("/gstrates")
	public List getAllGstRates() {
		try {
			return gstClientService.getAllGstRates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
