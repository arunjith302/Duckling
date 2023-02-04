package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.masai.dao.CategoryDao;
import com.masai.dao.ProductDao;
import com.masai.dao.adminSession;
import com.masai.exceptions.CustomerException;
import com.masai.exceptions.ProductException;
import com.masai.model.Category;
import com.masai.model.Current_adminSession;
import com.masai.model.Products;

import net.bytebuddy.matcher.AnnotationTargetMatcher;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private adminSession adss;
	
	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private CategoryDao cDao;
	
	
	@Override
	public Products AddProduct(Products products, String key,String cat) throws ProductException {
		
		Current_adminSession loggedInUser= adss.findByUuid(key);
		if(loggedInUser == null) {
			throw new ProductException("Please provide a valid key to add product");
		}
		Category ca = cDao.findByCname(cat);
		ca.getPro().add(products);
		
	
		return pDao.save(products);
	}


	@Override
	public List<Products> viewAllProduct() throws ProductException {
List<Products> allPdts = pDao.findAll();
		
		if(allPdts.size() == 0) {
			throw new ProductException("No Products found in the store...");
		}
		
		return allPdts;
	}


	@Override
	public Products updateProduct(Products product , String key) throws ProductException {
		
		Current_adminSession loggedInUser= adss.findByUuid(key);
		if(loggedInUser == null) {
			throw new ProductException("Please provide a valid key to add product");
		}
		
		
Optional<Products> tempPdt =  pDao.findById(product.getProductid());
		
		if(tempPdt.isPresent()) {
			Products updatedPdt = pDao.save(product);
			
			return updatedPdt;
		}else {
			throw new ProductException("No Product found to update with this Id: " + product.getProductid());
		}
		
	}


	@Override
	public Products viewProduct(Integer Id) throws ProductException {
Optional<Products> tempPdt =  pDao.findById(Id);
		
		if(tempPdt.isPresent()) {
			return tempPdt.get();
			
		}else {
			throw new ProductException("No Product found with this Id: " + Id);
		}
	}


	@Override
	public List<Products> viewProductByCategory(String cname) throws ProductException {
List<Products> allPdts = pDao.getProductByCategory(cname);
		
		if(allPdts.size() == 0) {
			throw new ProductException("No Product found with this category : " + cname);
		}
		
		return allPdts;
	}


	@Override
	public Products removeProduct(Integer Id) throws ProductException {
Optional<Products> tempPdt =  pDao.findById(Id);
		
		if(tempPdt.isPresent()) {
			Products delPdt = tempPdt.get();
			pDao.delete(delPdt);
			
			return delPdt;
			
		}else {
			throw new ProductException("No Product found with this Id: " + Id);
		}
	}


	

	

}
