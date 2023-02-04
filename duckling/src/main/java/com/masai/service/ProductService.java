package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.ProductException;
import com.masai.model.Products;

public interface ProductService {
	
	public Products AddProduct(Products products ,String key,String cat) throws ProductException;
public List<Products> viewAllProduct() throws ProductException;
	
	
	
	
	
	public Products viewProduct(Integer Id) throws ProductException;
	
	public List<Products> viewProductByCategory(String cname) throws ProductException;
	
	public Products removeProduct(Integer Id) throws ProductException;
	public Products updateProduct(Products product, String key) throws ProductException;

}
