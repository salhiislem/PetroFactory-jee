package tn.esprit.ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import persistence.JobOffer;
import persistence.Skills;
import services.JobOfferService;
import services.SkillsService;

@SessionScoped
@ManagedBean
public class JobOfferBean implements Serializable {
	private JobOffer jobSelected;
	private static final long serialVersionUID = 1L;
	private double salary;
	private List<JobOffer> jobOffers;
	  private int id;
		 private String position;
		 private int MinimumExperience;
			private List<Skills> Demandedskills;
			 private int idj;
			// @ManagedProperty("param.id")
			// private int idjj;
			
private String description;
	@EJB
	JobOfferService jobOfferService;
   SkillsService skillsService;
   @PostConstruct
public void init(){}
	public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Skills> getDemandedskills() {
	return Demandedskills;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getMinimumExperience() {
		return MinimumExperience;
	}

	public void setMinimumExperience(int minimumExperience) {
		MinimumExperience = minimumExperience;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double s) {
		this.salary = s;
	}
	public List<Skills> getDemandedskills(int idjob ) {
		Demandedskills=skillsService.findByJobOffer(idjob);
		return Demandedskills;
	}

	public void setDemandedskills(List<Skills> demandedskills) {
		Demandedskills = demandedskills;
	}

	public JobOfferService getJobOfferService() {
		return jobOfferService;
	}

	public void setJobOfferService(JobOfferService jobOfferService) {
		this.jobOfferService = jobOfferService;
	}

	public List<JobOffer> getJobOffers() {
		jobOffers= jobOfferService.findAllOffers();
		return jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JobOfferBean() {
		super();
	}
public String ajoutOffre()
{
	idj=jobOfferService.createJobOffer(new JobOffer(position,description,MinimumExperience,salary));
	return "/pages/AjoutSkillForJobOffer?faces-redirect=true";
	}
public int getIdj() {
	return idj;
}
public String afficheDetailJob(int idjj)
{	//Demandedskills=skillsService.findByJobOffer(idjj);
	 jobSelected=jobOfferService.findOfferById(idjj);
	return "/pages/detailJobOffer?faces-redirect=true";
	}
public void setIdj(int idj) 
{
	this.idj = idj;
}
public JobOffer getJobSelected() {
	return jobSelected;
}
public void setJobSelected(JobOffer jobSelected) {
	this.jobSelected = jobSelected;
}

}
