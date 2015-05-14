import java.util.*;
import java.io.*;

class PalindromeChecker {
    private File file;
    private Scanner scanner;
    private PrintStream out;

    public PalindromeChecker( String inputFile ) {
        try {
            file = new File( inputFile );
            scanner = new Scanner( file );
            out = new PrintStream( "namesOutput.txt" );
        }
        catch( Exception ex ) {
            return;
        }

        while( scanner.hasNext() ) {
            out.println( checkPalindrome( scanner.next() ) );
        }
    }

    public boolean checkPalindrome( String word ) {
        for( int i = 0; i < word.length()/2; i++ ) {
            if( !( word.charAt( i ) == word.charAt( word.length() -1 -i ) ) ) {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        PalindromeChecker checker = new PalindromeChecker( "./names.txt" );
    }
}