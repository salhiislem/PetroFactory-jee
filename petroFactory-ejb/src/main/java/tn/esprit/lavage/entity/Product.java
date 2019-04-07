package tn.esprit.lavage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT t FROM Product t")
})
public class Product  implements Serializable {

private int IdProduct ;
private String ProductName ; 
private String description ;
private String Category ;
private int Stock ;
private float price;
private String DateAdd ;





@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)

public int getIdProduct() {
	return IdProduct;
}
public void setIdProduct(int idProduct) {
	IdProduct = idProduct;
}
@Column(name="productName")
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public int getStock() {
	return Stock;
}
public void setStock(int stock) {
	Stock = stock;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

public String getDateAdd() {
	return DateAdd;
}
public void setDateAdd(String dateAdd) {
	DateAdd = dateAdd;
}
public Product() {
	super();
}
public Product(int idProduct, String productName, String description, String category, int stock, float price
	) {
	super();
	IdProduct = idProduct;
	ProductName = productName;
	this.description = description;
	Category = category;
	Stock = stock;
	this.price = price;

}
public Product(String productName, String description, String category) {
	super();
	ProductName = productName;
	this.description = description;
	Category = category;
}
public Product(String productName, String description, String category, String dateAdd) {
	super();
	ProductName = productName;
	this.description = description;
	Category = category;
	DateAdd = dateAdd;
}
@Override
public String toString() {
	return "Product [IdProduct=" + IdProduct + ", ProductName=" + ProductName + ", description=" + description
			+ ", Category=" + Category + ", Stock=" + Stock + ", price=" + price + ", DateAdd=" + DateAdd + "]";
}
public Product(String productName, String description, String category, int stock, float price, String dateAdd) {
	super();
	ProductName = productName;
	this.description = description;
	Category = category;
	Stock = stock;
	this.price = price;
	DateAdd = dateAdd;
}


	
}
