/**
 * 
 */
package com.rmm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.model.Device;
import com.rmm.service.DeviceService;

/**
 * @author ccarrillo
 *
 */
@RestController
@RequestMapping("/rmm")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping("/devices")
	public ResponseEntity<List<Device>> getAllDevices() {
		List<Device> devices = deviceService.findAll();

		try {
			if (devices.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(devices, HttpStatus.OK);
	}

	@PostMapping("/devices")
	public ResponseEntity<Device> addDevice(@RequestBody Device device) {
		try {
			Device deviceTmp = deviceService.save(device);
			return new ResponseEntity<>(deviceTmp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/devices/{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable("id") Long id, @RequestBody Device device) {
		Optional<Device> deviceData = deviceService.findById(id);

		if (deviceData.isPresent()) {
			Device deviceTmp = deviceData.get();
			deviceTmp.setSystemName(device.getSystemName());
			deviceTmp.setType(device.getType());
			return new ResponseEntity<>(deviceService.save(deviceTmp), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/devices/{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable("id") Long id) {
		try {
			deviceService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
