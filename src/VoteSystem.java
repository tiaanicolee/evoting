import java.util.Scanner;
import java.io.*;

/**
 * The VoteSystem class controls how the voting software runs, and it controls the 
 * interaction between the data and UI.
 */
public class VoteSystem {
	public String username;
	public String password;
	public int id;
	private int voteCount;		//number of votes the voter has made, should be 0 or 1
	public String results;
	public String choice;
	public Candidate candidates[];
	
	/*
	 * Main method to run the voting software.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input;
		
		VoteSystem vote = new VoteSystem();
		
		System.out.print("Are you a voter or an election officer? V/EO ");
		input = in.nextLine();
		if(input.equals("V")) {			//if they are a voter
			if (vote.login("voter") == true) {
				System.out.printf("\nCandidates:\n");
				vote.readCandidates();
				for (Candidate C : vote.candidates)
				{
					if (C != null)
							System.out.println(C.getParty() + " party: " + C.getName());
				}
				System.out.printf("\nEnter the name of the candidate you are voting for: ");
				input = in.nextLine();
			}
			else
				System.out.println("You could not be logged in.");
		}
		else if (input.equals("EO")) {	//if they are an election officer
			if (vote.login("eo") == true) {
				
			}
			else
				System.out.println("You could not be logged in.");
		}
		else 
			System.exit(0);
	}
	
	public boolean login(String role)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter username: ");
		username = in.nextLine();
		System.out.print("Enter password: ");
		password = in.nextLine();
		
		RegisterUserDBHandler handler = new RegisterUserDBHandler();
		return handler.findUser(username, password, role);
	}
	
	/*
	 * Method for the voter that selects a candidate
	 * Returns true if the Candidate is found
	 */
	public boolean select()
	{
		Scanner in = new Scanner(System.in);
		return true;
	}
	
	public void readCandidates()
	{
		String fileName = "candidates.txt";
		String line;
		int counter = 0;
		candidates = new Candidate[10];
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				String lineSplit[] = line.split(", ");
				Candidate c = new Candidate(lineSplit[0], lineSplit[1]);
				candidates[counter] = c;
				counter++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/*
	 * Method for the voter that clears the selection of all candidates
	 */
	public void clearSelections()
	{
		choice = null;
	}
	
	/*
	 * Method for the voter to submit the votes for the VoteForm
	 */
	public void submitVotes()
	{
		
	}
	
	/*
	 * Method for election officer that calculates the results of the 
	 * elections and formats it into a readable string
	 */
	public void calcResults()
	{
		
	}
	
	/*
	 * Method for election officer that gets the results from the database
	 * and formats it for recounting purposes
	 */
	public void formatRecount()
	{
		
	}
	
	/*
	 * Logs the user out and ends the system.
	 */
	public void logout()
	{
		
	}

}
