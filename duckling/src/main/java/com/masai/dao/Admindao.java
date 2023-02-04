package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.admin;

public interface Admindao extends JpaRepository<admin, Integer> {
	public admin findByMobileNo(String mobileNo);

	

}
