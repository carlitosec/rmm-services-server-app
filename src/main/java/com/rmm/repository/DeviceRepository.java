/**
 * 
 */
package com.rmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmm.model.Device;

/**
 * @author ccarrillo
 *
 */
@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long>{
}
