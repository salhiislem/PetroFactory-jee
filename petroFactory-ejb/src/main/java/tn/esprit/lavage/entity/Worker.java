package tn.esprit.lavage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Worker")
public class Worker implements Serializable {

	private int idWorker ; 
	private String username ;
	private boolean disponible ;
	private List< Appointment> appointment ;
	
	
	
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	
	
	
	

	
	public String getUsername() {
		return username;
	}
	@Id 
	public int getIdWorker() {
	return idWorker;
}
public void setIdWorker(int idWorker) {
	this.idWorker = idWorker;
}
	public void setUsername(String username) {
		this.username = username;
	}
	@OneToMany(mappedBy="worker",cascade ={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},fetch =FetchType.EAGER)
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Worker [idWorker=" + idWorker + ", username=" + username + ", disponible=" + disponible
				+ ", appointment=" + appointment + "]";
	}




	
	
	
	
}
