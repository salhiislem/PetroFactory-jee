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
	private static int jobchosen;
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 private String position;
	 private String positionDes;
	 private int MinimumExperience;
	 private double Salary;
	 @OneToMany (mappedBy="jobOffer",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
		private List<Skills> Demandedskills;
	private static final long serialVersionUID = 1L;

	public JobOffer(String position, String positionDes, int minimumExperience) {
		super();
		this.position = position;
		this.positionDes = positionDes;
		MinimumExperience = minimumExperience;
	}


	public String getPositionDes() {
		return positionDes;
	}


	public double getSalary() {
		return Salary;
	}


	public void setSalary(double salary) {
		Salary = salary;
	}


	public void setPositionDes(String positionDes) {
		this.positionDes = positionDes;
	}


	public int getId() {
		return id;
	}

	
	public JobOffer(String position, String positionDes, int minimumExperience, double salary) {
		super();
		this.position = position;
		this.positionDes = positionDes;
		this.MinimumExperience = minimumExperience;
		this.Salary = salary;
	}


	public static int getJobchosen() {
		return jobchosen;
	}


	public static void setJobchosen(int jobchosen) {
		JobOffer.jobchosen = jobchosen;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "JobOffer [nbMinYearExperience=" + MinimumExperience + "]";
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
