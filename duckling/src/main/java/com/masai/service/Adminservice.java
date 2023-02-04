package com.masai.service;

import com.masai.exceptions.CustomerException;

import com.masai.model.admin;

public interface Adminservice {
	
	
	
	public admin createadmin(admin admin,String code)throws CustomerException;

}
 