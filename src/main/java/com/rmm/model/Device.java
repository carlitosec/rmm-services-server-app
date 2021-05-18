/**
 * 
 */
package com.rmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ccarrillo
 *
 */
@Entity
@Table(name="device")
public class Device implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3912007875313714203L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "system_name")
	private String systemName;
	
	@Column(name = "type")
	private String type;
	
	public Device() {}
	
	
	/**
	 * @param id
	 * @param systemName
	 * @param type
	 */
	public Device(Long id, String systemName, String type) {
		this.id = id;
		this.systemName = systemName;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
