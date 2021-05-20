/**
 * 
 */
package com.rmm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmm.model.Product;
import com.rmm.repository.ProductRepository;

/**
 * @author ccarrillo
 *
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

}
