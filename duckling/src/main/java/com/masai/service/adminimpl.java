package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.masai.dao.Admindao;
import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.model.admin;
@Service
public class adminimpl implements Adminservice{
	@Autowired
	private Admindao aDoa;


	@Override
	public admin createadmin(admin admin, String code) throws CustomerException {
	if(code.matches("DUCKLING123")) {
admin existingadmin= aDoa.findByMobileNo(admin.getMobileNo());
			
		
		
		
		if(existingadmin != null) 
			throw new CustomerException("Admin Already Registered with Mobile number");
			
		
		
		
			return aDoa.save(admin);
		
	}else {
		throw new CustomerException("Invalid Sequrity key");
	}
		
		
			
	}
	
	
}
