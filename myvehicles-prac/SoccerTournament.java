
/**
 * Write a description of class SoccerTournament here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoccerTournament
{
    public static int randInt( int max )   // Returns an int between 0 and max
    {
        return (int)( Math.random() * max + 1 );
    }
    
    public static void randomPlay( int numGames, SoccerTeam a, SoccerTeam b, SoccerTeam c, SoccerTeam d )
    {
        int maxScore = 7;
        // Will play 21 games
        for( int i = 0; i < numGames; i++ )
        {
            int teamPair = randInt( 5 );
            switch( teamPair )
            {
                case 0:
                    a.played( b, randInt( maxScore ), randInt( maxScore ) );
                    break;
                case 1:
                    a.played( c, randInt( maxScore ), randInt( maxScore ) );
                    break;
                case 2:
                    a.played( d, randInt( maxScore ), randInt( maxScore ) );
                    break;
                case 3:
                    b.played( c, randInt( maxScore ), randInt( maxScore ) );
                    break;
                case 4:
                    b.played( d, randInt( maxScore ), randInt( maxScore ) );
                    break;
                case 5:
                    c.played( d, randInt( maxScore ), randInt( maxScore ) );
                    break;
            }
        }
    }
    
    public static void main()
    {
        // Setup Teams & Tournament
        SoccerTeam teamUSA = new SoccerTeam();
        SoccerTeam teamBlah = new SoccerTeam();
        SoccerTeam teamClaw = new SoccerTeam();
        SoccerTeam teamIDontKnowWhatToCallThis = new SoccerTeam();
        teamUSA.startTournament();
        
        // play 21 games
        randomPlay( 21, teamUSA, teamBlah, teamClaw, teamIDontKnowWhatToCallThis );
        
        // print team records
        System.out.printf( "\n\n\nFirst Tournament\n" );
        System.out.printf( "Team\t\t\t\tWins\tTies\tLosses\n" );
        System.out.printf( "teamUSA\t\t\t\t%d\t%d\t%d\n", teamUSA.wins, teamUSA.ties, teamUSA.losses );
        System.out.printf( "teamBlah\t\t\t%d\t%d\t%d\n", teamBlah.wins, teamBlah.ties, teamBlah.losses );
        System.out.printf( "teamClaw\t\t\t%d\t%d\t%d\n", teamClaw.wins, teamClaw.ties, teamClaw.losses );
        System.out.printf( "teamIDontKnowWhatToCallThis\t%d\t%d\t%d\n", teamIDontKnowWhatToCallThis.wins, teamIDontKnowWhatToCallThis.ties, teamIDontKnowWhatToCallThis.losses );
        System.out.printf( "Total Games:\t%d\n", teamUSA.totalGames );
        System.out.printf( "Total Goals:\t%d\n", teamUSA.totalGoals );
        
        // Reset Scores & Tournament
        teamUSA.reset();
        teamBlah.reset();
        teamClaw.reset();
        teamIDontKnowWhatToCallThis.reset();
        teamUSA.startTournament();
        
        // play 33 games
        randomPlay( 33, teamUSA, teamBlah, teamClaw, teamIDontKnowWhatToCallThis );
        
        // Print team records
        System.out.printf( "\nSecond Tournament\n" );
        System.out.printf( "Team\t\t\t\tWins\tTies\tLosses\n" );
        System.out.printf( "teamUSA\t\t\t\t%d\t%d\t%d\n", teamUSA.wins, teamUSA.ties, teamUSA.losses );
        System.out.printf( "teamBlah\t\t\t%d\t%d\t%d\n", teamBlah.wins, teamBlah.ties, teamBlah.losses );
        System.out.printf( "teamClaw\t\t\t%d\t%d\t%d\n", teamClaw.wins, teamClaw.ties, teamClaw.losses );
        System.out.printf( "teamIDontKnowWhatToCallThis\t%d\t%d\t%d\n", teamIDontKnowWhatToCallThis.wins, teamIDontKnowWhatToCallThis.ties, teamIDontKnowWhatToCallThis.losses );
        System.out.printf( "Total Games:\t%d\n", teamUSA.totalGames );
        System.out.printf( "Total Goals:\t%d\n", teamUSA.totalGoals );
    }
}
