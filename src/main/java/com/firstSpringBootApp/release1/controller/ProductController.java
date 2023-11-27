package com.firstSpringBootApp.release1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringBootApp.release1.model.Product;

@RestController
public class ProductController {
	private static Map<String, Product> productRepo = new HashMap<>();
	
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		
		productRepo.put(honey.getId(), honey);
		productRepo.put(almond.getId(), almond);
		}
	
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productRepo.put(product.getId(), product);		
		return new ResponseEntity<>("Product Created Succesfully",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product  product){
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Product Updated Successfully",HttpStatus.OK);
		
	}
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id")String id){ 
		productRepo.remove(id);
		return new ResponseEntity<>("Product Deleted successfully",HttpStatus.OK);
	}
	
	
}
