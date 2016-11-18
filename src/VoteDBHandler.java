import java.io.*;

/**
 * A Database Handler that interfaces with the database containing
 * the voter's votes.
 */
public class VoteDBHandler {
	String cand;
	/**
	 * Accesses the database to get an array of all of the vote forms.
	 * @return array of votes
	 */
	public VoteForm[] giveVotes()
	{
		String fileName = "Votes.txt";
		String line;
		String[] array;
		array = new String[5];
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) !=null) {
				for (int i = 0; i < array.length; i++){
					array[i] = br.readLine();
				}
			}
			System.out.println(array);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] a = array;
		a = returnArray();
		//System.out.println(array);
		return null;
	}
	
	/**
	 * save the voter's votes in the database
	 */
	public void saveVotes(String cand)
	{
		String fileName = "Votes.txt";
		
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cand);
			bw.newLine();
			bw.close();
			fw.close();
			
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
