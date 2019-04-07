package tn.esprit.lavage.services;


import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.entity.Options;
import tn.esprit.lavage.entity.Product;
import tn.esprit.lavage.entity.Worker;


@Stateless
public class LavageService implements LavageServiceRemote {
	
	@PersistenceContext(unitName="lavage-ejb")
	EntityManager em ;

	public void AjouterAppointment(Appointment appointment) {
		em.persist(appointment);
		appointment.setFinish("unfinish");
		
	}

	@Override
	public List<Appointment> FindAllAppointment() {
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c ", Appointment.class);
		return query.getResultList();
	}
	
	public void affecterDeviceAEmployee(Integer deviceUniqueIdentifier, Integer employeeMatricule) {
		Appointment deviceManagedEntity = em.find(Appointment.class, deviceUniqueIdentifier);
		Worker employeeManagedEntity = em.find(Worker.class, employeeMatricule);
		deviceManagedEntity.setWorker(employeeManagedEntity);
		employeeManagedEntity.setDisponible(false);
	}

	@Override
	public List<Worker> FindAllWorkers() {
		TypedQuery<Worker> query= em.createQuery("SELECT c FROM Worker c ", Worker.class);
		return query.getResultList();
	}

	@Override
	public List<Appointment> FindListAppointment(String username) {
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c WHERE c.userName="+username, Appointment.class);
		return query.getResultList();
	}

	@Override
	public List<Worker> FindProductByAvaible(boolean avaible) {
		return em.createQuery("SELECT c FROM Worker c WHERE c.disponible="+avaible, Worker.class).getResultList();
	}

	@Override
	public List<Options> FindAllOptions(int i) {
		
		Appointment employee = em.find(Appointment.class, i);
		return employee.getOptions();
		
	}

	@Override
	public List<Appointment> FindAllappo(int i) {
	Worker worker = em.find(Worker.class, i);
	return worker.getAppointment();
	}

	@Override
	public void finishappointment(int i) {
		Appointment appointment = em.find(Appointment.class, i);
		appointment.setFinish("finish");
		Worker worker =em.find(Worker.class,i);
		worker.setDisponible(true);
/*	List<Product>list=	FindAllPro();
	for(int j=0;j<list.size();j++)
	{
	
	int n=	list.get(i).getStock();
	n=	n-1;
	
		
		
		
	}*/
		
		
		
		
		
		
	}

	@Override
	public List<Appointment> FindListappoint() {
		String username="finish";
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c WHERE c.finish="+username, Appointment.class);
		return query.getResultList();
	}

	@Override
	public List<Appointment> FindAppointment(LocalDate date) {
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c WHERE c.dateAppointment="+date, Appointment.class);
		return query.getResultList();
	}



	@Override
	public void AjouterOption(int i, Options option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Appointment> FindAllAppointmentparid(int i) {
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c WHERE c.idAppointment="+i, Appointment.class);
		return query.getResultList();
	}


	@Override
	public Long nombreappointmentunfinished() {
	
		
		TypedQuery<Long> query= em.createQuery("SELECT COUNT(c)  FROM Appointment c WHERE c.finish="+"unfinish",Long.class);
		long s =query.getSingleResult();
		
		return s;
	}

	@Override
	public int nombreappointment() {
		String username="finish";
		TypedQuery<Appointment> query= em.createQuery("SELECT c FROM Appointment c WHERE c.finish="+username, Appointment.class);
List<Appointment>list=query.getResultList();
int c = 0 ;
for (int j=0;j<list.size();j++)
{
	
c++;



}
	return c;
	
	
	
	}





















	
	}


