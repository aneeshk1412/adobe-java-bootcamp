package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Product;

@Service
public class AppService {
	@Autowired
	private ProductDao productDao;
	
	public void insertProduct(Product p) {
		productDao.addProduct(p);
	}
}