package tn.esprit.petroFact.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class FuelOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFO;
	private Float amount;
	private Double price;
	private Fuel fuel;
	@ManyToOne
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdFO() {
		return idFO;
	}
	public void setIdFO(Integer idFO) {
		this.idFO = idFO;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}