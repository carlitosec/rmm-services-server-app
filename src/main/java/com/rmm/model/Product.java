/**
 * 
 */
package com.rmm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ccarrillo
 *
 */
@Entity
@Table(name="product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7551780398312262050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	@OneToMany(mappedBy = "product")
	private Set<ProductAccount> productAccount = new HashSet<ProductAccount>();
	
	public Product() {
		
	}
	
	/**
	 * @param description
	 * @param price
	 */
	public Product(String description, Double price) {
		this.description = description;
		this.price = price;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
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
