package tn.esprit.ManagedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Skills;
import services.SkillsService;
import utils.Degree;

@ManagedBean
@SessionScoped
public class SkillBean {
	 private int id;
	 private String description;
	 private Degree degree;
	 
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public SkillsService getSkillsService() {
		return skillsService;
	}
	public void setSkillsService(SkillsService skillsService) {
		this.skillsService = skillsService;
	}
@EJB
SkillsService skillsService;
	public SkillBean() {
super();	
}
public void addSkill(int idj){
	Skills s=new Skills();
	s.setDescription(description);
	s.setDegree(degree);
	int i=skillsService.createSkill(s);
	skillsService.affecterSkillJobOffer(idj, i);
}
}
