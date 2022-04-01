
public class StopTimes 
{
	public int tripID;
	public String arrivalTime;
	public String departureTime;
	public int stopID;
	public int stopSequence;
	public String stopHeadsign;
	public int pickupType;
	public int dropoffType;
	public double distTraveled;
	
	public String toString()
	{
		return "tripID: " + tripID + "\n arrivalTime: " + arrivalTime + "\n departureTime: " + departureTime;
	}
	
}
