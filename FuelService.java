package tn.esprit.petroFact.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.petroFact.entity.Fuel;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.entity.Pumpman;
import tn.esprit.petroFact.entity.Report;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FuelService implements FuelServiceRemote {
	
	@PersistenceContext(unitName="petroFactory-ejb")
	EntityManager em;
	@Override
	public void ajouterFuel( Fuel f){
		em.persist(f);
	}
	@Override
	public void deleteFuel(int id) {
		em.remove(em.find(Fuel.class, id));		
	}
	@Override
	public void updateFuel(float p, int id) {
		Fuel f=em.find(Fuel.class, id);
		f.setPrice(p);
		
	}
	
	@Override
	public List<Fuel> fuels(){
		TypedQuery<Fuel> query = em.createQuery("SELECT a FROM Fuel a  ", Fuel.class);
		 List<Fuel> fuel = query.getResultList();
		 /*for(int i=0; i<shop.size(); i++)
		 {shop s= shop.get(i);
		 }*/
		return fuel;
	}
	
	@Override
	public List<PumpMeter> pms(){
		TypedQuery<PumpMeter> query = em.createQuery("SELECT pm FROM PumpMeter pm  ", PumpMeter.class);
		 List<PumpMeter> pm = query.getResultList();
		return pm;
	}
	
	@Override
	public void ajouterGas(GasPump g) {
		em.persist(g);
		
	}
	@Override
	public void deleteGas(int id) {
		em.remove(em.find(GasPump.class, id));		
	}
	@Override
	public void updateGas(float am, int id) {
		GasPump f=em.find(GasPump.class, id);
		f.setAmount(am);
		
	}
	@Override
	public void ajouterPump(PumpMeter pm) {
		em.persist(pm);
		
	}
	@Override
	public void deletePump(int id) {
		em.remove(em.find(PumpMeter.class, id));
		
	}
	@Override
	public void updatePump(float m, int id) {
		PumpMeter pm=em.find(PumpMeter.class, id);
		pm.setAmountSold(m);
		
	}
	@Override
	public void affecterPm(int id1, int id2) {
		GasPump g =em.find(GasPump.class, id2);
		PumpMeter pm = em.find(PumpMeter.class, id1);
		pm.setGaspump(g);
		
	}
	@Override
	public void affecterPmToPm(int id1, int id2) {
		Pumpman p = em.find(Pumpman.class, id2);
		PumpMeter pm = em.find(PumpMeter.class, id1);
		pm.setPumpman(p);
		
	}
	@Override
	public GasPump getGas(int id) {
		return em.find(GasPump.class,id);
	}
	
	public PumpMeter getPm(int id) {
		return em.find(PumpMeter.class,id);
	}
	@Override
	public void ajouterRep(Report r) {
		em.persist(r);
		
	}
	@Override
	public void updateiA(float ia, int id) {
		Report f=em.find(Report.class, id);
		f.setInitialAmount(ia);
		
	}
	@Override
	public void updatefA(float fa, int id) {
		Report f=em.find(Report.class, id);
		f.setFinalAmount(fa);
		
	}
	@Override
	public void updategain(double gn, int id) {
		Report f=em.find(Report.class, id);
		f.setGain(gn);
	}
	@Override
	public void updateD(Date d, int id) {
		Report f=em.find(Report.class, id);
		f.setDate(d);
		
	}
	
	@Override
	public List<Report> reports() {
		TypedQuery<Report> query = em.createQuery("SELECT r FROM Report r  ", Report.class);
		 List<Report> r = query.getResultList();
		return r;
	}
	/*public String findbyType(){
		Query q = em.createQuery("SELECT r.type FROM Report r  ", Report.class);
		return q.getResultList();
		
	}
	
	@Override
	public boolean rechercher(String s){
	boolean verif=true;

	return verif;
	}*/
	@Override
	public void deleteRep(int id) {
		em.remove(em.find(Report.class, id));
	}
	
	@Override
	public Double calculFuel(float qtt) {
		GasPump g = new GasPump();
		return g.getAmount()*2.5;
	}
	@Override
	public List<GasPump> gaspumps() {
		TypedQuery<GasPump> query = em.createQuery("SELECT r FROM GasPump r  ", GasPump.class);
		 List<GasPump> r = query.getResultList();
		return r;
	}
	@Override
	public void updateType(String s, int id) {
		Report f=em.find(Report.class, id);
		f.setType(s);
		
	}
	
	
}
