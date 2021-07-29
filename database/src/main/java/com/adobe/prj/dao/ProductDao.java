package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Product;

public interface ProductDao {
	void addProduct(Product p) throws ProductDaoException;
	List<Product> getProducts() throws ProductDaoException;
	Product getProduct(int id) throws ProductDaoException;
}