package p2;

/**
 * author - chris forsythe
 * student number = 40134121
 */

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p2.Airline;
import p2.AirtrafficControl;

class AirtrafficControlTest {
	
	//set up arraylist of Airlines
	ArrayList<Airline> flights = new ArrayList<Airline>();
	
	//CREATE airline flights to test
	Airline flight1, flight2, flight3;
	
	//create valid test data
	String flight1Code, flight2Code, flight3Code;
	
	String flight1EngineType, flight2EngineType, flight3EngineType;
	
	int flight1CurrentSpeed, flight2CurrentSpeed, flight3CurrentSpeed;
	
	int flight1DistanceFromAirfield, flight2DistanceFromAirfield, flight3DistanceFromAirfield;

	//Parameter test data
	int currentSpeed1, currentSpeed2;
	
	double distanceToAifield;
	
	String engineType1, engineType2;
	

	@BeforeEach
	void setUp() throws Exception {
		
		flight1Code = "A12345";
		flight2Code = "A54321";
		flight3Code = "Axxxxx";
		
		flight1EngineType = "jet";
		flight2EngineType = "propeller";
		flight3EngineType = "jet";
		
		flight1CurrentSpeed = 800;
		flight2CurrentSpeed = 300;
		flight3CurrentSpeed = 250;
		
		flight1DistanceFromAirfield = 20000;
		flight2DistanceFromAirfield = 10000;
		flight3DistanceFromAirfield = 7000;
		
		currentSpeed1 = 100;
		currentSpeed2 = 400;
		
		distanceToAifield = 1500.0;
		
		engineType1 = "jet";
		engineType2 = "propeller";
	
		
		//create flights
		flight1 = new Airline(flight1CurrentSpeed, flight1DistanceFromAirfield, flight1Code, flight1EngineType);
		flight2 = new Airline(flight2CurrentSpeed, flight2DistanceFromAirfield, flight2Code, flight2EngineType);
		flight3 = new Airline(flight3CurrentSpeed, flight3DistanceFromAirfield, flight3Code, flight3EngineType);
		
		//add to arraylist
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
	}

	@Test
	void testSearchBySpeed() {
		
		//invoke search
		ArrayList<Airline> returnedSearchBySpeed = AirtrafficControl.searchBySpeed(flights, currentSpeed1, currentSpeed2);
		
		//should return 2 flight
		System.out.println(returnedSearchBySpeed.size());
		
		if(returnedSearchBySpeed.size() == 2 & returnedSearchBySpeed.contains(flight2) && returnedSearchBySpeed.contains(flight3)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	void testSearchForAllByEngineType() {
		
		//INVOKE THE SEARCH
		ArrayList<Airline> returnedSearchByEngineType = AirtrafficControl.searchForAllByEngineType(flights, engineType1);
		
		//Should return 2 flights
		System.out.println(returnedSearchByEngineType.size());
		
		if(returnedSearchByEngineType.size() == 2 & returnedSearchByEngineType.contains(flight1) && returnedSearchByEngineType.contains(flight3)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	void testSearchForLandingList() {
		
		
		//Invoke the search
		ArrayList<Airline> returnedSearchForLandingList = AirtrafficControl.searchForLandingList(flights, engineType1, distanceToAifield);
		
		//should return 1 flight
		System.out.println(returnedSearchForLandingList.size());
		
		if(returnedSearchForLandingList.size() == 1 && returnedSearchForLandingList.contains(flight1)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
