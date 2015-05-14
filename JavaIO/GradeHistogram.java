import java.util.*;
import java.io.*;

class GradeHistogram {
    public static File input, output;
    public static Scanner scan0;
    public static PrintStream out;
    public static List<Integer> scores;

    public static String makeStars( int numStars ) {
        String stars = "";
        for( int i = 0; i < numStars; i++ ) {
            stars += "*";
        }
        return stars;
    }

    public static void main( String[] args ) {
        try {
            input = new File( "./midtermScores.txt" );
            scan0 = new Scanner( input );
            out = new PrintStream( "output.txt" );
            scores = new ArrayList<Integer>();
            for( int i = 0; i < 51; i++ ) {  // there are 51 lines/scores
                scores.add( scan0.nextInt() / 10 ); // scores now from 0-10, throw away last digit
            }
        }
        catch( Exception ex ) {}

        Collections.sort( scores );

        // NOTE: only works if there is at least 1 score in each category
        out.println( "00-09: " + makeStars( ( scores.contains( 0 ) ?1:0 ) * ( scores.lastIndexOf( 0 ) - scores.indexOf( 0 ) + 1 ) ) );
        out.println( "10-19: " + makeStars( ( scores.contains( 1 ) ?1:0 ) * ( scores.lastIndexOf( 1 ) - scores.indexOf( 1 ) + 1 ) ) );
        out.println( "20-29: " + makeStars( ( scores.contains( 2 ) ?1:0 ) * ( scores.lastIndexOf( 2 ) - scores.indexOf( 2 ) + 1 ) ) );
        out.println( "30-39: " + makeStars( ( scores.contains( 3 ) ?1:0 ) * ( scores.lastIndexOf( 3 ) - scores.indexOf( 3 ) + 1 ) ) );
        out.println( "40-49: " + makeStars( ( scores.contains( 4 ) ?1:0 ) * ( scores.lastIndexOf( 4 ) - scores.indexOf( 4 ) + 1 ) ) );
        out.println( "50-59: " + makeStars( ( scores.contains( 5 ) ?1:0 ) * ( scores.lastIndexOf( 5 ) - scores.indexOf( 5 ) + 1 ) ) );
        out.println( "60-69: " + makeStars( ( scores.contains( 6 ) ?1:0 ) * ( scores.lastIndexOf( 6 ) - scores.indexOf( 6 ) + 1 ) ) );
        out.println( "70-79: " + makeStars( ( scores.contains( 7 ) ?1:0 ) * ( scores.lastIndexOf( 7 ) - scores.indexOf( 7 ) + 1 ) ) );
        out.println( "80-89: " + makeStars( ( scores.contains( 8 ) ?1:0 ) * ( scores.lastIndexOf( 8 ) - scores.indexOf( 8 ) + 1 ) ) );
        out.println( "90-99: " + makeStars( ( scores.contains( 9 ) ?1:0 ) * ( scores.lastIndexOf( 9 ) - scores.indexOf( 9 ) + 1 ) ) );
        out.println( "  100: " + makeStars( ( scores.contains( 10 ) ?1:0 ) * ( scores.lastIndexOf( 10 ) - scores.indexOf( 10 ) + 1 ) ) );

        int[] numPerDivision;
    }
}