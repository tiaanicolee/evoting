/*
 * A Candidate describes a candidate for an election.
 */
public class Candidate {
	public String name;
	public String party;
	public boolean selected;
	
	/*
	 * Constructs a Candidate with a name and a party affiliation.
	 */
	public Candidate(String cname, String cparty)
	{
		name = cname;
		party = cparty;
	}
	
	/*
	 * Returns the name of the candidate.
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Returns the name that the candidate is associated wtih
	 */
	public String getParty()
	{
		return party;
	}
}
