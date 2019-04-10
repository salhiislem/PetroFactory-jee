package services;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import petrofactory.puitss.persistence.Track;
import petrofactory.puitss.services.TrackServiceRemote;

public class TrackClient {

		public static void main(String[] args) throws NamingException {
			String jndiName="puitss-ear/puitss-ejb/TrackService!petrofactory.puitss.services.TrackServiceRemote";
			Context context = new InitialContext();
			//ProductServiceRemote proxy=(ProductServiceRemote) context.lookup(jndiName);
			//ShopServiceRemote proxy2=(ShopServiceRemote) context.lookup(jndiName);
			//StationServiceRemote proxy3=(StationServiceRemote) context.lookup(jndiName);
			TrackServiceRemote proxy4=(TrackServiceRemote) context.lookup(jndiName);
			//Product p=new Product();
			//shop s = new shop();
			//Station st = new Station();
			//proxy2.ajouterShop(s);
			//proxy3.affectershopstation(1, 2);
			//proxy2.affectershopstation(1 1);
			Track s=new Track("Salakta",18.00,32.25);
			//System.out.println(1);
			proxy4.addTrack(s);
			//proxy4.deleteTrack(3);
			//proxy4.updateTrackName("BouSalem",1);
			//proxy.ajouterProduct(p);
			//proxy.supprimerProduct(1);
			//proxy.modifierProduct(3.0, 2);

		}

	}


