package services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import persistence.Experience;
import persistence.JobOffer;
import persistence.JobRequest;
import persistence.Skills;
import persistence.User;
import utils.Degree;


@Stateless
public class JobRequestService implements JobRequestServiceRemote,JobRequestServiceLocal{
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;
	@Override
	public void addJobRequest(JobRequest jobRequest) {
      entityManager.persist(jobRequest);		
	}
	@Override
	public int countYearExperience(JobRequest jobRequest) {
		int nb=0;
     for(Experience exp:jobRequest.getExperiences())
     {
    	
    	 long de=exp.getEndDate().getTime();
    	long ds=exp.getStartDate().getTime();
    	long diff =de-ds;
    	 long t = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    	int m = Integer.parseInt((t/30)+"");
    	
    	nb=nb+m;
    	
         }
     float x=(float) nb/12;
     
     jobRequest.setNbYearExperience(Math.round(x));
	 entityManager.merge(jobRequest);
     return Math.round(x);
	}
	@Override
	public JobRequest findJobRequestById(int id) {
		return entityManager.find(JobRequest.class, id);
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
		List<Skills> skillsforJob=jobRequest.getJobOffer().getDemandedskills();
		List<Skills> skillsAPPLIED=jobRequest.getSkills();
		for(int i=0;i<skillsforJob.size();i++)
		{		Skills skillforjob=skillsforJob.get(i);

			for(int j=0;j<skillsAPPLIED.size();j++)
			{
				Skills skillApp=skillsAPPLIED.get(j);
		int k=skillApp.getDescription().toUpperCase().indexOf(skillforjob.getDescription().toUpperCase());
				
				if(i!=-1)
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
		
}
