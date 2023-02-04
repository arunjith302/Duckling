package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int cid;
	private String cname;
	private String cdesc;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cat")
	List<Products> pro = new ArrayList<>();
	

}
