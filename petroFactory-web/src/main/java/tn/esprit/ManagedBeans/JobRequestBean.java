package tn.esprit.ManagedBeans;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

import persistence.JobRequest;
import services.JobRequestService;
import utils.Language;

@SessionScoped
@ManagedBean
public class JobRequestBean {
	
	    private int id;
	private Part filecv;
	private Part filecl;
	    private String cin;
	private Language language;
		
	    private String cv;
	
	    private String coverLetter;
		private String note;
		private Date interviewDate;
	    private int nbYearExperience;
	    private int nbOfapprouvedSkills;
	    
	    
	
	    public Part getFilecv() {
			return filecv;
		}
		public void setFilecv(Part filecv) {
			this.filecv = filecv;
		}
		public Part getFilecl() {
			return filecl;
		}
		public void setFilecl(Part filecl) {
			this.filecl = filecl;
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
		public Language getLanguage() {
			return language;
		}
		public void setLanguage(Language language) {
			this.language = language;
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
		public int getNbYearExperience() {
			return nbYearExperience;
		}
		public void setNbYearExperience(int nbYearExperience) {
			this.nbYearExperience = nbYearExperience;
		}
		public int getNbOfapprouvedSkills() {
			return nbOfapprouvedSkills;
		}
		public void setNbOfapprouvedSkills(int nbOfapprouvedSkills) {
			this.nbOfapprouvedSkills = nbOfapprouvedSkills;
		}
	public JobRequestBean() {
super();	}
	@EJB
	JobRequestService jobRequestService;
	
	
public String upload() throws IOException {
        
        filecv.write("D:\\javaEE\\petroFactory\\cv\\"+getFilename(filecv));
        filecl.write("D:\\javaEE\\petroFactory\\coverLetters\\"+getFilename(filecl));
        return "success";
    }
	private static String getFilename(Part part) {
    for (String cd : part.getHeader("content-disposition").split(";")) {
        if (cd.trim().startsWith("filename")) {
            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
        }
    }
    return null;
}
	public int ajoutRequest() throws IOException
	{ 
	String s =	upload();
			cv=getFilename(filecv);
			coverLetter=getFilename(filecl);
			JobRequest j=new JobRequest();
			j.setCin(cin);
			j.setCoverLetter(coverLetter);
			j.setCv(cv);
			j.setNote(note);
		id=jobRequestService.addJobRequest(j);
		return id;
	}
}
