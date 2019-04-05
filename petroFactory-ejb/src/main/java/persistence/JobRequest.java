package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import utils.Language;

/**
 * Entity implementation class for Entity: JobRequest
 *
 */
@Entity
public class JobRequest implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 @Column(nullable = false)
	    private String cin;
	private Language language;
		@Column(nullable = false)
	    private String cv;
		@Column(nullable = false)
	    private String coverLetter;
		private String note;
		private Date interviewDate;
	 
		@OneToMany (mappedBy="jobrequest")
		private List<Experience> experiences;
		@OneToMany (mappedBy="jobrequest")
		private List<Skills> skills;
		@OneToMany (mappedBy="jobrequest")
		private List<Diploma> diplomas;
		@OneToMany (mappedBy="jobrequest")
		private List<Education> educations;
		 @ManyToOne
			private User jobSeeker;
		 
	public List<Experience> getExperiences() {
			return experiences;
		}

		public void setExperiences(List<Experience> experiences) {
			this.experiences = experiences;
		}

		public List<Skills> getSkills() {
			return skills;
		}

		public void setSkills(List<Skills> skills) {
			this.skills = skills;
		}

		public List<Diploma> getDiplomas() {
			return diplomas;
		}

		public void setDiplomas(List<Diploma> diplomas) {
			this.diplomas = diplomas;
		}

		public List<Education> getEducations() {
			return educations;
		}

		public void setEducations(List<Education> educations) {
			this.educations = educations;
		}

		public User getJobSeeker() {
			return jobSeeker;
		}

		public void setJobSeeker(User jobSeeker) {
			this.jobSeeker = jobSeeker;
		}

	public Language getLanguage() {
			return language;
		}

		public void setLanguage(Language language) {
			this.language = language;
		}

	public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCin() {
			return cin;
		}

		public void setCin(String cin) {
			this.cin = cin;
		}

	
		public String getCv() {
			return cv;
		}

		public void setCv(String cv) {
			this.cv = cv;
		}

		public String getCoverLetter() {
			return coverLetter;
		}

		public void setCoverLetter(String coverLetter) {
			this.coverLetter = coverLetter;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public Date getInterviewDate() {
			return interviewDate;
		}

		public void setInterviewDate(Date interviewDate) {
			this.interviewDate = interviewDate;
		}

		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	private static final long serialVersionUID = 1L;

	public JobRequest() {
		super();
	}
   
}
