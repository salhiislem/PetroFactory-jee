package services;

import java.util.List;

import javax.ejb.Local;

import persistence.JobOffer;
import persistence.JobRequest;
import utils.Degree;

@Local
public interface JobRequestServiceLocal {
	public void addJobRequest(JobRequest jobRequest);
	public int countYearExperience(JobRequest jobRequest);
	public JobRequest findJobRequestById(int id);
	//public int numberSkillsApproved(JobRequest jobRequest);
	public int findDegreeIndex(Degree d);
	public List<JobRequest> findByJobOffer(JobOffer job);
	public List<JobRequest> findALL();
	public List<JobRequest> SortBySkill();
	public void adjustJobRequestBYOffer(JobOffer job);
	public void updateJob(JobRequest job);
	public void adjustJobRequestBYOfferEXP(JobOffer job);
	public List<JobRequest> SortByEXP();

}