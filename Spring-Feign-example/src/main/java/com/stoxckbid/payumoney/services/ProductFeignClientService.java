package com.stoxckbid.payumoney.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.stoxckbid.payumoney.model.ProductList;

@Component
@FeignClient(value = "feignProductService", url = "http://104.237.9.45:32122")
public interface ProductFeignClientService {

	@GetMapping("/api/v1/products?lang=en")
	public ProductList getProducts();

}
