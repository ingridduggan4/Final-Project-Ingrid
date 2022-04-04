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
	
	public String toString()
	{
		return "iD: " + iD + "\n code: " + code + "\n name: " + name;
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
	
	public static void main(String[] args)
	{
		BusStop testStop = new BusStop(0,"0","WB HASTINGS ST FS HOLDOM AVE","0",0,0,"0","0","0");
		testStop.moveKeywordToEnd();
		
		System.out.println("STOP NAME MOVED KEYWORD: " + testStop.name);
	}
	
	
}
