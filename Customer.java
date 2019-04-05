package tn.esprit.petroFact.entity;

import java.io.Serializable;
import javax.persistence.Entity;
@Entity
public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
}
