package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Fuel implements Serializable {

	private int idFuel;
	private String type;
	private Float Price;
	private List<FuelOrder>fuelorders;
	private List<GasPump> gaspumps;
	@OneToMany(mappedBy="fuel")
	public List<FuelOrder> getFuelorders() {
		return fuelorders;
	}
	public void setFuelorders(List<FuelOrder> fuelorders) {
		this.fuelorders = fuelorders;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		this.Price = price;
	}
	
	public Fuel() {
		super();
		
	}
	public Fuel(String type, Float price) {
		this.type = type;
		this.Price = price;
		
	}
	@Override
	public String toString() {
		return "Fuel [idFuel=" + idFuel + ", type=" + type + ", Price=" + Price + "]";
	}
	
	
}
