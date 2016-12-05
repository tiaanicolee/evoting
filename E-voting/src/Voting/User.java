package Voting;

public class User {
	private String username;
	private String password;
	private String id;
	private int voteCount;
	
	/*
	 * Constructs a User that represents either an election officer or voter.
	 */
	public User(String vUsername, String vPassword, String vId)
	{
		username = vUsername;
		password = vPassword;
		id = vId;
	}
	
	/*
	 * returns the number of votes that the voter has submitted.
	 */
	public int getVoteCount()
	{
		return voteCount;
	}
	
	/*
	 * sets the number of votes that the voter has submitted.
	 */
	public void setVoteCount(int count)
	{
		voteCount = count;
	}
	
	/*
	 * returns the id of the user
	 */
	public String getID()
	{
		return id;
	}
	
	/*
	 * returns the username of the associated person
	 */
	public String getUsername()
	{
		return username;
	}
	
	/*
	 * returns the password of the associated person
	 */
	public String getPassword()
	{
		return password;
	}
}
