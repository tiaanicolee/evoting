/*
 * A Candidate describes a candidate for an election.
 */
public class Candidate {
	public String name;
	public String party;
	public boolean selected;
	
	public Candidate(String cname, String cparty)
	{
		name = cname;
		party = cparty;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getParty()
	{
		return party;
	}
}
