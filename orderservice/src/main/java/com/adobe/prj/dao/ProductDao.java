package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("from Product where category = :cat")
	List<Product> getProductsByCategory(@Param("cat") String category);
	
	@Query("from Product where price between :l and :h")
	List<Product> fetchProductsByRange(@Param("l") double lower, @Param("h") double upper);
	
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	public void updateProduct( @Param("id") int id, @Param("pr") double price);
	
}