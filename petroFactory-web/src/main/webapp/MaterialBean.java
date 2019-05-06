package tn.esprit.Test2.presentation.mbeans;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import tn.esprit.Test2.persistence.Materials;
import tn.esprit.Test2.services.MaterialService;

@ManagedBean
@RequestScoped
@Named("materialBean")
public class MaterialBean {

	@EJB
	private MaterialService MaterialService;
	
	private int idmat;
	private String namemat;
	private String category ;
	private java.sql.Date bought ;
	private java.sql.Date expiration;
	private String image ;
	private int quantity;
	private double price ;
	private Materials mat ;
	private List<Materials> mats;
	public MaterialService getMaterialService() {
		return MaterialService;
	}
	public void setMaterialService(MaterialService materialService) {
		MaterialService = materialService;
	}
	public int getIdmat() {
		return idmat;
	}
	public void setIdmat(int idmat) {
		this.idmat = idmat;
	}
	public String getNamemat() {
		return namemat;
	}
	public void setNamemat(String namemat) {
		this.namemat = namemat;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public java.sql.Date getBought() {
		return bought;
	}
	public void setBought(java.sql.Date bought) {
		this.bought = bought;
	}
	public java.sql.Date getExpiration() {
		return expiration;
	}
	public void setExpiration(java.sql.Date expiration) {
		this.expiration = expiration;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Materials getMat() {
		return mat;
	}
	public void setMat(Materials mat) {
		this.mat = mat;
	}
	public List<Materials> getMats() {
		return mats;
	}
	public void setMats(List<Materials> mats) {
		this.mats = mats;
	}
	public MaterialBean() {
		super();
	}
	public MaterialBean(String namemat, String category, Date bought, Date expiration, String image, int quantity,
			double price) {
		super();
		this.namemat = namemat;
		this.category = category;
		this.bought = bought;
		this.expiration = expiration;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
	}
	public MaterialBean(int idmat, String namemat, String category, Date bought, Date expiration, String image,
			int quantity, double price) {
		super();
		this.idmat = idmat;
		this.namemat = namemat;
		this.category = category;
		this.bought = bought;
		this.expiration = expiration;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
