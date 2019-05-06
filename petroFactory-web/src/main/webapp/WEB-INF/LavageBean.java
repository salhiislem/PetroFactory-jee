package tn.esprit.lavage.presentation.mbeans;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.entity.SendingMail;
import tn.esprit.lavage.services.LavageService;


@Named("lavageBean")
@ManagedBean
@SessionScoped
public class LavageBean {


	private String NationalIdCard;
	private String UserName ;
	private String TypeOfCar;
	private Date dateAppointment;
	private Time TimeAppointment ;
	private List<Appointment>appointments ;
	private String RegistrationNumber ;
	private String telephoneNumber ;
	
	
	
	
	
	

	@EJB
	LavageService lavageservice ;

public String ajouterAppointment ()
{

Appointment app =  new Appointment();
app.setNationalIdCard(NationalIdCard);
app.setUserName(UserName);
app.setTypeOfCar(TypeOfCar);
app.setRegistrationNumber(RegistrationNumber);
app.setTelephoneNumber(telephoneNumber);
lavageservice.AjouterAppointment(app);

return null ;
}
public float calculer ()
{
	float  somme = 0;
	appointments = lavageservice.FindAllAppointment() ;
	for(int i=0;i<appointments.size();i++)
	{
		
		somme+=appointments.get(i).getTotalappointment();
		
		
	}
	System.out.println(somme);
	return somme;
	
}
public  List<Appointment>  recherche (String name )
{
	appointments=lavageservice.FindAppointmentByName(name);


return appointments ;
}

public void sendingMail ()
{
SendingMail s = new SendingMail();
s.envoyer("aa", "dd");


}



	public String getNationalIdCard() {
		return NationalIdCard;
	}







	public void setNationalIdCard(String nationalIdCard) {
		NationalIdCard = nationalIdCard;
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
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
}
