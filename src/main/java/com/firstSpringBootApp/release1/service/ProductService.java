package com.firstSpringBootApp.release1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpringBootApp.release1.exception.ProductNotfoundException;
import com.firstSpringBootApp.release1.exception.UserNotFoundException;
import com.firstSpringBootApp.release1.model.Product;
import com.firstSpringBootApp.release1.repository.ProductRepository;
@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;

	private List<Product> product = new ArrayList<>();
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public List<Product> addProduct(Product newProduct){
		
		if (newProduct.getName() == null || newProduct.getName().isEmpty()) {
			throw new UserNotFoundException();
		}
		productRepository.save(newProduct);
		return getAllProduct();
	}
	
	public List<Product> deleteProduct(String id){
		
		
		Product productToDelete = product.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
		
		if(productToDelete!=null)
		{
			product.remove(productToDelete);
			productRepository.deleteById(id);
		}
		
		return getAllProduct();
	}
	
	
	public List<Product> updateProduct(Product updatedProduct,String id)
	{
		if(!productRepository.existsById(id)) throw new ProductNotfoundException(); 
		 Product existingProduct = productRepository.findById(id).orElse(null);
	        if (existingProduct != null) {
	          
	            existingProduct.setName(updatedProduct.getName());
	    
	            productRepository.save(existingProduct);
	        }

	        return getAllProduct();
	}
		

}
