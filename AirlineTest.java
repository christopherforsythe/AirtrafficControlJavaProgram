package p2;
/**
 * author - chris forsythe
 * student number = 40134121
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p2.Airline;

class AirlineTest {
	
	//test data
	Airline airline;
	//current speed
	int currentSpeedValidLower, currentSpeedValidUpper, currentSpeedInvalidLower, currentSpeedInvalidUpper;
	//airfield distance
	int airfieldDistanceValidLower, airfieldDistanceValidUpper, airfieldDistanceInvalidLower, airfieldDistanceInvalidUpper;
	//aircraft code
	String aircraftCodeValid, aircraftCodeInvalid;
	//Engine type
	String engineTypeValidPropeller, engineTypeValidJet, engineTypeInvalid;
	

	@BeforeEach
	void setUp() throws Exception {
		
		//set up test data
		airline = new Airline();
		
		currentSpeedValidLower = 0;
		currentSpeedValidUpper = 800;
		currentSpeedInvalidLower = -1;
		currentSpeedInvalidUpper = 801;
		
		airfieldDistanceValidLower = 1;
		airfieldDistanceValidUpper = 20000;
		airfieldDistanceInvalidLower = 0;
		airfieldDistanceInvalidUpper = 20001;
		
		aircraftCodeValid = "Avalid";
		aircraftCodeInvalid = "";
		
		engineTypeValidPropeller = "propeller";
		engineTypeValidJet = "jet";
		engineTypeInvalid = "invalid";
	}

	

	@Test
	void testAirlineDefaultConstructor() {
		
		Airline airlineTest = new Airline();
		assertNotNull(airlineTest);
	}

	@Test
	void testAirlineConstructorWithArgsValid() {
		
		Airline aTest = new Airline(currentSpeedValidLower, airfieldDistanceValidLower, aircraftCodeValid, engineTypeValidJet);
		assertEquals(currentSpeedValidLower, aTest.getCurrentSpeed());
		assertEquals(airfieldDistanceValidLower, aTest.getDistanceToAirfield());
		assertEquals(aircraftCodeValid, aTest.getAircraftCode());
		assertEquals(engineTypeValidJet, aTest.getEngineType());
		
		Airline aTest2 = new Airline(currentSpeedValidUpper, airfieldDistanceValidUpper, aircraftCodeValid, engineTypeValidPropeller);
		assertEquals(currentSpeedValidUpper, aTest2.getCurrentSpeed());
		assertEquals(airfieldDistanceValidUpper, aTest2.getDistanceToAirfield());
		assertEquals(aircraftCodeValid, aTest2.getAircraftCode());
		assertEquals(engineTypeValidPropeller, aTest2.getEngineType());
		
	}

	@Test
	void testAirlineConstructorWithArgsInvalid() {
	
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a1 = new Airline(currentSpeedInvalidLower, airfieldDistanceValidLower, aircraftCodeValid, engineTypeValidPropeller);
		});
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a2 = new Airline(currentSpeedInvalidUpper, airfieldDistanceValidLower, aircraftCodeValid, engineTypeValidPropeller);
		});
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a3 = new Airline(currentSpeedValidLower, airfieldDistanceInvalidLower, aircraftCodeValid, engineTypeValidJet);
		});
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a4 = new Airline(currentSpeedValidLower, airfieldDistanceInvalidUpper, aircraftCodeValid, engineTypeValidJet);
		});
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a5 = new Airline(currentSpeedValidLower, airfieldDistanceValidLower, aircraftCodeInvalid, engineTypeValidJet);
		});
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			Airline a6 = new Airline(currentSpeedValidLower, airfieldDistanceValidLower, aircraftCodeValid, engineTypeInvalid);
		});
	}
	@Test
	void testGetSetEngineTypeValid() {
		
		airline.setEngineType(engineTypeValidJet);
		assertEquals(engineTypeValidJet, airline.getEngineType());
		
		airline.setEngineType(engineTypeValidPropeller);
		assertEquals(engineTypeValidPropeller, airline.getEngineType());
	}

	@Test
	void testGetSetEngineTypeInvalid() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setEngineType(engineTypeInvalid);
		});
		
		//print message to see
		System.out.println(e.getMessage());
		
		//check message for clarity
		assertEquals("INVALID ENGINE TYPE", e.getMessage());
	}
	
	@Test
	void testGetSetCurrentSpeedValid() {
		
		airline.setCurrentSpeed(currentSpeedValidLower);
		assertEquals(currentSpeedValidLower, airline.getCurrentSpeed());
		
		airline.setCurrentSpeed(currentSpeedValidUpper);
		assertEquals(currentSpeedValidUpper, airline.getCurrentSpeed());
	}
	
	@Test
	void testGetSetCurrentSpeedInvalid() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setCurrentSpeed(currentSpeedInvalidLower);
		});
		
		//print message to see
		System.out.println(e.getMessage());
		
		//check message
		assertEquals("INVALID SPEED", e.getMessage());
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setCurrentSpeed(currentSpeedInvalidUpper);
		});
		
		//print message to see
		System.out.println(e.getMessage());
		
		assertEquals("INVALID SPEED", e.getMessage());

	}

	@Test
	void testGetSetDistanceToAirfieldValid() {
	
		airline.setDistanceToAirfield(airfieldDistanceValidLower);
		assertEquals(airfieldDistanceValidLower, airline.getDistanceToAirfield());
		
		airline.setDistanceToAirfield(airfieldDistanceValidUpper);
		assertEquals(airfieldDistanceValidUpper, airline.getDistanceToAirfield());
	}
	
	@Test
	void testGetSetDistanceToAirfieldInvalid() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setDistanceToAirfield(airfieldDistanceInvalidLower);
		});
		
		//print message to see
		System.out.println(e.getMessage());
		
		//check message
		assertEquals("INVALID DISTANCE", e.getMessage());
		
		
	e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setDistanceToAirfield(airfieldDistanceInvalidUpper);
		});
		
		//print message to see
		System.out.println(e.getMessage());
		
		//check message
		assertEquals("INVALID DISTANCE", e.getMessage());
		
	}
	

	@Test
	void testGetSetAircraftCodeValid() {
		
		airline.setAircraftCode(aircraftCodeValid);
		assertEquals(aircraftCodeValid, airline.getAircraftCode());
	}
	
	
	
	@Test
	void testGetSetAircraftCodeInvalid() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			airline.setAircraftCode(aircraftCodeInvalid);
		});
		
		//print message
		System.out.println(e.getMessage());
		
		//check message
		assertEquals("INVALID CODE", e.getMessage());
	}
	
	
	@Test
	void testTimeToAirfieldValid() {
		
		//invoke the method
		airline.timeToAirfield(airfieldDistanceValidUpper, currentSpeedValidUpper);
		
		assertEquals(1440, airline.timeToAirfield(airfieldDistanceValidUpper, currentSpeedInvalidUpper));
		
	}
	

}
