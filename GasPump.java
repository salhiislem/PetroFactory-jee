package tn.esprit.petroFact.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class GasPump implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idG;
	private Float amount;
	private Fuel fuel;
	@ManyToOne
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	
	@Id
	public Integer getIdG() {
		return idG;
	}
	
	public void setIdG(Integer idG) {
		this.idG = idG;
	}
	
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
		
}
