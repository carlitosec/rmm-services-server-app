/**
 * 
 */
package com.rmm.repository;

import java.util.List;
import java.util.Optional;

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
	List<Device> findByCustomerId(Long customerId);
	Optional<Device> findByIdAndCustomerId(Long id, Long customerId);
}
