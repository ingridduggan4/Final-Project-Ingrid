
public class BusStop 
{
	public int iD;
	public String code;
	public String name;
	public String desc;
	public double latitude;
	public double longitude;
	public String zoneID;
	public String stopURL;
	public String locationType;
	public String parentStation;
	
	
	public void setiD(int iD)
	{
		this.iD = iD;
	}
	
	public BusStop(int iD, String code, String name, String desc, double latitude, double longitude, String zoneID, String stopURL, String locationType)
	{
		this.iD = iD;
		this.code = code;
		this.name = name;
		this.desc = desc;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zoneID = zoneID;
		this.stopURL = stopURL;
		this.locationType = locationType;
		this.parentStation = parentStation;
	}
	
	public String toString()
	{
		return "iD: " + iD + "\n code: " + code + "\n name: " + name;
	}
	
}
