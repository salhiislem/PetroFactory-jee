package tn.esprit.lavage.presentation.mbeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.lavage.entity.Product;
import tn.esprit.lavage.services.ProductService;

@ManagedBean
@SessionScoped
public class IndexBean {
private List<Product>products ;
	@EJB
	ProductService productservice;
	
	public List<Product> getAllProducts ()
	{
		
		products= productservice.getAll();
		return products ;
		
	}
	
public String getQuery ( ){
	
	
	return 	FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
}


public void checkIfQueryExists() throws IOException
{
if (productservice.checkIfQueryExists(getQuery()) == 0)	
{
FacesContext.getCurrentInstance().getExternalContext().redirect("erreur.xhtml");	


}
}

	public Product getProduct ()
	
	{
		
		return productservice.returnProduct(getQuery());
		
		
		
	}
	
	
	
	
}
