package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Diploma
 *
 */
@Entity

public class Diploma implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 @Temporal(TemporalType.DATE)
	 private Date graduation;
	 @ManyToOne
		private JobRequest jobrequest;
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getGraduation() {
		return graduation;
	}

	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	public JobRequest getJobrequest() {
		return jobrequest;
	}

	public void setJobrequest(JobRequest jobrequest) {
		this.jobrequest = jobrequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Diploma() {
		super();
	}
   
}
