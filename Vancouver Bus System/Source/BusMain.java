
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
		            	
		            	
		            	String[] busStopData= text.split(",");
		          
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
	            	stopTime.stopID = Integer.parseInt(stopTimeData[3]);
	            	
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
	            	
	            	if(validateUserTime(stopTime.arrivalTime) == true && validateUserTime(stopTime.departureTime))
	            	{
		            	stopTimesList.add(stopTime);
	            	}

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
		
        for(int i = 0; i < stopTimesList.size(); i++)
        {
        	String arrivalTime = stopTimesList.get(i).arrivalTime.trim();
        	String[] arrivalTimeArray = arrivalTime.split(":");
        	
        	if(Integer.parseInt(arrivalTimeArray[0]) > 23)
        	{
        		stopTimesList.remove(i);
        	}
        	
        }
		
		System.out.println("Welcome to the Vancouver Bus System!");
		System.out.println("What would you like to do next?");
		System.out.println("(A) Find the shortest path between two bus stops");
		System.out.println("(B) Search for a bus stop by name" );
		System.out.println("(C) Search for all trips with a certain arrival time");
		System.out.println("(Please enter either A,B,C or 'QUIT'): ");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		
		
		while(!userInput.equalsIgnoreCase("QUIT"))
		{
			if(userInput.equalsIgnoreCase("A"))
			{

				boolean exit = false;
				
				while(!exit)
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
						System.out.println("\n" + "Error: invalid stop ID" + "\n");
					}
					else
					{
						exit = true;
						EdgeWeightedDigraph busNetwork = new EdgeWeightedDigraph(stopTimesList.size());
						
						for(int i = 0; i < stopTimesList.size()-1; i++)
						{
							if(stopTimesList.get(i).tripID == stopTimesList.get(i+1).tripID)
							{
								DirectedEdge currentEdge = new DirectedEdge(stopTimesList.get(i).stopID, stopTimesList.get(i+1).stopID,1);
								busNetwork.addEdge(currentEdge);
							}
						}
						
						for(int i = 0; i < transfersList.size(); i++)
						{
							int cost = 0;
							
							if(transfersList.get(i).transferType == 0)
							{
								cost = 2;
							}
							else if(transfersList.get(i).transferType == 2)
							{
								cost = transfersList.get(i).minTransferTime/100;
							}
							
							DirectedEdge currentEdge = new DirectedEdge(transfersList.get(i).fromStopID, transfersList.get(i).toStopID, cost);
							busNetwork.addEdge(currentEdge);
						}
						
						DijkstraSP shortestBusPaths = new DijkstraSP(busNetwork, firstStop);
						Iterable<DirectedEdge> shortestPath = shortestBusPaths.pathTo(secondStop);
						
						System.out.println("\n" + "The shortest path between stop " + firstStop + " and stop " + secondStop + " is: ");
						System.out.println(shortestPath);
						System.out.println("The total cost is: " + shortestBusPaths.distTo(secondStop) + "\n");
						
						
					}
				 }
				
				
			}
			else if(userInput.equalsIgnoreCase("B"))
			{
				boolean exit = false;
				
				while(!exit)
				{
				
					System.out.print("Please enter the stop you would like to search for: ");
					
					if(input.hasNext())
					{
						String userString = input.next();
						TST<BusStop> busStopTST = new TST();
						
						for(int i = 0; i < busStopList.size(); i++)
						{
							BusStop currentStop = busStopList.get(i);
							currentStop.moveKeywordToEnd();
							busStopList.set(i, currentStop);
							busStopTST.put(currentStop.name, currentStop);
						}
						
						int stopCount = 0;
						
						Iterable<String> stops = busStopTST.keysWithPrefix(userString);
						
						for(String stop : stops)
						{
							stopCount++;
							
							if(stopCount == 1)
							{
								System.out.print("\n");
								System.out.print("Here are all the stops matching your search: \n");
								System.out.print("\n");
							}
							
							BusStop currentStop = busStopTST.get(stop);
							System.out.println(stopCount + ": " +stop);
							System.out.print(currentStop.toStringForSearch());
							System.out.println("");
							exit = true;
						}
						
						if(stopCount == 0)
						{
							System.out.print("\n" + "Sorry, there are no stops matching your search. Please try again." + "\n");
						}
						
					}
				}
			}
			
			else if(userInput.equalsIgnoreCase("C"))
			{
				
				boolean exit = false;
				
				while(!exit)
				{
				
					System.out.print("Please enter the arrival time you would like to search for, with the format hh:mm:ss : ");
					
					String userArrivalTime = input.next().trim();
					
					if(!validateUserTime(userArrivalTime)) 
					{
						System.out.println("\nSorry - invalid time\n");
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
								stopTimesMatchingCriteriaList.add(currentStopTime);
							}
							
						}
						
						Integer[] tripIdArray = new Integer[stopTimesMatchingCriteriaList.size()];
						
						for(int i = 0; i < stopTimesMatchingCriteriaList.size(); i++)
						{
							StopTimes currentStopTime = stopTimesMatchingCriteriaList.get(i);
							tripIdArray[i] = currentStopTime.tripID;
						}
						
						Insertion.sort(tripIdArray);
						int timeCount = 0;
						
						
						for(int i = 0; i < tripIdArray.length; i ++)
						{
							for(int j = 0; j < stopTimesMatchingCriteriaList.size(); j++)
							{
								if(tripIdArray[i] == stopTimesMatchingCriteriaList.get(j).tripID)
								{
									timeCount++;
									if(timeCount == 1)
									{
										System.out.println("Here are all the trips with the arrival time of " + userArrivalTime + ": ");
									}
									
									System.out.println(stopTimesMatchingCriteriaList.get(j).toString());
									exit = true;
								}
							}
						}
						
						if(timeCount == 0)
						{
							System.out.println("\nSorry, there are no times matching your search. Please try again.\n");
						}
						
					}
				}
				
			}
			else if(!userInput.equalsIgnoreCase("QUIT"))
			{
				System.out.println("Error: invalid input");

			}
			
			System.out.println("\n" + "What would you like to do next?");
			System.out.println("(A) Find the shortest path between two bus stops");
			System.out.println("(B) Search for a bus stop by name");
			System.out.println("(C) Search for all trips with a certain arrival time");
			System.out.println("(Please enter either A,B,C or 'QUIT'): ");
			userInput = input.next();
			
			
		}
		
		System.out.print("Thank you for using the Vancouver Bus System, have a nice day!");
	}
	
	public static boolean validateUserTime(String userTime)
	{
		boolean valid = true;
		String hours = "24";
		String minutes = "60";
		String seconds = "60";
		
		String[] userTimeArray = userTime.split(":");
		
		if(userTimeArray[0].compareTo(hours)>=0)
		{
			valid = false;
		}
		
		if(userTimeArray[1].compareTo(minutes)>=0)
		{
			valid = false;
		}
		
		if(userTimeArray[2].compareTo(seconds)>=0)
		{
			valid = false;
		}
		
		return valid;
	}
	

}
