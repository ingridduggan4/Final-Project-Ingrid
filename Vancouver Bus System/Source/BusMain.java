
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
	            	
	            	for(int i = 0; i < 8758; i++)
	            	{
	            		String text=br.readLine();
	            		//System.out.println("ENTER");
		            	
		            	
		            	String[] busStopData= text.split(",");
		            	//System.out.print(Arrays.toString(busStopData));
		          
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
	            	stopTime.stopID = stopTimeData[3];
	            	
	            	stopTime.stopSequence = Integer.parseInt(stopTimeData[4]);
	            	stopTime.stopHeadsign = stopTimeData[5];
	            	stopTime.pickupType = Integer.parseInt(stopTimeData[6]);
	            	stopTime.dropoffType = Integer.parseInt(stopTimeData[7]);
	            	
	            	
	            	if(stopTimeData.length == 9)
	            	{
	            		stopTime.distTraveled = Double.parseDouble(stopTimeData[8]);
	            	}
	            	else
	            	{
	            		stopTime.distTraveled = 0;
	            	}
	            	
	            	/*if(stopTimeData[8] == "")
	            	{
	            		stopTime.distTraveled = Double.parseDouble(stopTimeData[8]);
	            	}
	            	*/
	            	
	            	/*
	            	String[] arrivalTime = stopTimeData[1].split(":");
	            	String[] departureTime = stopTimeData[2].split(":");
	            	
	            	if(Integer.parseInt(arrivalTime[0]) > 24 && Integer.parseInt(departureTime[0]) > 24)
	            	{
	            		System.out.print("INVALID TIME: " + arrivalTime[0] + ", " + departureTime[0]);
	            	}
	            	*/
	            	
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
		ArrayList<StopTimes> stopTimesList = readInStopTimesFile("Stop Times");
		ArrayList<Transfers> transfersList = readInTransfersFile("Transfers");
		ArrayList<BusStop> busStopList = readInStopsFile("Stops");
		
		System.out.println("Welcome to the Vancouver Bus System!");
		System.out.println("What would you like to do next?");
		System.out.println("(A) Find the shortest path between two bus stops");
		System.out.println("(B) Search for a bus stop by name" );
		System.out.println("(C) Search for all trips with a certain arrival time");
		System.out.println("(Please enter either A,B,C or 'quit'): ");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		
		while(!userInput.equalsIgnoreCase("quit"))
		{
			if(userInput.equalsIgnoreCase("A"))
			{
				System.out.print("Please enter the first bus stop ID: ");
				int firstStop = input.nextInt();
				System.out.print("Please enter the second bus stop ID: ");
				int secondStop = input.nextInt();
				boolean validFirstStop = false;
				boolean validSecondStop = false;
				
				for(int i = 0; i < busStopList.size(); i++)
				{
					if(busStopList.get(i).iD == firstStop)
					{
						validFirstStop = true;
					}
					
					if(busStopList.get(i).iD == secondStop)
					{
						validSecondStop = true;
					}
				}
				
				if(validFirstStop == false || validSecondStop == false)
				{
					System.out.println("Error: invalid stop ID");
				}
				else
				{
					System.out.println("SUCCESS!");
				}
				
				
				
			}
			else if(userInput.equalsIgnoreCase("B"))
			{

				//System.out.print("SIZE: "+ busStopList.size());
				//BusStop firstStop = busStopList.get(0);
				//System.out.println("FIRST Stop: ");
				//System.out.print(firstStop.toString());
				
				System.out.print("Please enter the stop you would like to search for: ");
				
				if(input.hasNext())
				{
					String userString = input.next();
					TST<BusStop> busStopTST = new TST();
					//System.out.println("You entered: " + userString);
					
					for(int i = 0; i < busStopList.size(); i++)
					{
						BusStop currentStop = busStopList.get(i);
						currentStop.moveKeywordToEnd();
						busStopList.set(i, currentStop);
						busStopTST.put(currentStop.name, currentStop);
					}
					
					//BusStop firstStop = busStopList.get(0);
					//.out.println("FIRST Stop: ");
					//System.out.println(firstStop.name);
					//System.out.print(busStopTST.keysWithPrefix(userString));
					
					System.out.print("\n");
					System.out.print("Here are all the stops matching your search: \n");
					System.out.print("\n");
					
					int stopCount = 0;
					
					Iterable<String> stops = busStopTST.keysWithPrefix(userString);
					for(String stop : stops)
					{
						stopCount++;
						BusStop currentStop = busStopTST.get(stop);
						System.out.println(stopCount + ": " +stop);
						System.out.print(currentStop.toStringForSearch());
						System.out.println("");
					}
					
				}
			}
			
			else if(userInput.equalsIgnoreCase("C"))
			{
				System.out.println("THREE");
	
	            for(int i = 0; i < stopTimesList.size(); i++)
	            {
	            	String arrivalTime = stopTimesList.get(i).arrivalTime.trim();
	            	String[] arrivalTimeArray = arrivalTime.split(":");
	            	
	            	if(Integer.parseInt(arrivalTimeArray[0]) > 23)
	            	{
	            		//System.out.println("INVALID TIME: " + arrivalTimeArray[0] + ", " + departureTimeArray[0]);
	            		stopTimesList.remove(i);
	            	}
	            	
	            }
				
				
				//System.out.print("SIZE: "+ stopTimesList.size());
				//StopTimes firstTime = stopTimesList.get(0);
				//System.out.println("FIRST Stop: ");
				//System.out.print(firstTime.toString());
				
				System.out.print("Please enter the arrival time you would like to search for, with the format hh:mm:ss : ");
				
				String userArrivalTime = input.next().trim();
				
				if(!validateUserTime(userArrivalTime)) 
				{
					System.out.print("Sorry - invalid time");
				}
				else
				{
					
				
				
					ArrayList<StopTimes> stopTimesMatchingCriteriaList = new ArrayList<StopTimes>();
					
					for(int i = 0; i < stopTimesList.size(); i++)
					{
						
						StopTimes currentStopTime = stopTimesList.get(i);
						String currentArrivalTime = currentStopTime.arrivalTime.trim();
						String[] currentArrivalTimeArray = currentArrivalTime.split(":");
						String[] userArrivalTimeArray = userArrivalTime.split(":");
						
						if(Integer.parseInt(currentArrivalTimeArray[0]) == Integer.parseInt(userArrivalTimeArray[0]) && Integer.parseInt(currentArrivalTimeArray[1]) == Integer.parseInt(userArrivalTimeArray[1]) && Integer.parseInt(currentArrivalTimeArray[2]) == Integer.parseInt(userArrivalTimeArray[2]))
						{
							//System.out.print("ENTER 2");
							stopTimesMatchingCriteriaList.add(currentStopTime);
							//System.out.println(currentStopTime.toString());
						}
						
					}
					
					Integer[] tripIdArray = new Integer[stopTimesMatchingCriteriaList.size()];
					
					for(int i = 0; i < stopTimesMatchingCriteriaList.size(); i++)
					{
						StopTimes currentStopTime = stopTimesMatchingCriteriaList.get(i);
						tripIdArray[i] = currentStopTime.tripID;
					}
					
					Insertion.sort(tripIdArray);
					//System.out.println("SORTED: ");
					//System.out.println(Arrays.toString(tripIdArray));
					
					System.out.println("Here are all the trips with the arrival time of " + userArrivalTime + ": ");
					
					for(int i = 0; i < tripIdArray.length; i ++)
					{
						for(int j = 0; j < stopTimesMatchingCriteriaList.size(); j++)
						{
							if(tripIdArray[i] == stopTimesMatchingCriteriaList.get(j).tripID)
							{
								System.out.println(stopTimesMatchingCriteriaList.get(j).toString());
							}
						}
					}
					
					/*
					for(int i = 0; i < stopTimesMatchingCriteriaList.size(); i++)
					{
						System.out.println(stopTimesMatchingCriteriaList.get(i).toString());
					}
					*/
					
				}
				
				
			}
			else if(!userInput.equalsIgnoreCase("quit"))
			{
				System.out.println("Error: invalid input");

			}
			
			System.out.println("What would you like to do next?");
			System.out.println("(A) Find the shortest path between two bus stops");
			System.out.println("(B) Search for a bus stop by name");
			System.out.println("(C) Search for all trips with a certain arrival time");
			System.out.println("(Please enter either A,B,C or 'quit'): ");
			userInput = input.next();
			
			
		}
		
		System.out.print("Thank you for using the Vancouver Bus System, goodbye!");
	}
	
	public static boolean validateUserTime(String userTime)
	{
		boolean valid = true;
		
		String[] userTimeArray = userTime.split(":");
		
		if(userTimeArray.length != 3)
		{
			valid = false;
		}
		
		if(Integer.parseInt(userTimeArray[0]) <0 || Integer.parseInt(userTimeArray[0]) > 23)
		{
			valid = false;
		}
		
		if(Integer.parseInt(userTimeArray[1]) <0 || Integer.parseInt(userTimeArray[1]) > 59)
		{
			valid = false;
		}
		
		if(Integer.parseInt(userTimeArray[2]) <0 || Integer.parseInt(userTimeArray[2]) > 59)
		{
			valid = false;
		}
		
		
		return valid;
	}
	

}
