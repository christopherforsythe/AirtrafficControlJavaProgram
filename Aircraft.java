package p2;

/**
 * 
 * 
 * @author - Chris Forysthe
 * Student Number - 40134121		
 *
 */
public abstract class Aircraft {

	//constants for business rule implementation
	public static final int MIN_SPEED = 0;
	public static final int MAX_SPEED = 800;
	
	public static final int AIRFIELD_DISTANCE_MIN = 1;
	public static final int AIRFIELD_DISTANCE_MAX = 20000;
	
	public static final int AIRCRAFT_CODE_LENGTH = 6;
	
	//instance vars
	/**
	 * current speed of aircraft
	 */
	private int currentSpeed; 
	/**
	 * distance to airfield
	 */
	private int distanceToAirfield; 
	/**
	 * aircraft code
	 */
	private String aircraftCode; 
	
	
	//constructors
	
	/**
	 * Default constructor
	 */
	public Aircraft() {

	}

	/**
	 * constructor with args that call set methods to ensure business rules are met
	 * @param currentSpeed
	 * @param distanceToAirfield
	 * @param aircraftCode
	 */
	public Aircraft(int currentSpeed, int distanceToAirfield, String aircraftCode) {
		this.setCurrentSpeed(currentSpeed);
		this.setDistanceToAirfield(distanceToAirfield);
		this.setAircraftCode(aircraftCode);
	}
	

	//methods
	
	/**
	 * 
	 * @return - current speed
	 */
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * 
	 * @param currentSpeed - int
	 * @throws IllegalArgumentException
	 * speed must be between 0 - 800(inclusive) mph
	 */
	public void setCurrentSpeed(int currentSpeed) throws IllegalArgumentException {

		if(currentSpeed >= MIN_SPEED && currentSpeed <= MAX_SPEED) {
			this.currentSpeed = currentSpeed;
		} else {
			throw new IllegalArgumentException("INVALID SPEED");
		}
	}

	/**
	 * 
	 * @return - distance to airfield
	 */
	public int getDistanceToAirfield() {
		return distanceToAirfield;
	}

	/**
	 * 
	 * @param distanceToAirfield - int
	 * @throws IllegalArgumentException
	 * Distance must be between 1 - 20000(inclusive) miles
	 */
	public void setDistanceToAirfield(int distanceToAirfield) throws IllegalArgumentException{
		
		if(distanceToAirfield >= AIRFIELD_DISTANCE_MIN && distanceToAirfield <= AIRFIELD_DISTANCE_MAX) {
			this.distanceToAirfield = distanceToAirfield;
		} else {
			throw new IllegalArgumentException("INVALID DISTANCE");
		}
	} 

	/**
	 * @return the aircraftCode
	 */
	public String getAircraftCode() {
		return aircraftCode;
	}

	/**
	 * 
	 * @param aircraftCode - string
	 * @throws IllegalArgumentException
	 * aircraft code must be 6 characters in length and begin with A to meet business rule
	 */
	public void setAircraftCode(String aircraftCode) throws IllegalArgumentException {
		
		if(aircraftCode.length() == AIRCRAFT_CODE_LENGTH && aircraftCode.charAt(0) == 'A') {
			this.aircraftCode = aircraftCode;
		} else {
			throw new IllegalArgumentException("INVALID CODE");
		}
	}

	/**
	 * ABSTRACT METHOD
	 * calculates time to airfield in minutes in subclasses
	 * 
	 */
	public abstract double timeToAirfield(int distanceToAirfield, int currentSpeed);
	
}// end of class
