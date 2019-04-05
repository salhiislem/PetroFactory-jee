package tn.esprit.petroFact.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.naming.NamingException;

import tn.esprit.petroFact.entity.Fuel;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.entity.Report;

@Remote
public interface FuelServiceRemote {


	void ajouterFuel(Fuel f);
	void ajouterGas(GasPump g);
	void ajouterPump(PumpMeter pm);
	void ajouterRep(Report r);
//******************************************//	
	void deleteFuel(int id);
	void deleteGas(int id);
	void deletePump(int id);
	void deleteRep(int id);
//******************************************//
	void updateFuel(float am,int id);
	void updateGas(float am,int id);
	void updatePump(float pm,int id);
	void updateiA(float ia,int id);
	void updatefA(float fa,int id);
	void updategain(double gn,int id);
	void updateD(Date d,int id);
	void updateType(String s,int id);
	
//******************************************//
	List<Fuel> fuels();
	GasPump getGas(int id);
	PumpMeter getPm(int id);
	List<PumpMeter> pms();
	List<Report> reports();
	List<GasPump>gaspumps();
//******************************************//	
	void affecterPm(int id1,int id2);
	void affecterPmToPm(int id1,int id2);

//******************************************//
	Double calculFuel(float qtt);
	//boolean rechercher(String s);
	
	
	
}
