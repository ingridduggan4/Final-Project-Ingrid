import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Transfers 
{
	int fromStopID;
	int toStopID;
	int transferType;
	int minTransferTime;
	
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
	                
	                System.out.println(transfer.fromStopID);
	                System.out.println(transfer.toStopID);
	                System.out.println(transfer.transferType);
	                System.out.println(transfer.minTransferTime);
	            }
	
	            br.close();    
	            fr.close();
	            
	         }catch(Exception e){;}
        
    	}catch(Exception e){;}
		
		return transfersList;
    	
	}
}
