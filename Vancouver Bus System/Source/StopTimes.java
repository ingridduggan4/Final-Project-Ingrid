
public class StopTimes 
{
	public int tripID;
	public String arrivalTime;
	public String departureTime;
	public String stopID;
	public int stopSequence;
	public String stopHeadsign;
	public int pickupType;
	public int dropoffType;
	public double distTraveled;
	
	public String toString()
	{
		return "tripID: " + tripID + ", arrivalTime: " + arrivalTime + ", departureTime: " + departureTime + ", stopID: " + stopID + ", stopSequence: " + stopSequence + ", Stop Headsign: " + stopHeadsign + ", pickupType: " + pickupType + ", dropoffType: " + dropoffType + ", distanceTraveled: " + distTraveled + "\n";
	}
	
}
