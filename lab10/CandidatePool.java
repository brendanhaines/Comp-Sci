import java.util.*;

public class CandidatePool
{
    // fields
    public List<Candidate> pool;
    
    // constructor
    public CandidatePool()
    {
        pool = new ArrayList<Candidate>();
    }
    
    // methods
    public void addCandidate(Candidate candidate)
    {
        pool.add(candidate);
    }
    
    public List<Candidate> getCandidatesForPosition(String position)
    {
        List<Candidate> matches = new ArrayList<Candidate>();
        for( Candidate c : this.pool )
        {
            if( c.getPosition().equals( position ) )
            {
                matches.add( c );
            }
        }
        return matches;
    }
    
    public Candidate getBestCandidate(String position)
    {
        // get a list of candidates matching position
        List<Candidate> matches = this.getCandidatesForPosition( position );
        
        // check for no matches
        if( matches.size() == 0 ) return null;
        
        // create a variable to store the best candidate
        Candidate best = matches.get( 0 );
        
        for( Candidate c : matches )
        {
            if( c.getInterviewScore() > best.getInterviewScore() )
            {
                best = c;
            }
        }
        return best;
        // if there is a tie for the best interview score of applicable candidates, the one with a lower index in this.pool will be returned
    }
    
    public int removeCandidatesForPosition(String position)
    {
        int count = 0;
        
        for( int i = this.pool.size() - 1; i >= 0; i-- )
        {
            // if candidate at index i has position, remove candidate
            if( this.pool.get( i ).getPosition().equals( position ) )
            {
                this.pool.remove( i );
                count++;
            }
        }
        
        return count;
    }
}
