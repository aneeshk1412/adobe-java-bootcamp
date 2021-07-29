package com.adobe.prj.entity;

public class Product implements Comparable<Product> { 
	
	private int id;
	private String name;
	private String category;
	private double price;
	
	// Constructors
	public Product() {}
	
	public Product(int id, String name, String category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	// Override compareTo to implement Comparable<Product>
	@Override
	public int compareTo(Product o) {
		return this.id - o.id;
	}
	
	@Override
	public String toString() {
		return "Product: {id: " + this.id + ", name: " + this.name + ", category: " + this.category + ", price: " + this.price + "}"
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		
		Product other = (Product) o;
		if (this.id != other.id)
			return false;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} 
		else if (!this.name.equals(other.name)) 
			return false;
		
		return true;	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
