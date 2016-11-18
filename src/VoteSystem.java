import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
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
	public Candidate choice;
	public Hashtable <String, Candidate> cands = new Hashtable<String, Candidate>();
	
	/*
	 * Main method to run the voting software.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		
		VoteSystem vote = new VoteSystem();
		
		System.out.print("Are you a voter or an election officer? V/EO ");
		input = in.nextLine();
		if(input.equals("V")) {			//if they are a voter
			if (vote.login("voter")) {
				System.out.printf("\nCandidates:\n");
				vote.readCandidates();
				
				Set<String> keys = vote.cands.keySet();
				for(String key: keys){
					Candidate c = vote.cands.get(key);
		            System.out.println(c.getParty() + " party: " + c.getName());
		        }
				
				vote.select();
			}
			else
				System.out.println("Incorrect username/password.");
		}
		else if (input.equals("EO")) {	//if they are an election officer
			if (vote.login("eo") == true) {
				//if (input == "Res") {
					System.out.println("worked");
					vote.calcResults();
				//}
				//else {
					vote.formatRecount();
				//}
			}
			else
				System.out.println("Incorrect username/password.");
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
		String input;
		boolean confirm = false;
		boolean isValid;
		
		while (!confirm && voteCount < 1) {
			String candidate;
			do{
			System.out.printf("\nEnter the name of the candidate you are voting for: ");
			candidate  = in.nextLine();
			if (cands.containsKey(candidate)){
				System.out.println("is a valid candidate");
				isValid = true;
			}
			else{
				System.out.println("not a valid candidate");
				isValid = false;
			}
			} while (!isValid);
			System.out.println("Are you sure of your selection: " + candidate+ "? Y/N");
			input = in.nextLine();
			if (input.equals("Y")){
				choice = cands.get(candidate);
				confirm = true;
				voteCount++;
			}
		}
		return true;
	}
	
	public void readCandidates()
	{
		String fileName = "candidates.txt";
		String line;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				String lineSplit[] = line.split(", ");
				Candidate c = new Candidate(lineSplit[0], lineSplit[1]);
				cands.put(lineSplit[0], c);
			}
			br.close();
		} catch (FileNotFoundException e) {
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
	public void submitVotes(String cand)
	{
		VoteDBHandler sub = new VoteDBHandler();
		sub.saveVotes(cand);
	}
	
	/*
	 * Method for election officer that calculates the results of the 
	 * elections and formats it into a readable string
	 */
	public void calcResults()
	{
		VoteDBHandler res = new VoteDBHandler();
		String[] results = res.giveVotes();
		
		
		System.out.println("\nResults of the election:");
		int pikCount = Collections.frequency(Arrays.asList(results), "pikachu");
		System.out.println("Pikachu: " + pikCount);
		int charCount = Collections.frequency(Arrays.asList(results), "charmander");
		System.out.println("Charmander: " + charCount);
		int bulbCount = Collections.frequency(Arrays.asList(results), "bulbasaur");
		System.out.println("Bulbasaur: " + bulbCount);
		int squirCount = Collections.frequency(Arrays.asList(results), "squirtle");
		System.out.println("Squirtle: " + squirCount);		
		
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
		username = null;
		password = null;
	}

}
