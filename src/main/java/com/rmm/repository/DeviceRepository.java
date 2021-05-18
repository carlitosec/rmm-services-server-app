/**
 * 
 */
package com.rmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rmm.model.Device;

/**
 * @author ccarrillo
 *
 */
public interface DeviceRepository extends JpaRepository<Device, Long>{
//	List<Device> findAll();
}
