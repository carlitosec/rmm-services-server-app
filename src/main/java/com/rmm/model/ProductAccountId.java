/**
 * 
 */
package com.rmm.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ccarrillo
 *
 */
@Embeddable
public class ProductAccountId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966031581605442507L;
	
	@Column(name = "device_id")
	private Long deviceId;
	
	@Column(name = "product_id")
	private Long productId;

	/**
	 * 
	 */
	public ProductAccountId() {
	}

	/**
	 * @param deviceId
	 * @param serviceId
	 */
	public ProductAccountId(Long deviceId, Long productId) {
		this.deviceId = deviceId;
		this.productId = productId;
	}

	/**
	 * @return the deviceId
	 */
	public Long getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deviceId, productId);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		 
        if (obj == null || getClass() != obj.getClass())
            return false;
 
        ProductAccountId that = (ProductAccountId) obj;
        return Objects.equals(deviceId, that.deviceId) &&
               Objects.equals(productId, that.productId);
	} 
}
