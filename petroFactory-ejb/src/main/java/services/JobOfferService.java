package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.JobOffer;

@Stateless
public class JobOfferService implements JobOfferServiceLocal,JobOfferServiceRemote {
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

}
