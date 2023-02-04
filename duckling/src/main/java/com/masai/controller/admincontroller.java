package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.model.admin;
import com.masai.service.Adminservice;

@RestController
public class admincontroller {
	@Autowired
	private Adminservice aServ;
	
	@PostMapping("/admin")
	public ResponseEntity<admin> saveCustomer(@RequestBody admin admin,@RequestParam(required = false) String key) throws CustomerException {
		
		admin savedadmin= aServ.createadmin(admin,key);
		
		
		return new ResponseEntity<admin>(savedadmin,HttpStatus.CREATED);
	}

}
