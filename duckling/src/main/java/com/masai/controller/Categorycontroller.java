package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.Category;
import com.masai.model.Customer;
import com.masai.service.CategoryService;

@RestController
public class Categorycontroller {
	@Autowired
	private CategoryService catser;
	
	@PostMapping("/addcategory")
public ResponseEntity<Category> saveCategoryr(@RequestBody Category catg,@RequestParam(required = false) String key) throws CustomerException {
		
		Category savedCategory= catser.createCategory(catg,key);
		
		
		return new ResponseEntity<Category>(savedCategory,HttpStatus.CREATED);
	}
	

}
