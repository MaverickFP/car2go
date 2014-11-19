import java.util.List;

import it.car2go.ejb.stateful.ApplicationEJBRemote;
import it.car2go.model.Macchina;
import it.car2go.service.GeoService;

import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		InitialContext ic;
		try {
			ic = new InitialContext();
			ApplicationEJBRemote service = (ApplicationEJBRemote) ic.lookup("ApplicationEJB");
			
			
			GeoService geoService = (GeoService) ic.lookup("GeoEJB");			
			double lat = geoService.generaLatitudine();
			System.out.println(lat);
			
			float distanza = geoService.calcolaDistanza(41.9303, 12.5346, 41.8903, 12.5446);
			System.out.println("Distanza " + distanza);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}