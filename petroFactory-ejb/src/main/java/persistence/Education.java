package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Education
 *
 */
@Entity

public class Education implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 private String institution;
	 @Temporal(TemporalType.DATE)
	 private Date StartDate;
	 @Temporal(TemporalType.DATE)
	 private Date EndDate;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Education() {
		super();
	}
   
}
