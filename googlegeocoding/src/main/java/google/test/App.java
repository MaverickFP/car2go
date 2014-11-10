package google.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //genero due numeri casuali 
        
        
        
        GoogleMapsService googleService = new GoogleMapsService();
        //double latitudine  = 41.9093;
        //double longitudine = 12.5391;
       // String lng = (String) latitudine;
        double latitudine  = googleService.generaLatitudine();
        System.out.println(latitudine);
        double longitudine = googleService.generaLongitudine();
        System.out.println(longitudine);
        
        try {
			String indirizzo = googleService.getAddressByGpsCoordinates(latitudine, longitudine);
			System.out.println(indirizzo);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        
        
        double lat1 = 41.9403;
        double long1 = 12.5746;
        
        double lat2 = 41.9103;
        double long2 = 12.4146;
        
        float risultatoDistanza = googleService.calculateDistance(lat1, long1, lat2, long2);
        System.out.println(risultatoDistanza);
        
        try {
			String s = googleService.getDistance2(lat1, long1, lat2, long2);
			System.out.println(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }
}
