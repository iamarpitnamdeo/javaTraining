package com.firstSpringBootApp.release1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringBootApp.release1.model.Product;
import com.firstSpringBootApp.release1.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productSevice;
//	private static Map<String, Product> productRepo = new HashMap<>();
	
//	static {
//		Product honey = new Product();
//		honey.setId("1");
//		honey.setName("Honey");
//		
//		Product almond = new Product();
//		almond.setId("2");
//		almond.setName("Almond");
//		
//		productRepo.put(honey.getId(), honey);
//		productRepo.put(almond.getId(), almond);
//		}
//	
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<>(productSevice.getAllProduct(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){	
		return new ResponseEntity<>(productSevice.addProduct(product),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable String id){ 
		return new ResponseEntity<>(productSevice.deleteProduct(id),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product  product){
		return new ResponseEntity<>(productSevice.updateProduct(product, id),HttpStatus.OK);
		
	}
	
	
}
