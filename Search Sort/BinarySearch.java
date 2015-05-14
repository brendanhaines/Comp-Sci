import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

class BinarySearch {
    public static File file;
    public static Scanner scanner;
    public static String[] string;
    public static int count;    // stores the number of recursions of search

    /**
     * @param args[0] is the search parameter
     */
    public static int search( String target,  int lowEnd, int highEnd ) {
        if( highEnd - lowEnd <= 1 ) return -1;

        count++;
        int pivot = ( highEnd + lowEnd )/2;
        int c = target.compareTo( string[pivot] );

        if( c == 0 ) {
            return pivot+1;
        }
        else if( c < 0 ) {  // search the lower half
            return search( target, lowEnd, pivot );
        }
        else {  // c > 0: search the upper half
            return search( target, pivot, highEnd );
        }
    }

    /**
     * @param args[0] is the search parameter
     */
    public static void main( String[] args ) {
        if( args.length < 1 ) {
            System.out.println( "must provide parameter" );
            return;
        }

        try {
            file = new File( "./lastnames-sorted.txt" );
            scanner = new Scanner( file );
            List<String> lines = Files.readAllLines( file.toPath(), StandardCharsets.US_ASCII);
            string = lines.toArray(new String[lines.size()]);

            System.out.println( "found at: " + search( args[0].toUpperCase(), 0, lines.size() -1 ) );
            System.out.println( "recursions: " + count );
        }
        catch( Exception ex ) {
            System.out.println( ex );
        }
    }
};