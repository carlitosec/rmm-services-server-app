/**
 * 
 */
package com.rmm.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.rmm.model.Customer;

/**
 * @author ccarrillo
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CustomerRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
    
	@Test
	public void testSaveNewCustomer() {
		Customer customer = new Customer("Carlos");
		entityManager.persist(customer);
		
		Customer customerTest = customerRepository.findById(customer.getId()).get();
		assertThat(customerTest.getCustomerName()).isEqualTo("Carlos");
		
	}
	
	@Test
	public void testSaveNewCustomerNotFound() {
		Customer customer = new Customer("Carlos");
		entityManager.persist(customer);
		
		Customer customerTest = customerRepository.findById(customer.getId()).get();
		assertThat(customerTest.getCustomerName()).isNotEqualTo("Carlos2");
		
	}
}
