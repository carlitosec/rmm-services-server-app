/**
 * 
 */
package com.rmm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.model.Device;
import com.rmm.repository.DeviceRepository;

/**
 * @author ccarrillo
 *
 */
@RestController
@RequestMapping("/rmm")
public class DeviceController {

	@Autowired
	private DeviceRepository deviceRepository;

	@GetMapping("/devices")
	public ResponseEntity<List<Device>> getAllDevices() {
		System.out.println("Entra aqui o no");
		List<Device> devices = new ArrayList<Device>();

		try {
			devices = deviceRepository.findAll();
			System.out.println("Despues foreach: " + devices.size());
			
			if (devices.isEmpty()) {
				System.out.println("es empty aqui o no");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			System.out.println("Exception aqui o no");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(devices, HttpStatus.OK);
	}
	
//	@GetMapping("/devices")
//	public List<Device> getAllDevices() {
//		return deviceRepository.findAll();
//	}
}
