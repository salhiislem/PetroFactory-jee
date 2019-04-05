package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idR;
	private Date date;
	private String type;
	private Float initialAmount;
	private Float finalAmount;
	private Double gain;
	private Pumpman pumpman;
	private PumpMeter pumpmeter;
	
	@Override
	public String toString() {
		return "Report [idR=" + idR + ", date=" + date + ", type=" + type + ", initialAmount=" + initialAmount
				+ ", finalAmount=" + finalAmount + ", gain=" + gain + "]";
	}
	@ManyToOne
	@JoinColumn(name="idPumpman",referencedColumnName="id",insertable=false,updatable=false)
	public Pumpman getPumpman() {
		return pumpman;
	}
	public void setPumpman(Pumpman pumpman) {
		this.pumpman = pumpman;
	}
	
	@ManyToOne
	@JoinColumn(name="idPumpMeter",referencedColumnName="idPM",insertable=false,updatable=false)
	public PumpMeter getPumpmeter() {
		return pumpmeter;
	}
	public void setPumpmeter(PumpMeter pumpmeter) {
		this.pumpmeter = pumpmeter;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdR() {
		return idR;
	}
	public void setIdR(Integer idR) {
		this.idR = idR;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(Float initialAmount) {
		this.initialAmount = initialAmount;
	}
	public Float getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Float finalAmount) {
		this.finalAmount = finalAmount;
	}
	public Double getGain() {
		return gain;
	}
	public void setGain(Double gain) {
		this.gain = gain;
	}
	public Report(Date date, String type, Float initialAmount, Float finalAmount, Double gain) {
		this.date = date;
		this.type = type;
		this.initialAmount = initialAmount;
		this.finalAmount = finalAmount;
		this.gain = gain;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
