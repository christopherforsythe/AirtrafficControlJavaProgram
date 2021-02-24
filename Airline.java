/**
 * 
 */
package p2;

/**
 * @author chrisforsythe
 * student number - 40134121
 *
 */
public class Airline extends Aircraft {
	
	//instance vars
	/**
	 * engine type of aircraft
	 */
	private String engineType;

	
	//constructors
	/**
	 * default constructor
	 */
	public Airline() {
	}

	/**
	 * constructor with args using the super class 
	 * and setEngineType to comply with business rule
	 * @param currentSpeed
	 * @param distanceToAirfield
	 * @param aircraftCode
	 * @param engineType
	 */
	public Airline(int currentSpeed, int distanceToAirfield, String aircraftCode, String engineType) {
		super(currentSpeed, distanceToAirfield, aircraftCode);
		this.setEngineType(engineType);
		
	}

	//methods
	/**
	 * @return the engineType
	 */
	public String getEngineType() {
		return engineType;
	}

	/**
	 * 
	 * @param engineType - string
	 * @throws IllegalArgumentException
	 * engine type must be either jet or propeller to meet business rule
	 */
	public void setEngineType(String engineType) throws IllegalArgumentException{
		if(engineType.equalsIgnoreCase("jet") || engineType.equalsIgnoreCase("propeller")) {
			this.engineType = engineType;
		} else {
			throw new IllegalArgumentException("INVALID ENGINE TYPE");
		}
	}
	
	@Override
	/**
	 * returns time to airfield in minutes after calculating 
	 *  time = distance to airfield/ current speed *60
	 */
	public double timeToAirfield(int distanceToAirfield, int currentSpeed) {
	
		//Create time var - double
		double time= 0;
		
		//time = distance to airfield/ current speed *60
		time = distanceToAirfield / currentSpeed * 60;
		
		return time;
	}
}
