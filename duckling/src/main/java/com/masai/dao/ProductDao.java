package com.masai.dao;

import java.util.ArrayList;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Products;


@Repository
public interface ProductDao extends JpaRepository<Products, Integer>  {
//	@Query("select p from products p where p.productname=?1")        
//	List<Products> findByproductname(String name);
	
	@Query("select p from Product p where category IN(select c from Category c where c.categoryName=?1)")
	public List<Products> getProductByCategory(String cName);

}
