package google.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GoogleMapsService {
	
	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;
	
	
	public GoogleMapsService(){
		
	}
	
	

    public float calculateDistance(double userLat, double userLng, double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) +
                        (Math.cos(Math.toRadians(userLat))) *
                        (Math.cos(Math.toRadians(venueLat))) *
                        (Math.sin(lngDistance / 2)) *
                        (Math.sin(lngDistance / 2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (float) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));

    }
    
    /*
    public String getDistance(double lat1, double lon1, double lat2, double lon2) {
        String result_in_kms = "";
        String url = "http://maps.google.com/maps/api/directions/xml?origin=" + lat1 + "," + lon1 + "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric";
        String tag[] = {"text"};
        HttpResponse response = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(url);
            response = httpClient.execute(httpPost, localContext);
            InputStream is = response.getEntity().getContent();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            if (doc != null) {
                NodeList nl;
                ArrayList args = new ArrayList();
                for (String s : tag) {
                    nl = doc.getElementsByTagName(s);
                    if (nl.getLength() > 0) {
                        Node node = nl.item(nl.getLength() - 1);
                        args.add(node.getTextContent());
                    } else {
                        args.add(" - ");
                    }
                }
                result_in_kms = String.format("%s", args.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_in_kms;
    }
	
	*/
	
	public double generaLatitudine(){
		
		double baseLat = 41.820270;
		int START = 1;
	    int END = 13;
	    Random random = new Random();
	    int num = showRandomInteger(START, END, random);
	    System.out.println("Casuale Latitudine " + num);
	    double numadd = (double) num/100;
	    System.out.println(numadd);
	    double ris = baseLat + numadd;
		
		return ris;
	}
	
	
	
	public double generaLongitudine(){
		
		double baseLongitudine = 12.404579;
		int START = 1;
	    int END = 18;
	    Random random = new Random();
	    int num = showRandomInteger(START, END, random);
	    System.out.println("Casuale Longitudine " + num);
	    double numadd = (double) num/100;
	    System.out.println(numadd);
	    double ris = baseLongitudine + numadd;
		
		return ris;
	}
	
	
	
	private int  showRandomInteger(int aStart, int aEnd, Random aRandom){
	    
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);    
	    return randomNumber;
	  }
	
	
	
	/**
	 *
	 * @param lng
	 * @param lat
	 * @return
	 */
	    public String getAddressByGpsCoordinates(double lat, double lng)
	            throws MalformedURLException, IOException, org.json.simple.parser.ParseException {
	         
	        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="
	                + lat + "," + lng + "&sensor=true");
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        String formattedAddress = "";
	 
	        try {
	            InputStream in = url.openStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String result, line = reader.readLine();
	            result = line;
	            while ((line = reader.readLine()) != null) {
	                result += line;
	            }
	 
	            JSONParser parser = new JSONParser();
	            JSONObject rsp = (JSONObject) parser.parse(result);
	 
	            if (rsp.containsKey("results")) {
	                JSONArray matches = (JSONArray) rsp.get("results");
	                JSONObject data = (JSONObject) matches.get(0); //TODO: check if idx=0 exists
	                formattedAddress = (String) data.get("formatted_address");
	            }
	 
	            return "";
	        } finally {
	            urlConnection.disconnect();
	            return formattedAddress;
	        }
	    }
	    
	    
	    public String getDistance2(double lat1, double lon1, double lat2, double lon2)throws MalformedURLException, IOException, org.json.simple.parser.ParseException{
	    	
	        String urlString = "http://maps.google.com/maps/api/directions/json?origin=" + lat1 + "," + lon1 + "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric";
	        System.out.println(urlString);
	        URL url = new URL(urlString);
	        
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        String formattedAddress = "";
	        
	        try {
	            InputStream in = url.openStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String result, line = reader.readLine();
	            result = line;
	            System.out.println("Sono qui1");
	            while ((line = reader.readLine()) != null) {
	                result += line;
	                System.out.println("Sono qui2");
	            }
	 
	            JSONParser parser = new JSONParser();
	            JSONObject rsp = (JSONObject) parser.parse(result);
	 
	            if (rsp.containsKey("routes")) {
	            	System.out.println("Sono qui3");
	            	JSONArray matches = (JSONArray) rsp.get("routes");
	                JSONObject data = (JSONObject) matches.get(0);
	                
	               // boolean b = data.containsKey("legs");
	                JSONArray arr1 = (JSONArray) data.get("legs");
	                
	                JSONObject data1 = (JSONObject) arr1.get(0);
	                //boolean b = data1.containsKey("duration");
	                //System.out.println(b);
	                
	                //http://maps.google.com/maps/api/directions/json?origin=41.9403,12.5746&destination=41.9103,12.4146&sensor=false&units=metric
	                
	               JSONObject structureDistance = (JSONObject) data1.get("distance");
	               
	               
	               boolean b = structureDistance.containsKey("value");
	               System.out.println(b);
	               
	               //String distanza = (String) structureDistance.get(0);
	               JSONObject distanceObj = (JSONObject) structureDistance.get("value");
	               String distanza = distanceObj.toString();
	               
	               System.out.println("ecco: " + distanza);
	                
	                
	            }
	 
	            return "";
	        } finally {
	            urlConnection.disconnect();
	            return formattedAddress;
	        }
	        
	        
	    }
	

}
