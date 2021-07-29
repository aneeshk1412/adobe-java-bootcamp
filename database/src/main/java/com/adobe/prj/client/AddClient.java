package com.adobe.prj.client;

import com.adobe.prj.dao.ProductDaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class AddClient {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		try {
			 Product p = new Product(0, "Logitech Mouse", "computer", 680.00);
			 productDao.addProduct(p);
			 System.out.println("Product added!!!");
		} catch (ProductDaoException e) {
//			e.printStackTrace(); // development state
			System.out.println(e.getMessage());
		}
	}

}