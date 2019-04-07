package tn.esprit.lavage.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.lavage.entity.Appointment;
import tn.esprit.lavage.entity.Material;
import tn.esprit.lavage.entity.Product;

@Stateless
public class MaterialService implements MaterialServiceRemote {
	@PersistenceContext(unitName="lavage-ejb")
	EntityManager em ;

	@Override
	public void AjouterMaterial(Material material) {
		em.persist(material);
		em.merge(material);
		material.setAvaible(true);
		
	}

	@Override
	public List<Material> FindAllMaterial() {
		TypedQuery<Material> query= em.createQuery("SELECT c FROM Material c ", Material.class);
		return query.getResultList();
	}

	@Override
	public List<Material> FindProductByName(String name) {
		return em.createQuery("SELECT c FROM Material c WHERE c.materialName="+name, Material.class).getResultList();
	}

	@Override
	public void deletematerial(Material material) {
		em.remove(em.merge(material));
		
	}

	@Override
	public void updateMaterialName(String i, String descrip, float prix,int sto, int id) {
		Material p= em.find(Material.class, id);
		p.setMaterialName(i);
	
		p.setDescription(descrip);
		p.setPrice(prix);
		p.setStock(sto);
	
		
	}

	


}
