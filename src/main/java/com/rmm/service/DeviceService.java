/**
 * 
 */
package com.rmm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rmm.model.Device;
import com.rmm.repository.CustomerRepository;
import com.rmm.repository.DeviceRepository;

/**
 * @author ccarrillo
 *
 */
@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Device> findAll(Long customerId) {
//		List<Device> devices = new ArrayList<Device>();
//		deviceRepository.findAll().forEach(devices::add);
//		return devices;
		return deviceRepository.findByCustomerId(customerId);
	}
	
	public Optional<Device> findById(Long id) {
		return deviceRepository.findById(id);
	}
	
	public Device save(Device device) {
		return deviceRepository.save(new Device(device.getSystemName(), device.getType()));
	}
	
	public Device save(Long customerId, Device device) throws Exception{
		return customerRepository.findById(customerId).map(customer -> {
			device.setCustomer(customer);
			return deviceRepository.save(device);
		}).orElseThrow(() -> new Exception("Customer not found"));
	}
	
	public void delete(Long id) {
		deviceRepository.deleteById(id);
	}
	
	public ResponseEntity<?> delete(Long id, Long customerId) throws Exception {
		return deviceRepository.findByIdAndCustomerId(id, customerId).map(device -> {
			deviceRepository.delete(device);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception(
	            "Device not found with id " + id + " and customerId " + customerId));
	}
}
