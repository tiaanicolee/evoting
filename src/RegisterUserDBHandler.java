import java.io.*;

/**
 * A Database Handler that interfaces with the database containing
 * the Registered users that can vote.
 */
public class RegisterUserDBHandler {
	/**
	 * The method looks in the database containing the registered users, and it 
	 * returns whether the user is registered or not.
	 * @param username
	 * @param password
	 * @return true if registered, false otherwise
	 */
	public boolean findUser(String username, String password, String role)
	{
		String filename;
		if (role.equals("voter")) 
			filename = "regVoters.txt";
		else if (role.equals("eo"))
			filename = "regEO.txt";
		
		return true;
	}
}
