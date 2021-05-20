/**
 * 
 */
package com.rmm.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.rmm.model.Product;

/**
 * @author ccarrillo
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ProductRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
    
	@Test
	public void testSaveNewProduct() {
		Product product = new Product("Antivirus", 20.00);
		entityManager.persist(product);
		
		Product productTest = productRepository.findById(product.getId()).get();
		assertThat(productTest.getDescription()).isEqualTo("Antivirus");
		
	}
	
	@Test
	public void testSaveNewProductNotFound() {
		Product product = new Product("Antivirus", 20.00);
		entityManager.persist(product);
		
		Product productTest = productRepository.findById(product.getId()).get();
		assertThat(productTest.getDescription()).isNotEqualTo("PSA");
		
	}
}
