package tn.esprit.lavage.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {
private int IdAppointment ;
private String NationalIdCard;
private String UserName ;
private String TypeOfCar;
private Date dateAppointment ;
private Time TimeAppointment ;
private String RegistrationNumber ;
private String telephoneNumber ;
private Worker worker ;
private Client client  ;
private List<Options> options ;
private String finish ;






@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getIdAppointment() {
	return IdAppointment;
}
public void setIdAppointment(int idAppointment) {
	IdAppointment = idAppointment;
}

public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getTypeOfCar() {
	return TypeOfCar;
}
public void setTypeOfCar(String typeOfCar) {
	TypeOfCar = typeOfCar;
}


@Temporal(TemporalType.DATE)
public Date getDateAppointment() {
	return dateAppointment;
}
public void setDateAppointment(Date dateAppointment) {
	this.dateAppointment = dateAppointment;
}


public Time getTimeAppointment() {
	return TimeAppointment;
}
public void setTimeAppointment(Time timeAppointment) {
	TimeAppointment = timeAppointment;
}
public String getRegistrationNumber() {
	return RegistrationNumber;
}
public void setRegistrationNumber(String registrationNumber) {
	RegistrationNumber = registrationNumber;
}
public String getTelephoneNumber() {
	return telephoneNumber;
}
public void setTelephoneNumber(String telephoneNumber) {
	this.telephoneNumber = telephoneNumber;
}

public Appointment() {

}
public Appointment(String userName, String typeOfCar, String telephoneNumber) {

	UserName = userName;
	TypeOfCar = typeOfCar;
	this.telephoneNumber = telephoneNumber;
}
public String getNationalIdCard() {
	return NationalIdCard;
}
public void setNationalIdCard(String nationalIdCard) {
	NationalIdCard = nationalIdCard;
}


public Appointment(String nationalIdCard, String userName, String typeOfCar, Date dateAppointment, Time timeAppointment,
		String registrationNumber, String telephoneNumber) {
	super();
	NationalIdCard = nationalIdCard;
	UserName = userName;
	TypeOfCar = typeOfCar;
	this.dateAppointment = dateAppointment;
	TimeAppointment = timeAppointment;
	RegistrationNumber = registrationNumber;
	this.telephoneNumber = telephoneNumber;
}
public Appointment(String nationalIdCard, String userName, String typeOfCar, String telephoneNumber) {
	super();
	NationalIdCard = nationalIdCard;
	UserName = userName;
	TypeOfCar = typeOfCar;
	this.telephoneNumber = telephoneNumber;
}
public Appointment(String nationalIdCard, String userName, String typeOfCar, Date dateAppointment,
		String registrationNumber, String telephoneNumber) {
	super();
	NationalIdCard = nationalIdCard;
	UserName = userName;
	TypeOfCar = typeOfCar;
	this.dateAppointment = dateAppointment;
	RegistrationNumber = registrationNumber;
	this.telephoneNumber = telephoneNumber;
}
@ManyToOne
public Worker getWorker() {
	return worker;
}
public void setWorker(Worker worker) {
	this.worker = worker;
}
@ManyToOne
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
@OneToMany(mappedBy="appointment",cascade ={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},fetch =FetchType.EAGER)
public List<Options> getOptions() {
	return options;
}
public void setOptions(List<Options> options) {
	this.options = options;
}
public String getFinish() {
	return finish;
}
public void setFinish(String finish) {
	this.finish = finish;
}
@Override
public String toString() {
	return "Appointment [IdAppointment=" + IdAppointment + ", NationalIdCard=" + NationalIdCard + ", UserName="
			+ UserName + ", TypeOfCar=" + TypeOfCar + ", dateAppointment=" + dateAppointment + ", TimeAppointment="
			+ TimeAppointment + ", RegistrationNumber=" + RegistrationNumber + ", telephoneNumber=" + telephoneNumber
			+ ", finish=" + finish + "]";
}











}
