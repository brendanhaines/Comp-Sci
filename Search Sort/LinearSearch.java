import java.io.*;
import java.util.*;

class LinearSearch {
    /**
     * @param args[0] is the search parameter
     */
    public static int search( String arg ) {
        try {
            File file = new File( "./lastnames-sorted.txt" );
            Scanner scanner = new Scanner( file );

            int count = 0;
            while( scanner.hasNext() ) {
                count++;
                if( scanner.nextLine().equals( arg.toUpperCase() ) ) {
                    System.out.println( arg + " found after " + count + " iterations" );
                    return count;
                }
            }
        }
        catch( Exception ex ) {
            System.out.println( ex );
        }

        System.out.println( arg + " not found" );
        return -1;
    }

    /**
     * @param args[0] is the search parameter
     */
    public static void main( String[] args ) {
        System.out.println( "found at: " + search( args[0].toUpperCase() ) );
    }
}
