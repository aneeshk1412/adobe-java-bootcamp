package com.adobe.prj;

import com.adobe.prj.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args)  throws Exception {
		Product p = new Product(34,"test product", 3434.22, "some");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, p);
		
	}
}