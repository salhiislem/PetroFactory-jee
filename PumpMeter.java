package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class PumpMeter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPM;
	private Float amountSold;
	private GasPump gaspump;
	private List<Report> report;
	private Pumpman pumpman;
	@OneToOne
	public Pumpman getPumpman() {
		return pumpman;
	}
	public void setPumpman(Pumpman pumpman) {
		this.pumpman = pumpman;
	}
	@OneToMany(mappedBy="pumpmeter")
	public List<Report> getReport() {
		return report;
	}
	public void setReport(List<Report> report) {
		this.report = report;
	}
	@OneToOne
	public GasPump getGaspump() {
		return gaspump;
	}
	public void setGaspump(GasPump gaspump) {
		this.gaspump = gaspump;
	}
	@Id
	public Integer getIdPM() {
		return idPM;
	}
	public void setIdPM(Integer idPM) {
		this.idPM = idPM;
	}
	public Float getAmountSold() {
		return amountSold;
	}
	public void setAmountSold(Float amountSold) {
		this.amountSold = amountSold;
	}
	
	
	
	
}
