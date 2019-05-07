package tn.esprit.ManagedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Experience;
import services.ExperienceService;

@ManagedBean
@SessionScoped
public class ExperienceBean {
@EJB
ExperienceService expService;
private List<Experience> exps = new ArrayList<Experience>();
//not managed at all:
private Experience currentEXP;
private String desc;
private Date startD	;
private Date endD;

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public Date getStartD() {
	return startD;
}

public void setStartD(Date startD) {
	this.startD = startD;
}

public Date getEndD() {
	return endD;
}

public void setEndD(Date endD) {
	this.endD = endD;
}


public List<Experience> getExps() {
	return exps;
}

public Experience getCurrentEXP() {
	return currentEXP;
}

public void setCurrentEXP(Experience currentEXP) {
	this.currentEXP = currentEXP;
}

public void addCurrentexpToList() {
	int i=expService.createEXP(new Experience(startD,endD,desc));
	
    //exps=expService.findAllExperiencesby0();
    //init();
}
	public ExperienceBean() {
				super();	

	}

}
