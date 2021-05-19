/**
 * 
 */
package com.rmm;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rmm.model.Device;
import com.rmm.repository.DeviceRepository;

/**
 * @author ccarrillo
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
    DataSource dataSource;
	
	@Autowired
	DeviceRepository deviceRepository;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
//        Device device = new Device(4L, "Testing", "Unix");
//        deviceRepository.save(device);
//        System.out.println("After saving record from class");
    }
}
