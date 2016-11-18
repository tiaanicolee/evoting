
public class User {
	private String username;
	private String password;
	private String id;
	
	public User(String vUsername, String vPassword, String vId)
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
