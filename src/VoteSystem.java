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
	
	/*
	 * Main method to run the voting software.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		VoteSystem vote = new VoteSystem();
		vote.select();
		
		System.out.println("Is " + "choice" + " who you want? Y/N");
		String input = in.nextLine();
		if( input == "Y"){
			vote.submitVotes();
		}
		else{
			vote.clearSelections();
			vote.select();
		}
	}
	
	/*
	 * Method for the voter that selects a candidate
	 */
	public void select()
	{
		Scanner in = new Scanner(System.in);
		
		String name = null;
		String party = null;
		Candidate candA = new Candidate(name, "Demo");	
		Candidate candB = new Candidate(name, "Repub");	
		System.out.println("Which Party? Demo/Repub");
		String input = in.nextLine();
		if( input == "Demo" ){
			choice = candA.getName();
		}
		else {
			choice = candB.getName();
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
