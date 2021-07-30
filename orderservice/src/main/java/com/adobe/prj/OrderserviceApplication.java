package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@SpringBootApplication
public class OrderserviceApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		listProducts();
//		addProduct();
	}

	private void addProduct() {
		Product p = new Product(0,"Tata Sky Settop box", 5400.00, "tv");
		p.setQuantity(100);
		orderService.addProduct(p);
	}

	private void listProducts() {
		List<Product> products = orderService.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}
}
