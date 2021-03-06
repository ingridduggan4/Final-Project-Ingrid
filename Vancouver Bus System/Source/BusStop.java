import java.util.Arrays;
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
	
	
	public String toStringForSearch()
	{
		return "ID: " + iD + ", code: " + code + ", description: " + desc + ", latitude: " + latitude + ", longitude: " + longitude + ", zone ID: " + zoneID + ", stop URL: " + stopURL + ", location type: " + locationType + ", parent station: " + parentStation + "\n";
	}
	
	public void moveKeywordToEnd()
	{
		String stopName = name;
		
		String[] separateKeyword = stopName.split(" ",3);
		
		if(separateKeyword[0].equals("WB") || separateKeyword[0].equals("NB") || separateKeyword[0].equals("SB") || separateKeyword[0].equals("EB") || separateKeyword[0].equals("FLAGSTOP"))
		{
			if(separateKeyword[1].equals("WB") || separateKeyword[1].equals("NB") || separateKeyword[1].equals("SB") || separateKeyword[1].equals("EB") || separateKeyword[1].equals("FLAGSTOP"))
			{
				stopName = separateKeyword[2] + " " + separateKeyword[0] + " " + separateKeyword[1] ;
			}
			else
			{
				stopName = separateKeyword[1] + " " + separateKeyword[2] + " " + separateKeyword[0];
			
			}

		}
		
		name = stopName;
	}
	
	
	
}
