import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Transfers 
{
	public int fromStopID;
	public int toStopID;
	public int transferType;
	public int minTransferTime;
	
	public String toString()
	{
		return "From: " + fromStopID + "\n To: " + toStopID + "\n transferType: " + transferType + "\n Min Transfer Time: " + minTransferTime;
	}
}
