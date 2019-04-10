package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Fuel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFuel;
	private String type;
	private String Price;
	private Float amount;
	private List<FuelOrder>fuelorders;
	private List<GasPump> gaspumps;
	@OneToMany(mappedBy="fuel")
	public List<FuelOrder> getFuelorders() {
		return fuelorders;
	}
	public void setFuelorders(List<FuelOrder> fuelorders) {
		this.fuelorders = fuelorders;
	}
	@OneToMany(mappedBy="fuel")
	public List<GasPump> getGaspumps() {
		return gaspumps;
	}
	public void setGaspumps(List<GasPump> gaspumps) {
		this.gaspumps = gaspumps;
	}
	@Id
	public int getIdFuel() {
		return idFuel;
	}
	public void setIdFuel(int idFuel) {
		this.idFuel = idFuel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Fuel [idFuel=" + idFuel + ", type=" + type + ", Price=" + Price + ", amount=" + amount + "]";
	}
	public Fuel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fuel(int idFuel, String type, String price, Float amount) {
		super();
		this.idFuel = idFuel;
		this.type = type;
		Price = price;
		this.amount = amount;
	}
	
}
