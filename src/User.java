
public class User {
	private String username;
	private String password;
	private String id;
	private int voteCount;
	
	public User(String vUsername, String vPassword, String vId)
	{
		username = vUsername;
		password = vPassword;
		id = vId;
	}
	
	public int getVoteCount()
	{
		return voteCount;
	}
	
	public void setVoteCount(int count)
	{
		voteCount = count;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
}
