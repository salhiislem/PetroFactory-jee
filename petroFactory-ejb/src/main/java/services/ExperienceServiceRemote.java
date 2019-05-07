package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Experience;
import persistence.JobRequest;

@Remote
public interface ExperienceServiceRemote {
	   public int createEXP(Experience j);
	   public List<Experience> findAllExperiencesby0() ;

}
