package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Customer;
import persistence.Experience;
import persistence.JobRequest;
@Stateless
@LocalBean
public class ExperienceService implements ExperienceServiceRemote {
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;
	JobRequest j=null;
	   public int createEXP(Experience j)
	   {   
	   	entityManager.persist(j);
	   	return j.getId();
	   	}
	   public List<Experience> findAllExperiencesby0() {
			Query query = entityManager.createQuery(
					"SELECT u FROM Experience u where u.jobrequest=:param");
			return (List<Experience>) query.setParameter("param", null).getResultList();
}
	   }
