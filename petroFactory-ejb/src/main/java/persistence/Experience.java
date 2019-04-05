package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Experience
 *
 */
@Entity

public class Experience implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 @Temporal(TemporalType.DATE)
	 private Date StartDate;
	 @Temporal(TemporalType.DATE)
	 private Date EndDate;
	 private String description;
	 @ManyToOne
		private JobRequest jobrequest;
	 
	public JobRequest getJobrequest() {
		return jobrequest;
	}

	public void setJobrequest(JobRequest jobrequest) {
		this.jobrequest = jobrequest;
	}

	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Experience() {
		super();
	}
   
}
