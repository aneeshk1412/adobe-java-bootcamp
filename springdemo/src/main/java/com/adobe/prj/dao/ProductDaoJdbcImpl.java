package com.adobe.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.prj.entity.Product;

@Repository
public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct(Product p) {
		System.out.println("Stored using JDBC!!!");
	}

	@Override
	public List<Product> getProducts() {
		return null;
	}

	@Override
	public Product getProduct(int id) {
		return null;
	}

}