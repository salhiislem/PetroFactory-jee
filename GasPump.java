package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="gaspump")
public class GasPump implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idG;
	private Integer num;
	private Float amount;
	private String Type;
	private List<PumpMeter> pumpmeters = new ArrayList<>();
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdG() {
		return idG;
	}
	@OneToMany(mappedBy="gaspump",cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
	public List<PumpMeter> getPumpmeters() {
		return pumpmeters;
	}
	public void setPumpmeters(List<PumpMeter> pumpmeters) {
		this.pumpmeters = pumpmeters;
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
	public GasPump(Float amount) {
		super();
		this.amount = amount;
	}
	public GasPump() {
		
	}
	
	public GasPump(Integer num, Float amount, String type) {
		super();
		this.num = num;
		this.amount = amount;
		this.Type = type;
	}
	
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "GasPump [num=" + num + ", amount=" + amount + ", Type=" + Type + "]";
	}
	
		
}
