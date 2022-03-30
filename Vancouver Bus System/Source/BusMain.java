
import java.util.Scanner;

public class BusMain 
{
	public static void readInStopsFile(String filename)
	{
		
	}
	
	public static void readInTransfersFile(String filename)
	{
		
	}
	
	public static void readInStopTimesFile(String filename)
	{
		
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
			else if(userInput.equals("1"))
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
