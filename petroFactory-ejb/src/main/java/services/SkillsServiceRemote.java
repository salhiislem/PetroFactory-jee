package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.JobOffer;
import persistence.JobRequest;
import persistence.Skills;

@Remote
public interface SkillsServiceRemote {
public List<Skills> findSkillsByJobRequest(JobRequest job);
public List<Skills> findSkillsByJobOffer(JobOffer job);
public int numberSkillsApproved(JobRequest jobRequest);

}
