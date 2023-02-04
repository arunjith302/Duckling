package com.masai.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;
@Data
@Entity
public class admin {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer AdminId;
	private String name;
	private String mobileNo;
	private String password;
	private String email;
//	public admin(String name, String mobileNo, String password, String email) {
//		super();
//		this.name = name;
//		this.mobileNo = mobileNo;
//		this.password = password;
//		this.email = email;
//	}
//	
	

}
