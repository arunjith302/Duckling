package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.masai.dao.CategoryDao;
import com.masai.dao.SessionDao;
import com.masai.dao.adminSession;
import com.masai.exceptions.CustomerException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Current_adminSession;
import com.masai.model.Customer;


@Service
public class CategSerImpl implements CategoryService{
	@Autowired
	private adminSession adss;
	@Autowired
	private CategoryDao catDao;

	@Override
	public Category createCategory(Category catg,String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		Current_adminSession loggedInUser= adss.findByUuid(key);
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
	
		return catDao.save(catg);
	}

}
