/**
 * 
 */
package com.rmm.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmm.model.Customer;
import com.rmm.model.Device;
import com.rmm.model.Product;
import com.rmm.model.ProductAccount;
import com.rmm.model.ProductAccountId;
import com.rmm.repository.CustomerRepository;
import com.rmm.repository.DeviceRepository;
import com.rmm.repository.ProductAccountRepository;
import com.rmm.repository.ProductRepository;

/**
 * @author ccarrillo
 *
 */
@Service
public class ProductAccountService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductAccountRepository productAccountRepository;
	
	public void save(Long deviceId, Long productId) {
		Device device = deviceRepository.findById(deviceId).get();
		Product product = productRepository.findById(productId).get();
		ProductAccountId pId = new ProductAccountId(deviceId, productId);
		
		/* Validate if product exists in Customer account */
		ProductAccount productAccount = productAccountRepository.findById(pId).get();
		if (productAccount == null) {
			productAccount = new ProductAccount(pId, device, product, new Timestamp(new Date().getTime()));
			productAccountRepository.save(productAccount);
		}
	}
	
	public Double getTotalMonthlyCost(Long customerId, int month, int year) {
		Customer customer = customerRepository.findById(customerId).get();
		Double totalMonthlyCost = 0.0;
		
		if (customer != null) {
			List<Device> devicesByCustomer = customer.getDevices();
			
			for(Device device : devicesByCustomer) {
				Iterator<ProductAccount> productIterator = device.getProductAccount().iterator();
				while(productIterator.hasNext()) {
					totalMonthlyCost += productIterator.next().getProduct().getPrice();
				}
			}
			
		}
		
		return totalMonthlyCost;
	}
}
