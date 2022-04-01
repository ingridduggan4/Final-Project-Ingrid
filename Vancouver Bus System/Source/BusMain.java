
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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
	  
	        	//System.out.println("TEXT: " + text);
	        	
	              
	            	
	            	for(int i = 0; i < 8758; i++)
	            	{
	            		String text=br.readLine();
	            		System.out.println("ENTER");
		            	
		            	
		            	String[] busStopData= text.split(",");
		            	System.out.print(Arrays.toString(busStopData));
		          
		            	int iD = Integer.parseInt(busStopData[0]);
		            	String code = busStopData[1];
		            	String name = busStopData[2];
		            	String desc = busStopData[3];
		            	Double latitude = Double.parseDouble(busStopData[4]);
		            	Double longitude = Double.parseDouble(busStopData[5]);
		            	String zoneID = busStopData[6];
		            	
		            	String stopURL = busStopData[7];
		            	
		            	String locationType = busStopData[8];
		            	
		
		            	BusStop busStop = new BusStop(iD, code, name, desc, latitude, longitude, zoneID, stopURL, locationType);
		            
		            	
		            	
		            	
		                busStopList.add(busStop);
		                
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
	            	stopTime.distTraveled = Double.parseDouble(stopTimeData[8]);
	            	
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
		System.out.println("(A) Find the shortest path between two bus stops");
		System.out.println("(B) Search for a bus stop by name" );
		System.out.println("(C) Search for all trips with a certain arrival time");
		System.out.println("(Please enter either A,B,C or 'quit')");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		readInTransfersFile("Transfers");
		
		while(!userInput.equalsIgnoreCase("quit"))
		{

			
			if(userInput.equalsIgnoreCase("A"))
			{
				System.out.println("ONE");
				
			}
			else if(userInput.equalsIgnoreCase("B"))
			{
				System.out.println("TWO");
				ArrayList<BusStop> busStopList = readInStopsFile("Stops");
				System.out.print("SIZE: "+busStopList.size());
				BusStop firstStop = busStopList.get(8756);
				System.out.println("FIRST STOP: ");
				System.out.print(firstStop.toString());
			}
			else if(userInput.equalsIgnoreCase("C"))
			{
				System.out.println("THREE");
			}
			else if(!userInput.equalsIgnoreCase("quit"))
			{
				System.out.println("Error: invalid input");

			}
			
			System.out.println("What would you like to do next?");
			System.out.println("(A) Find the shortest path between two bus stops");
			System.out.println("(B) Search for a bus stop by name" );
			System.out.println("(C) Search for all trips with a certain arrival time");
			System.out.println("(Please enter either A,B,C or 'quit')");
			userInput = input.next();
			
			
		}
		
		System.out.print("Thank you for using the Vancouver Bus System, goodbye!");
	}

}
