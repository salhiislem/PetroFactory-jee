package persistence;

import java.io.Serializable;
import javax.persistence.*;

import utils.Degree;

/**
 * Entity implementation class for Entity: Skills
 *
 */
@Entity

public class Skills implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 private String description;
	 private Degree degree;
	 @ManyToOne
		private JobRequest jobrequest;
	 @ManyToOne
		private JobOffer jobOffer;
	private static final long serialVersionUID = 1L;

	public JobRequest getJobrequest() {
		return jobrequest;
	}

	public void setJobrequest(JobRequest jobrequest) {
		this.jobrequest = jobrequest;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Skills() {
		super();
	}
   
}
