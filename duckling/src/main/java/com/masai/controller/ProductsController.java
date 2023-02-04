package com.masai.controller;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.ProductException;
import com.masai.model.Products;
import com.masai.service.ProductService;

@RestController
public class ProductsController {
	@Autowired
	private ProductService pSer;
	@PostMapping("/addProducts")
	public  ResponseEntity<Products> SaveProduct(@RequestBody Products prod,@RequestParam(required = false) String key ,@RequestParam(required = false) String cat) throws  ProductException{
		Products SaveProduct = pSer.AddProduct(prod, key,cat);
		
		return new ResponseEntity<Products>(SaveProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/allproducts")
	public ResponseEntity<List<Products>> viewAllProductHandler() throws ProductException{
		
		List<Products> allPdts = pSer.viewAllProduct();
		
		return new ResponseEntity<List<Products>>(allPdts, HttpStatus.OK);
	}
	@PostMapping("/update")
	public ResponseEntity<Products> updateProductHandler(@RequestBody Products product,@RequestParam(required = false) String key) throws ProductException{
		Products updated = pSer.updateProduct(product,key);
		
		return new ResponseEntity<Products>(updated, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Products> viewProductHandler(@PathVariable Integer Id) throws ProductException{
		Products pdt = pSer.viewProduct(Id);
		
		return new ResponseEntity<Products>(pdt, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Products>> viewProductByCategoryHandler(@RequestParam(value="category") String cname) throws ProductException{
		List<Products> allPdt = pSer.viewProductByCategory(cname);
		
		return new ResponseEntity<List<Products>>(allPdt, HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Products> removeProductHandler(@PathVariable Integer Id) throws ProductException {
		Products pdt = pSer.removeProduct(Id);
		
		return new ResponseEntity<Products>(pdt, HttpStatus.OK);
	}

}
