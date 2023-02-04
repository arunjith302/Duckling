package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Category;
import com.masai.model.Customer;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	public Category findByCname(String name);

}
