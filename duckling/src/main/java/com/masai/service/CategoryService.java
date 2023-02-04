package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.model.Category;
import com.masai.model.Customer;

public interface CategoryService {
	
	public Category createCategory(Category catg,String key)throws CustomerException;

}
