package Voting;
import VotingInterface.*;

import java.util.*;
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
	private String username;
	private String password;
	
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
		
		vote.handler.createTable();
		
		OpeningScreen open = new OpeningScreen();
		open.setVisible(true);
		
		in.close();
	}
	
	/*
	 * Method to login a user
	 */
	public int login(String username, String password, String role)
	{
		
		user = handler.findUser(username, password, role);
		this.username = username;
		this.password = password;
		if (user != null)
			return user.getID();
		else
			return -1;
	}
	
	
	public boolean canVote()
	{
		if (handler.getVoteCount(user) >= 1)
			return false;
		else
			return true;
	}
	
	public void updateCount(int id) 
	{
		handler.setVoteCount(id);
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
	
//	/*
//	 * Method for the voter to submit the votes for the VoteDBHandler
//	 */
//	public void submitVotes(Candidate cand)
//	{
//		VoteDBHandler sub = new VoteDBHandler();
//		sub.saveVotes(cand.getName());
//	}
	
	/*
	 * Method for election officer that calculates the results of the 
	 * elections and formats it into a readable string
	 */
	public String calcResults()
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
		
		int max = 0;
		String winner = null;
	    if (charCount > max){
	        max = charCount; 
	        winner = "Charmander";
	        }
	    if (bulbCount > max){
	        max = bulbCount;
	        winner = "Bulbasuar";
	        }
	    	
	    if (squirCount > max){
	        max = squirCount;
	        winner = "Squirtle";
	    }
	    if(pikCount > max){
	    	max=pikCount;
	    	winner = "Pikachu";
	    }
	     
		
		return winner;
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

