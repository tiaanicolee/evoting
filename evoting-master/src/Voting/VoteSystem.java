package Voting;
import java.util.*;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

/**
 * The VoteSystem class controls how the voting software runs, and it controls the 
 * interaction between the data and UI.
 */
public class VoteSystem {
	public Candidate choice;
	public Hashtable <String, Candidate> cands = new Hashtable<String, Candidate>();
	public User user;
	public RegisterUserDBHandler handler;
	public VoteDBHandler res;
	public ArrayList<String> results;
	
	/*
	 * Constructor for VoteSystem(). Initializes the handlers.
	 */
	public VoteSystem()
	{
		handler = new RegisterUserDBHandler();
		res = new VoteDBHandler();
		results = res.giveVotes();
	}
	
	/*
	 * Main method to run the voting software.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input;
		boolean cont = true;
		
		VoteSystem vote = new VoteSystem();
		
		
		System.out.println("Welcome to the E-Voting Software.");
		
		while (cont){
			System.out.print("Are you a voter or an election officer? V/EO/exit ");
			input = in.nextLine();
			if(input.equals("V")) {			//if they are a voter
				if (vote.login("voter")) {
					
					vote.select();
				}
				else
					System.out.println("Incorrect username/password.");
			}
			else if (input.equals("EO")) {	//if they are an election officer
				if (vote.login("eo") == true) {
					System.out.println("Do you want the results or a recount? Res/Rec");
					input = in.nextLine();
					if (input.equals("Res")) {
						vote.calcResults();
					}
					else {
						System.out.println("recount");
						vote.formatRecount();
					}
				}
				else
					System.out.println("Incorrect username/password.");
			}
			else if (input.equals("exit")) {
				System.out.println("Thank you for using the E-voting Software.");
				cont = false;
				System.exit(0);
			}
		}
		in.close();
	}
	
	/*
	 * Method to login a user
	 */
	public boolean login(String role)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = in.nextLine();
		System.out.print("Enter password: ");
		String password = in.nextLine();
		
		user = handler.findUser(username, password, role);
		in.close();
		if (user != null)
			return true;
		else
			return false;
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
		
		if (user.getVoteCount() >= 1)
		{
			System.out.println("This user already voted once.");
			System.exit(0);
		}
		
		while (!confirm && user.getVoteCount() < 1) {
			System.out.printf("\nCandidates:\n");
			readCandidates();
			
			Set<String> keys = cands.keySet();
			for(String key: keys){
				Candidate c = cands.get(key);
	            System.out.println(c.getParty() + " party: " + c.getName());
	        }
			
			
			String candidate;
			do{
			System.out.printf("\nEnter the name of the candidate you are voting for: ");
			candidate  = in.nextLine();
			if (cands.containsKey(candidate)){
				isValid = true;
			}
			else{
				System.out.println(candidate + " is not a valid candidate.");
				isValid = false;
			}
			} while (!isValid);
			System.out.printf("Are you sure of your selection: " + candidate+ "? Y/N");
			input = in.nextLine();
			if (input.equals("Y")){
				choice = cands.get(candidate);
				confirm = true;
				user.setVoteCount(user.getVoteCount() + 1);
				handler.updateVoteCount(user, user.getVoteCount());
				submitVotes(choice);
				System.out.println("User has been logged out.");
			}
		}
		in.close();
		return true;
	}
	
	/*
	 * Method to read a file of candidates for the election.
	 */
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
	public void submitVotes(Candidate cand)
	{
		VoteDBHandler sub = new VoteDBHandler();
		sub.saveVotes(cand.getName());
	}
	
	/*
	 * Method for election officer that calculates the results of the 
	 * elections and formats it into a readable string
	 */
	public void calcResults()
	{

		System.out.println("\nResults of the election:");
		int pikCount = Collections.frequency((results), "pikachu");
		System.out.println("Pikachu: " + pikCount);
		int charCount = Collections.frequency((results), "charmander");
		System.out.println("Charmander: " + charCount);
		int bulbCount = Collections.frequency((results), "bulbasaur");
		System.out.println("Bulbasaur: " + bulbCount);
		int squirCount = Collections.frequency((results), "squirtle");
		System.out.println("Squirtle: " + squirCount);			
		
	}
	
	/*
	 * Method for election officer that gets the results from the database
	 * and formats it for recounting purposes
	 */
	public void formatRecount()
	{		
		System.out.println("\nResults of the election:");
		int pikCount = Collections.frequency((results), "pikachu");
		System.out.println("Pikachu: " + pikCount);
		int charCount = Collections.frequency((results), "charmander");
		System.out.println("Charmander: " + charCount);
		int bulbCount = Collections.frequency((results), "bulbasaur");
		System.out.println("Bulbasaur: " + bulbCount);
		int squirCount = Collections.frequency((results), "squirtle");
		System.out.println("Squirtle: " + squirCount);	
	}
	
	/*
	 * Logs the user out and ends the system.
	 */
	public void logout()
	{
		System.exit(0);
	}
}

