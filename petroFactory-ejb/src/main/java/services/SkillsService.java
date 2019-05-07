package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.JobOffer;
import persistence.JobRequest;
import persistence.Skills;

import utils.Degree;

@Stateless
@LocalBean
public class SkillsService implements SkillsServiceRemote {
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;

	@Override
	public List<Skills> findSkillsByJobRequest(JobRequest job) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Skills u WHERE jobrequest=:param");
		
		return (List<Skills>) query.setParameter("param",job).getResultList();
	
	}

	@Override
	public List<Skills> findSkillsByJobOffer(JobOffer job) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Skills u WHERE jobOffer=:param");
		
		return (List<Skills>) query.setParameter("param",job).getResultList();
	
	}
	public int findDegreeIndex(Degree d)
	{
		Degree tab[] = {Degree.Beginner, Degree.Intermediate, Degree.Advanced ,Degree.Expert};
		int i=0;
		while((i<tab.length)&&(!(tab[i]==d)))
		{
			i++;
		}
			if(tab[i]==d)
			{
				return i;
			}
			return -1;
	}
	
	@Override
	public int numberSkillsApproved(JobRequest jobRequest) {
		int nb=0;
		List<Skills> skillsforJob=findSkillsByJobOffer(jobRequest.getJobOffer());
		List<Skills> skillsAPPLIED=findSkillsByJobRequest(jobRequest);
		for(int j=0;j<skillsAPPLIED.size();j++)
		{						Skills skillApp=skillsAPPLIED.get(j);

			for(int i=0;i<skillsforJob.size();i++)
			{
				Skills skillforjob=skillsforJob.get(i);

		int k=skillApp.getDescription().toUpperCase().indexOf(skillforjob.getDescription().toUpperCase());
				
				if(k!=-1)
			{
					int x=findDegreeIndex(skillApp.getDegree());
					int y=findDegreeIndex(skillforjob.getDegree());
					if(x>=y)
					{
						nb++;

					}
				}
			}
		}
		
		return nb;
	}

	@Override
	public void affecterSkillJobOffer(int idj, int idski) {
		Skills skillManagedEntity = entityManager.find(Skills.class, idski);
		JobOffer jobManagedEntity = entityManager.find(JobOffer.class, idj);

		skillManagedEntity.setJobOffer(jobManagedEntity);		
	}

	@Override
	public void affecterSkillJobRequest(int idj, int idski) {
		Skills skillManagedEntity = entityManager.find(Skills.class, idski);
		JobRequest jobManagedEntity = entityManager.find(JobRequest.class, idj);

		skillManagedEntity.setJobrequest(jobManagedEntity);			
	}

	public int createSkill(Skills s) {
        entityManager.persist(s);
        return s.getId();
	}
	@Override
	public List<Skills> findByJobOffer(int jobId) {
		JobOffer job = entityManager.find(JobOffer.class,jobId);

		Query query = entityManager.createQuery(
				"SELECT u FROM Skills u WHERE jobOffer=:param");
		
		return (List<Skills>) query.setParameter("param",job).getResultList();
	
	}
}
