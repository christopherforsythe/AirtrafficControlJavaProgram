/**
 * 
 */
package p2;

import java.util.ArrayList;

/**
 * @author chrisforsythe
 * Student number - 40134121
 */
public class AirtrafficControl {
	
	/**
	 * search by current speed
	 * speed must be between two passed parameters (inclusive)
	 * @param allFlights
	 * @param currentSpeed
	 * @return - arraylist of matching search criteria
	 */
	public static ArrayList<Airline> searchBySpeed(ArrayList<Airline> allFlights, int currentSpeed1, int currentSpeed2){
		
		//create an arraylist to capture search matches
		ArrayList<Airline> searchResults = new ArrayList<Airline>();
		
		//enhanced for loop to iterate through each moving flight
		for(Airline f : allFlights) {
			//if the flights current speed matches the search criteria 
			if(f.getCurrentSpeed() >= currentSpeed1 && f.getCurrentSpeed() <= currentSpeed2) {
				//add to results arraylist
				searchResults.add(f);
			}
		}
		//return results
		return searchResults;
	} //end of method
	
	
	/**
	 * Search by engine type
	 * @param allFlights
	 * @param engineType
	 * @return - Arraylist of all Airlines details matching the specified engine type
	 */
	public static ArrayList<Airline> searchForAllByEngineType(ArrayList<Airline> allFlights, String engineType){
		
		//create an arraylist to capture search matches
		ArrayList<Airline> searchResults = new ArrayList<Airline>();
		
		//enhanced for loop to iterate through each moving flight
		for(Airline f : allFlights) {
			//if the flights engine type matches the search parameter
			if(f.getEngineType().equalsIgnoreCase(engineType)) {
				//add to results arraylist
				searchResults.add(f);
			}
		}
		//return results
		return searchResults;
	} //end of method
	
	
	/**
	 * 
	 * @param allFlights
	 * @param engineType
	 * @param timeToAirfield
	 * @return
	 */
	public static ArrayList<Airline> searchForLandingList(ArrayList<Airline> allFlights, String engineType, double timeToAirfield){
	
		
		//create arraylist to capture results
		ArrayList<Airline> searchResults = new ArrayList<Airline>();
		
		//enhanced for loop to iterate through each moving flight
		for(Airline f: allFlights) {
			//if the flight, following calling the timeToAirfield methods output equals the passed parameter and the engine type is the same
			if(f.timeToAirfield(f.getDistanceToAirfield(), f.getCurrentSpeed()) == timeToAirfield && f.getEngineType().equalsIgnoreCase(engineType)) {
				//add it to the results arraylist
				searchResults.add(f);
			}
		}
		//return results
		return searchResults;
	} //end of methods

}
