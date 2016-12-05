package Voting;
import java.io.*;
import java.util.Scanner;
/**
 * A handler for the IO operations concerning the printer.
 */
public class IOHandler {	
	/**
	 * handles printing the results from a flat file
	 */
	public void printResults()
	{
		File results = new File("results.txt");
		try 
		{
			Scanner scan = new Scanner(results);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				System.out.println(line);
			}
			scan.close();			
		}
			
		catch(Exception e){
			
		}
	}
	
	/**
	 * handles printing the recount from a flat file
	 */
	public void printRecount()
	{
		File recount = new File("recount.txt");
		try 
		{
			Scanner scan = new Scanner(recount);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				System.out.println(line);
			}
			scan.close();			
		}
			
		catch(Exception e){
			
		}
	}
}

