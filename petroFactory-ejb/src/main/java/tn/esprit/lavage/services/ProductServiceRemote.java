package tn.esprit.lavage.services;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.lavage.entity.Product;

@Remote
public interface ProductServiceRemote {
public void ajouterProduit(Product produit);
public List<Product> FindAllProduct();
public List getAll ();
public void deleteproduct(Product product);
public Product FindProductName(String name );
public void UpdateProduct(Product product);
List<Product> FindProductByName(String name);
Product FindProductById(Integer id);
Product findByna(String Name);
public void updateTrackName(String i, String category,String descrip,float prix,int sto,int id);

}
