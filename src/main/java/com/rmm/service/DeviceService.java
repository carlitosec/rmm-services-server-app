/**
 * 
 */
package com.rmm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmm.model.Device;
import com.rmm.repository.DeviceRepository;

/**
 * @author ccarrillo
 *
 */
@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public List<Device> findAll() {
		List<Device> devices = new ArrayList<Device>();
		deviceRepository.findAll().forEach(devices::add);
		return devices;
	}
	
	public Optional<Device> findById(Long id) {
		return deviceRepository.findById(id);
	}
	
	public Device save(Device device) {
		return deviceRepository.save(new Device(null, device.getSystemName(), device.getType()));
	}
	
	public void delete(Long id) {
		deviceRepository.deleteById(id);
	}
}
