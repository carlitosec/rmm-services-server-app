/**
 * 
 */
package com.rmm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author ccarrillo
 *
 */
@Entity
@Table(name="product_account")
public class ProductAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7551780398312262050L;
	
	@EmbeddedId
	private ProductAccountId id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("deviceId")
	private Device device;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("productId")
	private Product product;
	
	@Column(name="date_assigned")
	private Timestamp dateAssigned;
	
	public ProductAccount() {

	}

	
	
	/**
	 * @param id
	 * @param device
	 * @param product
	 * @param dateAssigned
	 */
	public ProductAccount(ProductAccountId id, Device device, Product product, Timestamp dateAssigned) {
		this.id = id;
		this.device = device;
		this.product = product;
		this.dateAssigned = dateAssigned;
	}



	/**
	 * @return the id
	 */
	public ProductAccountId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ProductAccountId id) {
		this.id = id;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}


	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the dateAssigned
	 */
	public Timestamp getDateAssigned() {
		return dateAssigned;
	}

	/**
	 * @param dateAssigned the dateAssigned to set
	 */
	public void setDateAssigned(Timestamp dateAssigned) {
		this.dateAssigned = dateAssigned;
	}
}
