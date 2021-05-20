/**
 * 
 */
package com.rmm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Long id;
	
	@Column(name = "system_name")
	private String systemName;
	
	@Column(name = "type")
	private String type;
	
//	@ManyToOne(cascade = CascadeType.DETACH)
	@ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
	
	@OneToMany(mappedBy = "device")
	private Set<ProductAccount> productAccount = new HashSet<ProductAccount>();
	
	public Device() {}
	
	
	/**
	 * @param systemName
	 * @param type
	 */
	public Device(String systemName, String type) {
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


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @return the productAccount
	 */
	public Set<ProductAccount> getProductAccount() {
		return productAccount;
	}


	/**
	 * @param productAccount the productAccount to set
	 */
	public void setProductAccount(Set<ProductAccount> productAccount) {
		this.productAccount = productAccount;
	}
	
	
}
