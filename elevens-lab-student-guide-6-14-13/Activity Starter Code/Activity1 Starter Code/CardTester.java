/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * The main method in this class checks the Card operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println( "Creating cards A, B, and C:" );
        System.out.println( "CARD  SUIT     RANK  POINTVALUE" );
        System.out.println( "a     diamond  10    10" );
        System.out.println( "b     heart    jack  8" );
        System.out.println( "c     diamond  10    10" );

        Card a = new Card( "10", "diamond", 10 );
        Card b = new Card( "jack", "heart", 8 );
        Card c = new Card( "10", "diamond", 10 );

        System.out.println();
        System.out.println( "testing card a..." );
        System.out.println( "a.rank() = " + a.rank() + " (should be \"10\" )" );
        System.out.println( "a.suit() = " + a.suit() + " (should be \"diamond\" )" );
        System.out.println( "a.pointValue() = " + a.pointValue() + " (should be 10 )" );
        System.out.println( "a.matches( b ) = " + a.matches( b ) + " (should be false )" );
        System.out.println( "a.matches( c ) = " + a.matches( c ) + " (should be true )" );

        System.out.println();
        System.out.println( "testing card b..." );
        System.out.println( "b.rank() = " + b.rank() + " (should be \"jack\" )" );
        System.out.println( "b.suit() = " + b.suit() + " (should be \"heart\" )" );
        System.out.println( "b.pointValue() = " + b.pointValue() + " (should be 8 )" );
        System.out.println( "b.matches( a ) = " + b.matches( a ) + " (should be false )" );
        System.out.println( "b.matches( c ) = " + b.matches( c ) + " (should be false )" );

        System.out.println();
        System.out.println( "testing card a..." );
        System.out.println( "c.rank() = " + c.rank() + " (should be \"10\" )" );
        System.out.println( "c.suit() = " + c.suit() + " (should be \"diamond\" )" );
        System.out.println( "c.pointValue() = " + c.pointValue() + " (should be 10 )" );
        System.out.println( "c.matches( a ) = " + c.matches( a ) + " (should be true )" );
        System.out.println( "c.matches( b ) = " + c.matches( b ) + " (should be false )" );

        System.out.println();
        System.out.println( a.rank().equals("10") && a.suit().equals("diamond") && a.pointValue()==10 && !a.matches(b) && a.matches(c) &&
                            b.rank().equals("jack") && b.suit().equals("heart") && b.pointValue()==8 && !b.matches(a) && !b.matches(c) &&
                            c.rank().equals("10") && c.suit().equals("diamond") && c.pointValue()==10 && c.matches(a) && !c.matches(b) ?
                            ANSI_GREEN + ANSI_BOLD + "** PASS **" + ANSI_RESET : ANSI_RED + ANSI_BOLD + "** FAIL **" + ANSI_RESET );
        System.out.println();
    }
}
