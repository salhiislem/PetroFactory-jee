package tn.esprit.Test2.presentation.mbeans;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.Test2.persistence.Extraction;
import tn.esprit.Test2.persistence.Fuel;
import tn.esprit.Test2.persistence.Refinement;
import tn.esprit.Test2.persistence.Track;
import tn.esprit.Test2.services.TrackService;

@ManagedBean
@RequestScoped
public class RefinementBean {
	
	
	@EJB
	private TrackService TrackService;
	
	private int idRefin;
	private Extraction RefExtraction;
	private Fuel Fuel ;
	private int AmountRef;
	private java.sql.Date RefDate ;
	private String pro ;
	private Refinement refin ;
	private List<Refinement> ref ;
	private Extraction extract;
	private Fuel fuel ;
	private String ff ;
	private String fuelname;
	
	public TrackService getTrackService() {
		return TrackService;
	}
	public void setTrackService(TrackService trackService) {
		TrackService = trackService;
	}
	public int getIdRefin() {
		return idRefin;
	}
	public void setIdRefin(int idRefin) {
		this.idRefin = idRefin;
	}
	public Extraction getRefExtraction() {
		return RefExtraction;
	}
	public void setRefExtraction(Extraction refExtraction) {
		RefExtraction = refExtraction;
	}
	public Fuel getFuel() {
		return Fuel;
	}
	public void setFuel(Fuel fuel) {
		Fuel = fuel;
	}
	public int getAmountRef() {
		return AmountRef;
	}
	public void setAmountRef(int amountRef) {
		AmountRef = amountRef;
	}
	public java.sql.Date getRefDate() {
		return RefDate;
	}
	public void setRefDate(java.sql.Date refDate) {
		RefDate = refDate;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public Refinement getRefin() {
		return refin;
	}
	public void setRefin(Refinement refin) {
		this.refin = refin;
	}
	public List<Refinement> getRef() {
		return ref;
	}
	public void setRef(List<Refinement> ref) {
		this.ref = ref;
	}
	public RefinementBean() {
		super();
	}
	public RefinementBean(Extraction refExtraction, tn.esprit.Test2.persistence.Fuel fuel, int amountRef) {
		super();
		RefExtraction = refExtraction;
		Fuel = fuel;
		AmountRef = amountRef;
	}
	public RefinementBean(Extraction refExtraction, tn.esprit.Test2.persistence.Fuel fuel, int amountRef,
			Date refDate) {
		super();
		RefExtraction = refExtraction;
		Fuel = fuel;
		AmountRef = amountRef;
		RefDate = refDate;
	}
	public RefinementBean(int idRefin, Extraction refExtraction, tn.esprit.Test2.persistence.Fuel fuel, int amountRef,
			Date refDate) {
		super();
		this.idRefin = idRefin;
		RefExtraction = refExtraction;
		Fuel = fuel;
		AmountRef = amountRef;
		RefDate = refDate;
	}
	
	public String addRefinement() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime ldt = LocalDateTime.now();
    		
		Refinement r = new Refinement(extract,TrackService.getRefinementByName(ff),extract.getNbBarrel(),java.sql.Date.valueOf(dtf.format(ldt)));
    	
    	TrackService.addRefinemnt(r);
	
	return "TrackList?faces-redirect=true";
		
	
}

public List<Refinement> displayallRefinement() {
	ref = TrackService.FindAllRefinements();
	System.out.println(ref);
	return ref ;
}

public List<Refinement> displayalldailyRefinement() {
	ref = TrackService.FindAllDailyRefinement();
	System.out.println(ref);
	return ref ;
}

public List<Refinement> displayFuelRefinement() {
	fuel = TrackService.getRefinementByName(fuelname);
	ref = TrackService.getAllFuelRefinement(fuel);
	System.out.println(ref);
	return ref ;
}

	
	

}
