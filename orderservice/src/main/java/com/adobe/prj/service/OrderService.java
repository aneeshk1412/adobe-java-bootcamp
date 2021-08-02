package com.adobe.prj.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.api.NotFoundException;
import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product getProductById(int id) throws NotFoundException {
		 Optional<Product> opt = productDao.findById(id);
		 if(opt.isPresent()) {
			 return opt.get();
		 } else {
			 throw new NotFoundException("Product with id " + id + " doesn't exist!!!") ;
		 }
	}
	
	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
	
	@Transactional
	public Customer getCustomer(String email) {
		Customer c =  customerDao.getById(email); // not get customer ==> proxy ==> Lazy loading
		System.out.println("hits the DB!!!");
		System.out.println(c);
		return c;
	}
	
	@Transactional
	public void placeOrder(Order o) {
		List<Item> items = o.getItems();
		double amt = 0.0;
		for(Item i : items) {
			Product p = productDao.findById(i.getProduct().getId()).get();
			p.setQuantity(p.getQuantity() - i.getQty()); // dirty checking
			i.setPrice(p.getPrice() * i.getQty()); // dirty checking
			amt += p.getPrice() * i.getQty(); 
		}
		o.setTotal(amt); // dirty checking
		orderDao.save(o);
	}
	
	public List<Product> getProductsPriceRange(double low, double high) {
		return productDao.fetchProductsByRange(low, high);
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	@Transactional
	public Product updateProduct(int id, double price) {
		productDao.updateProduct(id, price);
		return productDao.findById(id).get();
	}
}