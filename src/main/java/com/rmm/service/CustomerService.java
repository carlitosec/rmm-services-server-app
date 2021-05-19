/**
 * 
 */
package com.rmm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmm.model.Customer;
import com.rmm.repository.CustomerRepository;

/**
 * @author ccarrillo
 *
 */
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}
}
