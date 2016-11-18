
public class Voter {
	private String username;
	private String password;
	private String id;
	
	public Voter(String vUsername, String vPassword, String vId)
	{
		username = vUsername;
		password = vPassword;
		id = vId;
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
