import java.io.*;
import java.util.Hashtable;

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
		String filename = "";
		if (role.equals("voter")) 
			filename = "regVoters.txt";
		else if (role.equals("eo"))
			filename = "regEO.txt";
		
		Hashtable<String, User> users = new Hashtable<String, User>();
		String line;
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				String lineSplit[] = line.split(", ");
				User u = new User(lineSplit[0], lineSplit[1], lineSplit[2]);
				users.put(lineSplit[0], u);
			}
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		if (users.containsKey(username) && users.get(username).getPassword().equals(password))
			return true;
		else
			return false;
	}
}
