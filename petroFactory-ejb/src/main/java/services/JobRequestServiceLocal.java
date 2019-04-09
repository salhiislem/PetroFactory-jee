package services;

import javax.ejb.Local;

import persistence.JobOffer;
import persistence.JobRequest;
import utils.Degree;

@Local
public interface JobRequestServiceLocal {
	public void addJobRequest(JobRequest jobRequest);
	public int countYearExperience(JobRequest jobRequest);
	public JobRequest findJobRequestById(int id);
	public int numberSkillsApproved(JobRequest jobRequest);
	public int findDegreeIndex(Degree d);
	}
