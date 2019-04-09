package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobOffer
 *
 */
@Entity

public class JobOffer implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 private String position;
	 private int nbMinYearExperience;
	 @OneToMany (mappedBy="jobOffer",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
		private List<Skills> Demandedskills;
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "JobOffer [nbMinYearExperience=" + nbMinYearExperience + "]";
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNbMinYearExperience() {
		return nbMinYearExperience;
	}

	public void setNbMinYearExperience(int nbMinYearExperience) {
		this.nbMinYearExperience = nbMinYearExperience;
	}

	public List<Skills> getDemandedskills() {
		return Demandedskills;
	}

	public void setDemandedskills(List<Skills> demandedskills) {
		Demandedskills = demandedskills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JobOffer() {
		super();
	}
   
}
