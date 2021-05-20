/**
 * 
 */
package com.rmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmm.model.ProductAccount;
import com.rmm.model.ProductAccountId;

/**
 * @author ccarrillo
 *
 */
@Repository
@Transactional
public interface ProductAccountRepository extends JpaRepository<ProductAccount, ProductAccountId>{

}
