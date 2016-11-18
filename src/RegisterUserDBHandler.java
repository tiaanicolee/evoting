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
	public User findUser(String username, String password, String role)
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
				if (role.equals("voter"))
					u.setVoteCount(Integer.parseInt(lineSplit[3]));
			}
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		if (users.containsKey(username) && users.get(username).getPassword().equals(password))
			return users.get(username);
		else
			return null;
	}
	
	/*
	 * Method to update the vote count in the flat file.
	 */
	public void updateVoteCount(User user, int count)
	{
		String replaceWith = user.getUsername() + ", " + user.getPassword() + ", " + user.getID() + ", " + count;
		try {
	        // input the file content to the String "input"
	        BufferedReader file = new BufferedReader(new FileReader("regVoters.txt"));
	        String line;String input = "";

	        while ((line = file.readLine()) != null){ 
	        	if ((line.substring(0, line.length()-1)).equals(replaceWith.substring(0, replaceWith.length()-1)))
	        		line = replaceWith;
	        	input += line + '\n';
	        }

	        file.close();

	        FileOutputStream fileOut = new FileOutputStream("regVoters.txt");
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
		return;
	}
}
