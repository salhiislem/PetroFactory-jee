package tn.esprit.petroFact.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class PumpMeter implements Serializable {

	private Integer idPM;
	private Integer Num;
	private Float amountSold;
	private Fuel Type;
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
	@ManyToOne
	public GasPump getGaspump() {
		return gaspump;
	}
	public void setGaspump(GasPump gaspump) {
		this.gaspump = gaspump;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public PumpMeter(Float amountSold) {
		super();
		this.amountSold = amountSold;
	}
	public PumpMeter() {
		
	}
	
	public Integer getNum() {
		return Num;
	}
	public void setNum(Integer num) {
		Num = num;
	}
	@Override
	public String toString() {
		return "PumpMeter [idPM=" + idPM + ", Num=" + Num + ", amountSold=" + amountSold + ",type=" + Type + ", gaspump=" + gaspump +"]";
	}
	public PumpMeter(Integer num, Float amountSold) {
		
		this.Num = num;
		this.amountSold = amountSold;
	}
	public Fuel getType() {
		return Type;
	}
	public void setType(Fuel type) {
		Type = type;
	}
	
	
	
	
}
