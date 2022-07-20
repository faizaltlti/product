package com.shoppingportal.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingportal.product.entity.Product;
import com.shoppingportal.product.service.ProductService;

@RestController

public class ProductController {

	@Autowired
	private ProductService productService;
	
	//@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/products")
	public ResponseEntity<Product> saveProductDetails(@RequestBody Product product) {
		
		productService.saveProductDetails(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Integer productId) {
		
		return productService.getProductById(productId);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(Pageable page){
		
		return productService.getAllProducts(page);
	}
	
	@GetMapping("/products/price/{id}")
	public Integer getProductPriceById(@PathVariable("id") Integer productId) {
		
		return productService.getProductPriceById(productId);
	}
	
	@DeleteMapping("/products/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") Integer productId) {
		
		 productService.deleteProductById(productId);
	}
	
	@PutMapping("/products/{id}")
	public Product updateProductDetails(@RequestBody Product product, @PathVariable("id") Integer productId) {
		
		return productService.updateProductDetails(product,productId);
		
	}
	
	@GetMapping("/products/count/{id}")
	public Integer getProductQuantityById(@PathVariable("id") Integer productId) {
		
		return productService.getProductQuantityById(productId);
	}


  @PutMapping("/products/updateQuantity")
  public void updateProductQuantity(@RequestBody Map<Integer,Integer> idQuantityMap) {
		 productService.updateProductQuantity(idQuantityMap);
}
	
}
