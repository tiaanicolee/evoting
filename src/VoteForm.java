import java.sql.Timestamp;
import java.util.Date;

/**
 * The VoteForm class contains all the information that needs to be saved
 * in the voter database.
 */
public class VoteForm {
	public Candidate candidate;
	public Timestamp timeStamp;
	public int voterID;
	
	public VoteForm(Candidate cand, int id)
	{
		candidate = cand;
		voterID = id;
		
		Date date = new Date();
		timeStamp = new Timestamp(date.getTime());
	}
}
