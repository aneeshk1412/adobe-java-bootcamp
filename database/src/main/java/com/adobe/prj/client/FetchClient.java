package com.adobe.prj.client;

import java.util.List;

import com.adobe.prj.dao.ProductDaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class FetchClient {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
			
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				System.out.println(p);
			}
		} catch (ProductDaoException e) {
//			e.printStackTrace(); // development state
			System.out.println(e.getMessage());
		}
		
	}

}