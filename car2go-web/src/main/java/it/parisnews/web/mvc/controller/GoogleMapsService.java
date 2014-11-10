package it.parisnews.web.mvc.controller;

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
	
	private float latitudine;
	private float longitudine;
	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;
	
	
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
	

}
