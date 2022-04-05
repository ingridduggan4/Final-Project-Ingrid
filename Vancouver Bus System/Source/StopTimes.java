
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
		return "tripID: " + tripID + "\narrivalTime: " + arrivalTime + "\ndepartureTime: " + departureTime + "\nstopID: " + stopID + "\nstopSequence: " + stopSequence + "\nStop Headsign: " + stopHeadsign + "\npickupType: " + pickupType + "\ndropoffType: " + dropoffType + "\ndistanceTraveled: " + distTraveled;
	}
	
}
