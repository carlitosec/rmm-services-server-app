/**
 * 
 */
package com.rmm.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rmm.Application;
import com.rmm.model.Customer;
import com.rmm.model.Device;
import com.rmm.service.DeviceService;

/**
 * @author ccarrillo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DeviceControllerIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private DeviceService deviceService;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testNewDevice() {
		
		Customer customer = new Customer("Carlos");
		customer.setId(20L);
		
		Device device = new Device("Device", "Unix");

		HttpEntity<Device> entity = new HttpEntity<Device>(device, headers);

		ResponseEntity<Device> response = restTemplate.exchange(
				createURLWithPort("/rmm/devices/" + customer.getId()),
				HttpMethod.POST, entity, Device.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertThat(actual.contains("/rmm/devices/20")).isNotNull();
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
