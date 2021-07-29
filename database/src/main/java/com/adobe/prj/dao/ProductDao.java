package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Product;

/**
 * Template of the Product DAO interface
 * Any specific DAO class (e.g. one for MySQL, one for MongoDB, etc.)
 * must override all these methods
 */
public interface ProductDao {
	void addProduct(Product p) throws ProductDaoException;
	List<Product> getProducts() throws ProductDaoException;
	Product getProduct(int id) throws ProductDaoException;
}