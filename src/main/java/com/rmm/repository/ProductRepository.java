/**
 * 
 */
package com.rmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmm.model.Product;

/**
 * @author ccarrillo
 *
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{

}
