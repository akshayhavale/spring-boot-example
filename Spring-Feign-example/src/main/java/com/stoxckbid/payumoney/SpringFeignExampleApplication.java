package com.stoxckbid.payumoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignExampleApplication.class, args);
	}

}
