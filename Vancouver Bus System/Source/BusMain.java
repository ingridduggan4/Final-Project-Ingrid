
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class BusMain 
{
	public static ArrayList<BusStop> readInStopsFile(String filename)
	{
		ArrayList<BusStop> busStopList = new ArrayList<BusStop>();
		
		try
    	{
         FileReader fr = new FileReader(filename);    
         BufferedReader br = new BufferedReader(fr);
	        
	        try
	        {
	        	String text=br.readLine();
	        	
	            while(text!=null)
	            {  
	            	BusStop busStop = new BusStop();
	            	
	            	String[] busStopData= text.split(",");
	            	busStop.iD = Integer.parseInt(busStopData[0]);
	            	busStop.code = Integer.parseInt(busStopData[1]);
	            	busStop.name = busStopData[2];
	            	busStop.desc = busStopData[3];
	            	busStop.latitude = Double.parseDouble(busStopData[4]);
	            	busStop.longitude = Double.parseDouble(busStopData[5]);
	            	busStop.zoneID = busStopData[6];
	            	busStop.stopURL = Integer.parseInt(busStopData[7]);
	            	busStop.locationType = Integer.parseInt(busStopData[8]);
	            	busStop.parentStation = busStopData[9];
	            	
	                busStopList.add(busStop);
	                text=br.readLine();
	            }
	
	            br.close();    
	            fr.close();
	            
	         }catch(Exception e){;}
        
    	}catch(Exception e){;}
		
		return busStopList;
	}
	
	public static ArrayList<Transfers> readInTransfersFile(String filename)
	{
		ArrayList<Transfers> transfersList = new ArrayList<Transfers>();
		
		try
    	{
         FileReader fr = new FileReader(filename);    
         BufferedReader br = new BufferedReader(fr);
	        
	        try
	        {
	        	String text=br.readLine();
	        	
	            while(text!=null)
	            {  
	            	Transfers transfer = new Transfers();
	            	
	            	String[] transferData= text.split(",");
	            	transfer.fromStopID = Integer.parseInt(transferData[0]);
	            	transfer.toStopID = Integer.parseInt(transferData[1]);
	            	transfer.transferType = Integer.parseInt(transferData[2]);
	            	transfer.minTransferTime = Integer.parseInt(transferData[3]);
	            	
	                transfersList.add(transfer);
	                text=br.readLine();
	            }
	
	            br.close();    
	            fr.close();
	            
	         }catch(Exception e){;}
        
    	}catch(Exception e){;}
		
		return transfersList;
    	
	}
	
	public static ArrayList<StopTimes> readInStopTimesFile(String filename)
	{
		ArrayList<StopTimes> stopTimesList = new ArrayList<StopTimes>();
		
		try
    	{
         FileReader fr = new FileReader(filename);    
         BufferedReader br = new BufferedReader(fr);
	        
	        try
	        {
	        	String text=br.readLine();
	        	
	            while(text!=null)
	            {  
	            	StopTimes stopTime = new StopTimes();
	            	
	            	String[] stopTimeData= text.split(",");
	            	stopTime.tripID = Integer.parseInt(stopTimeData[0]);
	            	stopTime.arrivalTime = stopTimeData[1];
	            	stopTime.departureTime = stopTimeData[2];
	            	stopTime.stopID = Integer.parseInt(stopTimeData[3]);
	            	stopTime.stopSequence = Integer.parseInt(stopTimeData[4]);
	            	stopTime.stopHeadsign = Integer.parseInt(stopTimeData[5]);
	            	stopTime.pickupType = Integer.parseInt(stopTimeData[6]);
	            	stopTime.dropoffType = Integer.parseInt(stopTimeData[7]);
	            	stopTime.distTraveled = Double.parseDouble(stopTimeData[3]);
	            	
	                stopTimesList.add(stopTime);
	                text=br.readLine();
	            }
	
	            br.close();    
	            fr.close();
	            
	         }catch(Exception e){;}
        
    	}catch(Exception e){;}
		
		return stopTimesList;
	}

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Vancouver Bus System!");
		System.out.println("What would you like to do next?");
		System.out.println("(1) Find the shortest path between two bus stops");
		System.out.println("(2) Search for a bus stop by name" );
		System.out.println("(3) Search for all trips with a certain arrival time");
		System.out.println("(Please enter either 1,2,3 or 'quit')");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		readInTransfersFile("Transfers");
		
		while(!userInput.equalsIgnoreCase("quit"))
		{
			System.out.println("What would you like to do next?");
			System.out.println("(1) Find the shortest path between two bus stops");
			System.out.println("(2) Search for a bus stop by name" );
			System.out.println("(3) Search for all trips with a certain arrival time");
			System.out.println("(Please enter either 1,2,3 or 'quit')");
			userInput = input.next();
			
			if(userInput!="1" && userInput != "2" && userInput != "3" && !userInput.equalsIgnoreCase("quit"))
			{
				System.out.println("Error: invalid input");

			}
			
			if(userInput.equals("1"))
			{
				System.out.print("ONE");
			}
			else if(userInput.equals("2"))
			{
				
			}
			else if(userInput.equals("3"))
			{
				
			}
		}
		
		System.out.print("Thank you for using the Vancouver Bus System, goodbye!");
	}

}
