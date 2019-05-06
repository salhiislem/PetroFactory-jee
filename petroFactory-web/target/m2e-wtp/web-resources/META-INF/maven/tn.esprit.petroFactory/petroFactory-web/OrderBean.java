import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.petroFact.entity.FuelOrder;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.services.FuelServiceRemote;

@ManagedBean
@SessionScoped
public class OrderBean {
	
	private Float amount;
	private Double price;
	private String type;
	private String address;
	private String signature;
	private List<GasPump> gazs;
	private List<String> typeGas ;
	private List<FuelOrder> orders;
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<FuelOrder> getOrders() {
		orders = fs.flOrder();
		return orders;
	}
	public void setOrders(List<FuelOrder> orders) {
		this.orders = orders;
	}
	
	@EJB
	FuelServiceRemote fs;
	public void AddOrder(){
		fs.ajouterFuelOrder(new FuelOrder(type,price,amount,address,signature));
	}
	public List<String> getTypeGas() {
		typeGas = fs.typeGas();
		return typeGas;
	}
	public void setTypeGas(List<String> typeGas) {
		this.typeGas = typeGas;
	}
	public List<GasPump> getGazs() {
		gazs = fs.gaspumps();
		return gazs;
	}
	public void setGazs(List<GasPump> gazs) {
		this.gazs = gazs;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
