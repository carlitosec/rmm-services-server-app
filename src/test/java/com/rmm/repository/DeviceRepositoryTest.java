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

import com.rmm.model.Customer;
import com.rmm.model.Device;

/**
 * @author ccarrillo
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DeviceRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private DeviceRepository deviceRepository;
    
	@Test
	public void testSaveNewDevice() {
		Device device = new Device("iPhone", "iOS");
		Customer customer = new Customer("Carlos");
		entityManager.persist(customer);
		device.setCustomer(customer);
		entityManager.persist(device);
		Device deviceTest = deviceRepository.findById(device.getId()).get();
		assertThat(deviceTest.getSystemName()).isEqualTo("iPhone");
		
	}
	
	@Test
	public void testSaveNewDeviceNotFound() {
		Device device = new Device("iPhone", "iOS");
		Customer customer = new Customer("Carlos");
		entityManager.persist(customer);
		device.setCustomer(customer);
		entityManager.persist(device);
		Device deviceTest = deviceRepository.findById(device.getId()).get();
		assertThat(deviceTest.getSystemName()).isNotEqualTo("iPhone10");
		
	}
	

}
