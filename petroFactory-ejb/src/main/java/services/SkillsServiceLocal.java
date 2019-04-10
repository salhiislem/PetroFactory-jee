package services;

import java.util.List;

import javax.ejb.Local;

import persistence.JobOffer;
import persistence.JobRequest;
import persistence.Skills;

@Local
public interface SkillsServiceLocal {
	public List<Skills> findSkillsByJobRequest(JobRequest job);
	public List<Skills> findSkillsByJobOffer(JobOffer job);
	public int numberSkillsApproved(JobRequest jobRequest);

}
