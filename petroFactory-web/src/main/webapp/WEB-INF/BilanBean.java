package tn.esprit.lavage.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import tn.esprit.lavage.entity.Bilan;
import tn.esprit.lavage.entity.Lavage;
import tn.esprit.lavage.services.LavageService;

@ManagedBean
@SessionScoped
public class BilanBean {
public String comparer;
	private List<Bilan>bilans ;
	private float materialsindustrial;
	private float materialtransport;
	private float mobilier;
	private float stock ;
	private float creance ;
	private float banque ;
	private float caisse;
	private float capitalsocial ;
	private float fournisseur;
	private float etatimpot;
	private float concours ;
	
	
	
	
	private int idlavage ;
	private String lavagename;
	private float longitude;
	private float latitude;
	private String Email;
	private List<Lavage>lavages;
	
	
	

	public List<Lavage> afficherlavge ()
	{
		
		lavages =lavageService.FindAllLavage();
		return lavages;
		
		
	}	
	
	
	
	
	private MapModel simpleModel;
	public MapModel map() {
		simpleModel = new DefaultMapModel();

		// Shared coordinates
		
		LatLng coord1 = new LatLng(12, 13);
		simpleModel.addOverlay(new Marker(coord1,"qqqqs"));

		

		return simpleModel;
		// Basic marker

	}
	
	
	public MapModel getSimpleModel() {
		simpleModel = map();
		return simpleModel;
	}
	
	
	List<Lavage> list = new ArrayList<Lavage>();

	public List<Lavage>  viewShop() {
		 
		
		 if (lavageService.distance(0.5333, 0.5,0.5333, 0.5, "K")>200 )
		
		 {
			 
				list = lavageService.FindAllLavage() ;
		 }
		return list ;
		

	}
	
	
	
	public String search(){
		
		
		String navigateTo = "null";
		 for (int i = 0; i < lavageService.FindAllLavage().size(); i++) {
			 if (lavageService.distance(lavageService.FindAllLavage().get(i).getLatitude(), lavageService.FindAllLavage().get(i).getLongitude(),longitude, latitude, "K")>0 )		
			 {
				 lavages = lavageService.FindAllLavage();	 
		 
		 }}
 
		
			
			navigateTo = "tenders?faces-redirect=true";		
		
		return navigateTo;
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@EJB
	LavageService lavageService ;
	
	
	public List<Bilan> afficherbilan()
	{
		bilans=lavageService.FindListBilan(1);
		
		return bilans ;
		
		
	}
public float calculerpassif()
{
	
	float somme= 0 ;
	
	
bilans=afficherbilan();

somme+=bilans.get(0).getCapitalsocial()+bilans.get(0).getEtatimpot()+bilans.get(0).getConcours()         ;

return somme ;

}

public float calculerActif()
{
float somme=0;
bilans=afficherbilan();
somme+=bilans.get(0).getMaterialsindustrial()+bilans.get(0).getMaterialtransport()+bilans.get(0).getMobilier()+bilans.get(0).getStock()+bilans.get(0).getCreance()+bilans.get(0).getBanque()+bilans.get(0).getCaisse();

return somme ;




}
public String comparer ()
{
	if (calculerActif()>calculerpassif())
	{
		
		comparer="vous etes en bonne etat financiere";
		
	}
	else 
	{
		comparer="vous devez ameliorer votre etat financiere";
		
		
		
	}
return comparer;

}
public String ajouterBilan ()
{
lavageService.updatebilan(banque, caisse, capitalsocial, concours,creance , etatimpot, fournisseur, mobilier, stock, materialsindustrial, materialtransport);	

return "Bilan?faces-redirect=true";

}









	public List<Bilan> getBilans() {
		return bilans;
	}


	public void setBilans(List<Bilan> bilans) {
		this.bilans = bilans;
	}
	public String getComparer() {
		return comparer;
	}
	public void setComparer(String comparer) {
		this.comparer = comparer;
	}
	public float getMaterialsindustrial() {
		return materialsindustrial;
	}
	public void setMaterialsindustrial(float materialsindustrial) {
		this.materialsindustrial = materialsindustrial;
	}
	public float getMaterialtransport() {
		return materialtransport;
	}
	public void setMaterialtransport(float materialtransport) {
		this.materialtransport = materialtransport;
	}
	public float getMobilier() {
		return mobilier;
	}
	public void setMobilier(float mobilier) {
		this.mobilier = mobilier;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public float getCreance() {
		return creance;
	}
	public void setCreance(float creance) {
		this.creance = creance;
	}
	public float getBanque() {
		return banque;
	}
	public void setBanque(float banque) {
		this.banque = banque;
	}
	public float getCaisse() {
		return caisse;
	}
	public void setCaisse(float caisse) {
		this.caisse = caisse;
	}
	public float getCapitalsocial() {
		return capitalsocial;
	}
	public void setCapitalsocial(float capitalsocial) {
		this.capitalsocial = capitalsocial;
	}
	public float getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(float fournisseur) {
		this.fournisseur = fournisseur;
	}
	public float getEtatimpot() {
		return etatimpot;
	}
	public void setEtatimpot(float etatimpot) {
		this.etatimpot = etatimpot;
	}
	public float getConcours() {
		return concours;
	}
	public void setConcours(float concours) {
		this.concours = concours;
	}


	public String getLavagename() {
		return lavagename;
	}


	public void setLavagename(String lavagename) {
		this.lavagename = lavagename;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public List<Lavage> getLavages() {
		return lavages;
	}


	public void setLavages(List<Lavage> lavages) {
		this.lavages = lavages;
	}


	public int getIdlavage() {
		return idlavage;
	}


	public void setIdlavage(int idlavage) {
		this.idlavage = idlavage;
	}
	
	
	
	
	
}
