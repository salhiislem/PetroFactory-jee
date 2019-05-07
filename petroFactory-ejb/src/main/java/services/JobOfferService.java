package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.JobOffer;
import persistence.Skills;

@Stateless
@LocalBean
public class JobOfferService implements JobOfferServiceRemote {
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;

	@Override
	public List<JobOffer> findAllOffers() {
		Query query = entityManager.createQuery(
				"SELECT u FROM JobOffer u");
		return (List<JobOffer>) query.getResultList();	}
	
	@Override
	public JobOffer findOfferById(int id) {
		Query query = entityManager.createQuery(
				"SELECT u FROM JobOffer u where u.id=:param");
		return (JobOffer) query.setParameter("param",id).getSingleResult();	}
	
    public int createJobOffer(JobOffer j)
{   
	entityManager.persist(j);
	return j.getId();
	}
  
    
}
