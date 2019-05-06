package tn.esprit.lavage.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.services.LavageService;

@SessionScoped
@ManagedBean

public class MyBean {
	private String UserName;
	private String TypeOfCar="bader";
	private Date dateAppointment ;
	private List<Appointment>appointments ;
	private String RegistrationNumber ;
	@EJB
	LavageService lavageservice ;
	
	public List<Appointment> AllAppointment()
	{
		appointments= lavageservice.FindAllAppointment();
		System.out.println(appointments);
		return appointments ;

	}
	
	public void  supprimerAppointment(int idP) 
	{
		
		lavageservice.supprimerAppointment(idP);
		

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

	public Date getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}

public List<Appointment> getAppointments() {
	return appointments;
}
public void setAppointments(List<Appointment> appointments) {
	this.appointments = appointments;
}

@Override
public String toString() {
	return "AppointmentBean [UserName=" + UserName + ", TypeOfCar=" + TypeOfCar + ", dateAppointment=" + dateAppointment
			+ ", RegistrationNumber=" + RegistrationNumber + "]";
}
}
