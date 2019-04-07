package tn.esprit.lavage.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.entity.Material;
import tn.esprit.lavage.entity.Product;


@Remote
public interface MaterialServiceRemote {
	public void AjouterMaterial(Material material);
	public List<Material> FindAllMaterial();
	List<Material> FindProductByName(String name);
	public void deletematerial(Material material);
	public void updateMaterialName(String i,String descrip,float prix,int sto,int id);
}
