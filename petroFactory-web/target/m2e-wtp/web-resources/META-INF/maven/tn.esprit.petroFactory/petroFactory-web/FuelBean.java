
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.petroFact.entity.Fuel;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.services.FuelServiceRemote;

@ManagedBean
@SessionScoped
public class FuelBean {
	private Float amount;
	private Float price;
	private String type;
	private int idF;
	private List<Fuel> fuels;
	
	
	@EJB
	FuelServiceRemote fs;
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public void AddFuel(){
		fs.ajouterFuel(new Fuel(type,price,amount));
		
		
	}
	public void RemoveFuel(int id){
		fs.deleteFuel(id);
	}
	public List<Fuel> getFuels() {
		fuels = fs.fuels();
		//System.out.println(fs.fuels());
		
		return fuels;
	}
	public void setFuels(List<Fuel> fuels) {
		this.fuels = fuels;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	
	public void modifier(Fuel f){
		this.setType(f.getType());
		this.setAmount(f.getAmount());
		this.setPrice(f.getPrice());
		this.setIdF(f.getIdFuel());
	}
	
	public void mettreAjour(){
		fs.UpdateFuel(new Fuel(type,amount,price,idF));
	}
	
}