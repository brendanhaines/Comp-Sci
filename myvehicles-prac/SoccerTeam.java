
/**
 * Write a description of class SoccerTeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoccerTeam
{
    // Fields
    public static int totalGames = 0;
    public static int totalGoals = 0;
    
    public int wins;
    public int ties;
    public int losses;
    
    // Constructors
    public SoccerTeam()
    {
        this.reset();
    }
    
    // Methods
    public void startTournament( )
    {
        totalGames = 0;
        totalGoals = 0;
    }
    
    public void played( SoccerTeam other, int myScore, int otherScore )
    {
        this.totalGames++;
        this.totalGoals += myScore + otherScore;
        
        if( myScore > otherScore )  // win
        {
            this.wins++;
            other.losses++;
        }
        else if( myScore < otherScore ) // loss
        {
            this.losses++;
            other.wins++;
        }
        else    // scores equal --> tie
        {
            this.ties++;
            other.ties++;
        }
    }
    
    public int getPoints()
    {
        return ( 3 * wins + ties );
    }
    
    public void reset()
    {
        this.wins = 0;
        this.ties = 0;
        this.losses = 0;
    }
}
