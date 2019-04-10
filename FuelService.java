package tn.esprit.petroFact.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.petroFact.entity.Fuel;
@Stateless
public class FuelService implements FuelServiceRemote {
	
	@PersistenceContext(unitName="petroFactory-ejb")
	EntityManager em;
	
	public int ajouterFuel( Fuel f){
		em.persist(f);
		return f.getIdFuel();
	}

	public void deleteFuel(int id) {
		em.remove(em.find(Fuel.class, id));		
	}
	
	
	public void updateFuel(float am, int id) {
		Fuel f=em.find(Fuel.class, id);
		f.setAmount(am);
		
	}

}
