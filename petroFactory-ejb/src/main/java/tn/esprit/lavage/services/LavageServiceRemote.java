package tn.esprit.lavage.services;





import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.entity.Options;
import tn.esprit.lavage.entity.Product;
import tn.esprit.lavage.entity.Worker;

@Remote
public interface LavageServiceRemote {

public void AjouterAppointment(Appointment appointment);
public List<Appointment> FindAllAppointment();
public void affecterDeviceAEmployee(Integer deviceUniqueIdentifier, Integer employeeMatricule);
public List<Worker> FindAllWorkers();
public List<Appointment> FindListAppointment(String username);
List<Worker> FindProductByAvaible(boolean avaible);
 List<Options> FindAllOptions(int i);
 List<Appointment> FindAllappo(int i);
 public void finishappointment(int i);
 public List<Appointment> FindListappoint();
 public List<Appointment> FindAppointment(LocalDate date);
 public void AjouterOption(int i,Options option);
 public List<Appointment> FindAllAppointmentparid(int i);
public int nombreappointment ();
public Long nombreappointmentunfinished ();
}
