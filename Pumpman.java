package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
@Entity

public class Pumpman extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Hours;
	private List<Report> reports;
	@OneToMany(mappedBy="pumpman")
	public List<Report> getReports() {
		return reports;
	}
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Integer getHours() {
		return Hours;
	}

	public void setHours(Integer hours) {
		Hours = hours;
	}
	
}
