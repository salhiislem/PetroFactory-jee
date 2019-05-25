package tn.esprit.Test2.presentation.mbeans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import tn.esprit.Test2.persistence.Oilfield;
import tn.esprit.Test2.persistence.Track;
import tn.esprit.Test2.services.TrackService;

@ManagedBean
@RequestScoped
@Named("trackBean")
public class TrackBean  {

	@EJB
	private TrackService TrackService;
	
	private Track track ;
	private int idTrack;
	private String nameTrack;
	private Oilfield oilField ;
	private double depth;
	private double diameter;
	private int nbOilBarrel;
	private String extracted ;
	private List<Track> tracks ;
	
	
	public String addTrack() {
			System.out.println(nameTrack);
			TrackService.addTrack(new Track(nameTrack,diameter,depth));
		
		return "TrackList?faces-redirect=true";
			
		
	}
	
	public List<Track> displayallTrack() {
		tracks = TrackService.FindAllTracks();
		System.out.println(tracks);
		return tracks;
	}
	
	public String removeTrack(int idtrack) {
		
		TrackService.deleteTrack(idtrack);
		track = new Track();
		return "TrackList?faces-redirect=true";
	}

	public TrackService getTrackService() {
		return TrackService;
	}

	public void setTrackService(TrackService trackService) {
		TrackService = trackService;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public int getIdTrack() {
		return idTrack;
	}

	public void setIdTrack(int idTrack) {
		this.idTrack = idTrack;
	}

	public String getNameTrack() {
		return nameTrack;
	}

	public void setNameTrack(String nameTrack) {
		this.nameTrack = nameTrack;
	}

	public Oilfield getOilField() {
		return oilField;
	}

	public void setOilField(Oilfield oilField) {
		this.oilField = oilField;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public int getNbOilBarrel() {
		return nbOilBarrel;
	}

	public void setNbOilBarrel(int nbOilBarrel) {
		this.nbOilBarrel = nbOilBarrel;
	}

	public String getExtracted() {
		return extracted;
	}

	public void setExtracted(String extracted) {
		this.extracted = extracted;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public TrackBean() {
		super();
	}

	public TrackBean(String nameTrack, double depth, double diameter) {
		super();
		this.nameTrack = nameTrack;
		this.depth = depth;
		this.diameter = diameter;
	}

	public TrackBean(String nameTrack, double depth, double diameter, int nbOilBarrel, String extracted) {
		super();
		this.nameTrack = nameTrack;
		this.depth = depth;
		this.diameter = diameter;
		this.nbOilBarrel = nbOilBarrel;
		this.extracted = extracted;
	}

	public TrackBean(int idTrack, String nameTrack, double depth, double diameter, int nbOilBarrel, String extracted) {
		super();
		this.idTrack = idTrack;
		this.nameTrack = nameTrack;
		this.depth = depth;
		this.diameter = diameter;
		this.nbOilBarrel = nbOilBarrel;
		this.extracted = extracted;
	}
	
	

}
