import java.util.*;
import java.io.*;


class WordCount {
    
    public static Scanner scan0, scan1, scan2;
    public static File file;

    public static int getWords() {
        int count = 0;

        try {
            while( true ) {
                scan0.next();
                count++;
            }
        }
        catch( NoSuchElementException ex ) {
            return count;
        }
    }

    public static int getLines() {
        int count = 0;

        try {
            while( true ) {
                scan1.nextLine();
                count++;
            }
        }
        catch( NoSuchElementException ex ) {
            return count;
        }
    }

    public static int getChars() {
        int count = 0;

        try {
            while( true ) {
                count += scan2.next().length();
            }
        }
        catch( NoSuchElementException ex ) {
            return count;
        }
    }

    public static void main( String[] args ) {
        try {
            file = new File( "./lear.txt" );
            scan0 = new Scanner( file );
            scan1 = new Scanner( file );
            scan2 = new Scanner( file );
        }
        catch( FileNotFoundException ex ) {
            System.out.println( "FileNotFoundException" );
        }
        catch( NullPointerException ex ) {
            System.out.println( "NullPointerException" );
        }

        System.out.println( getWords() );
        System.out.println( getLines() );
        System.out.println( getChars() );
    }
}