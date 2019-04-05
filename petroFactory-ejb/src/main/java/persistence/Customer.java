package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@DiscriminatorValue(value="Customer")
public class Customer extends User implements Serializable {

	private String numFidelityCard;
	
	private static final long serialVersionUID = 1L;

	public String getNumFidelityCard() {
		return numFidelityCard;
	}

	public void setNumFidelityCard(String numFidelityCard) {
		this.numFidelityCard = numFidelityCard;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Customer() {
		super();
	}
   
}
