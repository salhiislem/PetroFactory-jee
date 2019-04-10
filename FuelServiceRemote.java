package tn.esprit.petroFact.services;

import javax.ejb.Remote;

import tn.esprit.petroFact.entity.Fuel;

@Remote
public interface FuelServiceRemote {

	int ajouterFuel(Fuel f);
	void deleteFuel(int id);
	void updateFuel(float am,int id);
}
