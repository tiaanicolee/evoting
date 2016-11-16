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
	
	/*
	 * Main method to run the voting software.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Method for the voter that selects a candidate
	 */
	public void select()
	{
		String name = null;
		String party = null;
		String select;
		Candidate candA = new Candidate(name, party);
		Candidate candB = new Candidate(name, party);
		System.out.println("Which Party? A/B");
		String input = System.console().readLine();
		if( input == candA.getParty() ){
			select = candA.getName();
		}
		else {
			select = candB.getName();
		}
		
		System.out.println(select);
	}
	
	/*
	 * Method for the voter that clears the selection of all candidates
	 */
	public void clearSelections()
	{
		
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
