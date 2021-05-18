package com.stoxckbid.payumoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stoxckbid.payumoney.model.ProductList;
import com.stoxckbid.payumoney.services.ProductFeignClientService;

@RestController
public class ProductApi {

	@Autowired
	private ProductFeignClientService service;

	@GetMapping("/products")
	public @ResponseBody ProductList getProducts() {
		return service.getProducts();
	}

}
