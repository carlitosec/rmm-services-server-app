/**
 * 
 */
package com.rmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmm.model.Customer;

/**
 * @author ccarrillo
 *
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
