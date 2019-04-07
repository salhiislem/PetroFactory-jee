package tn.esprit.lavage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity

public class Client implements Serializable{
private int idclient ;
private String usernale ;
private List<Appointment> appointments ; 









@Id
public int getIdclient() {
	return idclient;
}



public void setIdclient(int idclient) {
	this.idclient = idclient;
}
public String getUsernale() {
	return usernale;
}
public void setUsernale(String usernale) {
	this.usernale = usernale;
} 

@OneToMany(mappedBy="client")
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
}
}
