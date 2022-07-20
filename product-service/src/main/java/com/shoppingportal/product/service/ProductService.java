package com.shoppingportal.product.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingportal.product.entity.Product;
import com.shoppingportal.product.exception.ResourceNotFoundException;
import com.shoppingportal.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product getProductById(Integer productId) {
		
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			return product.get();
		}
		throw new ResourceNotFoundException("Product is not found for the id : "+productId);
	}

	public List<Product> getAllProducts(Pageable page) {
		
		return productRepository.findAll(page).toList();
	}

	public Integer getProductPriceById(Integer productId) {
		
		Product product = getProductById(productId);
		
		return product.getPrice();
	}

	public Product saveProductDetails(Product product) {
		
		return productRepository.save(product);
	}

	public void deleteProductById(Integer productId) {
		
		Product product = getProductById(productId);
		 productRepository.delete(product);
		
	}

	public Product updateProductDetails(Product product, Integer productId) {
		
		Product existingProduct = getProductById(productId);
		
		existingProduct.setName(product.getName() != null ? product.getName() : existingProduct.getName());
		existingProduct.setPrice(product.getPrice() != null ? product.getPrice() : existingProduct.getPrice());
		existingProduct.setQuantity(product.getQuantity() != null ? product.getQuantity() : existingProduct.getQuantity());
		
		//productRepository.save(existingProduct);
		
		return productRepository.save(existingProduct);
		
		
	}

	public Integer getProductQuantityById(Integer productId) {
		Product product = getProductById(productId);
		
		
		return product.getQuantity();
	}

	public void updateProductQuantity(Map<Integer, Integer> idQuantity) {
		
	
		idQuantity.entrySet().stream().forEach(item ->
		{
			Product product = getProductById(item.getKey());
		product.setQuantity(product.getQuantity() - item.getValue());
		productRepository.save(product);
		
		});
		
		
	/*
	 * for(Map.Entry<Integer, Integer> idQuantityEntry : idQuantity.entrySet()) {
	 * 
	 * Product product = getProductById(idQuantityEntry.getKey());
	 * product.setQuantity(product.getQuantity() - idQuantityEntry.getValue());
	 * 
	 * productRepository.save(product);
	 * 
	 * }
	 */
		
	}
}	


	
		

