package tn.esprit.Test2.presentation.mbeans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import tn.esprit.Test2.persistence.Extraction;
import tn.esprit.Test2.persistence.Track;
import tn.esprit.Test2.services.TrackService;

@ManagedBean
@RequestScoped
@Named("extractionBean")
public class ExtractionBean  {
	
	public String getNametrack() {
		return nametrack;
	}
	public void setNametrack(String nametrack) {
		this.nametrack = nametrack;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}

	@EJB
	private TrackService TrackService;
	
	private int idExtraction;
    private Track track ;
	private int nbBarrel ;
	private String etatref;
	private java.sql.Date dateExt ;
	private Extraction extract ;
	private List<Extraction> extracts ;
	private String nametrack ;
	private List<String> names;
	
	public TrackService getTrackService() {
		return TrackService;
	}
	public void setTrackService(TrackService trackService) {
		TrackService = trackService;
	}
	public int getIdExtraction() {
		return idExtraction;
	}
	public void setIdExtraction(int idExtraction) {
		this.idExtraction = idExtraction;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public int getNbBarrel() {
		return nbBarrel;
	}
	public void setNbBarrel(int nbBarrel) {
		this.nbBarrel = nbBarrel;
	}
	public String getEtatref() {
		return etatref;
	}
	public void setEtatref(String etatref) {
		this.etatref = etatref;
	}
	public java.sql.Date getDateExt() {
		return dateExt;
	}
	public void setDateExt(java.sql.Date dateExt) {
		this.dateExt = dateExt;
	}
	public Extraction getExtract() {
		return extract;
	}
	public void setExtract(Extraction extract) {
		this.extract = extract;
	}
	public List<Extraction> getExtracts() {
		return extracts;
	}
	public void setExtracts(List<Extraction> extracts) {
		this.extracts = extracts;
	}
	
	public List<Extraction> displayallExtraction() {
		extracts = TrackService.FindAllExtractions();
		System.out.println(extracts);
		return extracts;
	}
	
	public String addExtraction()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime ldt = LocalDateTime.now();
		Extraction t = new Extraction(TrackService.getTrackByName(nametrack),nbBarrel,java.sql.Date.valueOf(dtf.format(ldt)));
		TrackService.addExtraction(t);
		return "ExtractList?faces-redirect=true";
	}
	
	public List<String> displayTracknames()
	{
		names = TrackService.getNomTrack();
		System.out.println(names);
		return names;
	}
	
	public List<Extraction> displayallRefinedExtraction() {
		extracts = TrackService.getAllRefined();
		System.out.println(extracts);
		return extracts;
	}
		
			public List<Extraction> displayallNotRefinedExtraction() {
				extracts = TrackService.getAllNotRefined();
				System.out.println(extracts);
				return extracts;
			}
			public ExtractionBean() {
				super();
			}
			public ExtractionBean(Track track, int nbBarrel) {
				super();
				this.track = track;
				this.nbBarrel = nbBarrel;
			}
			public ExtractionBean(int nbBarrel, String nametrack) {
				super();
				this.nbBarrel = nbBarrel;
				this.nametrack = nametrack;
			}
			
			@PostConstruct
			public void init() {
				extracts = TrackService.FindAllExtractions();
				extract = new Extraction();
				names = TrackService.getNomTrack();
			}
}
