package com.adobe.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.AppService;

@SpringBootApplication
public class SpringdemoApplication implements CommandLineRunner {
	
	@Autowired
	private AppService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this code gets executed as soon as Spring Container is created
		
		Product p = new Product(45,"some",343,"ct");
		service.insertProduct(p);
	}

}