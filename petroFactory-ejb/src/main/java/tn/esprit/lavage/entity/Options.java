package tn.esprit.lavage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Options")
public class Options  implements Serializable{
	private int idOption ;
	private String optionName  ;
	private float Optionprice ;
private Appointment appointment ;
	
	
	
	@Id
	public int getIdOption() {
		return idOption;
	}
	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public float getOptionprice() {
		return Optionprice;
	}
	public void setOptionprice(float optionprice) {
		Optionprice = optionprice;
	}
	
	
	@ManyToOne
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Options() {
		super();
	}
	public Options(int idOption, String optionName, float optionprice, Appointment appointment) {
		super();
		this.idOption = idOption;
		this.optionName = optionName;
		Optionprice = optionprice;
		this.appointment = appointment;
	}
	public Options(String optionName, float optionprice) {
		super();
		this.optionName = optionName;
		Optionprice = optionprice;
	}
	public Options(int idOption, String optionName, float optionprice) {
		super();
		this.idOption = idOption;
		this.optionName = optionName;
		Optionprice = optionprice;
	}
	@Override
	public String toString() {
		return "Options [idOption=" + idOption + ", optionName=" + optionName + ", Optionprice=" + Optionprice + "]";
	}


	
	


	}
