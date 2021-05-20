/**
 * 
 */
package com.rmm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.model.Customer;
import com.rmm.model.Device;
import com.rmm.model.ProductAccount;
import com.rmm.service.CustomerService;
import com.rmm.service.ProductAccountService;

/**
 * @author ccarrillo
 *
 */
@RestController
@RequestMapping("/rmm")
public class ProductAccountController {
	
	@Autowired
	private ProductAccountService productAccountService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customerId}/productAccounts")
	public ResponseEntity<List<ProductAccount>> getAllProductAccounts(@PathVariable("customerId") Long customerId) {
		List<ProductAccount> productAccounts = new ArrayList<ProductAccount>();

		try {
			Customer customer = customerService.findById(customerId).get();
			
			for(Device device : customer.getDevices()) {
				Iterator<ProductAccount> iterator = device.getProductAccount().iterator();
				while(iterator.hasNext()) {
					productAccounts.add(iterator.next());
				}
			}
			
			if (productAccounts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productAccounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/productAccount/{deviceId}/{productId}")
	public void addProductToDevice(@PathVariable("deviceId") Long deviceId, @PathVariable("productId") Long productId) {
		productAccountService.save(deviceId, productId);
	}
	
	@GetMapping("/findTotalMonthlyCost/{customerId}/")
	public ResponseEntity<Double> findTotalMonthlyCostByCustomer(@PathVariable("deviceId") Long customerId) {
		Double totalMonthlyCost = 0.0;

		try {
			totalMonthlyCost = productAccountService.getTotalMonthlyCost(customerId, 0, 0);
			return new ResponseEntity<>(totalMonthlyCost, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/productAccount/{deviceId}/{productId}")
	public ResponseEntity<Device> deleteProductAccount(@PathVariable("deviceId") Long deviceId, @PathVariable("productId") Long productId) {
		try {
			productAccountService.delete(deviceId, productId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
			
}
