package tn.esprit.lavage.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
public class Material implements Serializable {

	private int idMaterial;
	private String MaterialName ;
	private Float price ; 
	private String Description ; 
	private String image ;
	private boolean Avaible ;
	private int stock;
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getMaterialName() {
		return MaterialName;
	}
	public void setMaterialName(String materialName) {
		MaterialName = materialName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isAvaible() {
		return Avaible;
	}
	public void setAvaible(boolean avaible) {
		Avaible = avaible;
	}
	public Material() {
		super();
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Material(String materialName, Float price, String description) {
		super();
		MaterialName = materialName;
		this.price = price;
		Description = description;
	}
	public Material(String materialName, Float price, String description, String image) {
		super();
		MaterialName = materialName;
		this.price = price;
		Description = description;
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Material(String materialName, Float price, String description, String image, int stock) {
		super();
		MaterialName = materialName;
		this.price = price;
		Description = description;
		this.image = image;
		this.stock = stock;
	}
	
	
	
	
	
}
