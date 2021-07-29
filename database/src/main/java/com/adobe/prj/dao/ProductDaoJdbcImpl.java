package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.entity.Product;

/**
 * Implementation of the Product DAO interface
 * for MySQL Database Persistent Storage
 */
public class ProductDaoJdbcImpl implements ProductDao {
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/adobe-java-bootcamp";
	private static String USER = "root";
	private static String PWD = "aneeshk1412";
	/* Not a good way, ideally make a configuration file, and load it
	 * in a static block within the class
	 */
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addProduct(Product p) throws ProductDaoException {
		String SQLQuery = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ps.setString(1, p.getName());
			ps.setString(2, p.getCategory());
			ps.setDouble(3, p.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new ProductDaoException("Unable to add Product :(", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public List<Product> getProducts() throws ProductDaoException {
		List<Product> products = new ArrayList<>();
		String SQLQuery = "SELECT id, name, category, price FROM products";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
				products.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			throw new ProductDaoException("Unable to get Products List", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return products;
	}
	
	@Override
	public Product getProduct(int id) throws ProductDaoException {
		Product p = new Product();
		String SQLQuery = "SELECT id, name, price, category FROM products WHERE id = ?";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			throw new ProductDaoException("Unable to get Products List", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return p;
	}
	
}
