package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products{
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int productid;
	private String productname;
	private String imageurl;
	private String description;
	private int price;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category cat ;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private OrderList orders;

}
