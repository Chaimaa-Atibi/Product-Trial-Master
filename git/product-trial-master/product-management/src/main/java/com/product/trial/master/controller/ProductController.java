package com.product.trial.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.trial.master.model.Product;
import com.product.trial.master.model.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductByID(@PathVariable Long id) {
	    return (ResponseEntity<Product>) productRepository.findById(id)
	        .map(product -> ResponseEntity.ok(product))
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		return productRepository.findById(id)
                .map(product -> {
                	product.setCode(productDetails.getCode());
                	product.setName(productDetails.getName());
                    product.setDescription(productDetails.getDescription());
                    product.setImage(productDetails.getImage());
                    product.setCategory(productDetails.getCategory());
                    product.setPrice(productDetails.getPrice());
                    product.setQuantity(productDetails.getQuantity());
                    product.setInternalReference(productDetails.getInternalReference());
                    product.setShellId(productDetails.getShellId());
                    product.setInventoryStatus(productDetails.getInventoryStatus());
                    product.setRating(productDetails.getRating());
                    product.setCreatedAt(productDetails.getCreatedAt());
                    product.setUpdatedAt(productDetails.getUpdatedAt());
                    return ResponseEntity.ok(productRepository.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		return productRepository.findById(id)
				.map(product -> {
					productRepository.delete(product);
					return (ResponseEntity) ResponseEntity.noContent().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
