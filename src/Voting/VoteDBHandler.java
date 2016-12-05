package Voting;
import java.io.*;
import java.util.*;

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
	public ArrayList<String> giveVotes()
	{
		String fileName = "Votes.txt";
		String line;
		ArrayList<String> list = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) !=null){
				list.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * save the voter's votes in the database
	 */
	public void saveVotes(String cand, int id)
	{
		VoteSystem vs = new VoteSystem();
		vs.updateCount(id);
		String fileName = "Votes.txt";
		
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cand);
			bw.newLine();
			bw.close();
			fw.close();
			
			System.out.println("\nVote has been submitted");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}