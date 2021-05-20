/**
 * 
 */
package com.rmm.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.rmm.model.Customer;
import com.rmm.model.Device;
import com.rmm.model.Product;
import com.rmm.model.ProductAccount;
import com.rmm.model.ProductAccountId;

/**
 * @author ccarrillo
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ProductAccountRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ProductAccountRepository productAccountRepository;
	
	@Test
	public void testSaveNewProductAccount() {
		Device device = new Device("iPhone", "iOS");
		Customer customer = new Customer("Carlos");
		entityManager.persist(customer);
		device.setCustomer(customer);
		entityManager.persist(device);
		
		Product product = new Product("Antivirus", 30.00);
		entityManager.persist(product);
		
		ProductAccountId productAccountId = new ProductAccountId(device.getId(), product.getId());
		
		Date date = new Date();
		
		ProductAccount productAccount = new ProductAccount(productAccountId, device, product, new Timestamp(date.getTime()));
		entityManager.persist(productAccount);
		
		ProductAccount productAccountTest = productAccountRepository.findById(productAccount.getId()).get();
		
		assertThat(productAccountTest.getDevice().getCustomer().getCustomerName())
			.isEqualTo("Carlos");
		
		assertThat(productAccountTest.getProduct().getPrice())
			.isGreaterThan(10.00);
		
	}
}
