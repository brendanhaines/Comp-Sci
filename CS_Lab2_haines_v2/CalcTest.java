
/**
 * Write a description of class CalcTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class CalcTest
{
    /*
     * This was an abandoned attempt at string parsing
     * 
    public static void complex()
    {
        
        
        // Prompt user for expression
        System.out.printf( "\nEnter an expression to evaluate: (or enter \"HELP\" for a list of commands)\n" );
        Scanner kboard = new Scanner( System.in );
        String input = kboard.next();
        
        if( input == "HELP" )
        {
            System.out.printf( "\n##### HELP #####\n -Addition: \"+\"\n -Subtraction: \"-\"\n -Multiplication: \"x\"\t\"X\"\t\"*\"\n -Division: \"/\"\nORDER OF OPERATIONS WILL NOT BE FOLLOWED\nOPERATIONS WILL BE PERFORMED FROM LEFT TO RIGHT\n################\n\nEnter an expression to evaluate:\n" );
            input = kboard.next();
        }
        
        input.toUpperCase();    // change characters to uppercase
        input.trim();           // trim any whitespace from ends of string
        int length = input.length();    // find the length of the input
        
        ///////////////////////////////////////
        /////  BEGIN STRING PARSING CODE  /////
        ///////////////////////////////////////
        
        int charType[ length ] = { 0 }; // keeps track of numbers (0), continued numbers (1), operators (2), decimal points (3), and invalid characters (4)
        for( int character = 0, character < length, character++ )
        {
            switch( input[ character ] )
            {
                case "+" || "-" || "x" || "X" || "*" || "/" :   //opperators
                    if( character == 0 )
                    {
                        // there's a problem, the first character is an opperator
                        charType[ character ] = 4;  // invalid character
                    }
                    else
                    {
                        charType[ character ] = 1;
                    }
                    break;
                case "." :
                    charType[ character ] = 3;
                    break;
                default :
                    if (character == 0)
                    {
                        charType[ character ] = 0;
                    }
                    else if( charType[ character - 1 ] == 0 || 1 || 3 ) // if preceded by number or decimal
                    {
                        charType[ character ] = 1;
                    }
                    else
                    {
                        charType[ character ] = 0;
                    }
            }
            if( charType[ character ] == 4 )    //invalid character
            {
                //Theres a problem, I need to do something here but i have higher priorities
            }
        }
        
        ///////////////////////////////
        /////  END STRING PARSING /////
        ///////////////////////////////
    }
    */
    public static void printIt( String input )
    {
        if( input == "error" )
        {
            System.out.println( "There was an error." );
        }
        else
        {
            System.out.println( input );
        }
    }
   
    public static void simple()
    {
        // Create instance of calculator class
        Calculator c = new Calculator();
        
        // Get input from user
        System.out.println( "Enter number 1" );
        Scanner kboard = new Scanner( System.in );  // Get first number
        double num1 = kboard.nextDouble();
        System.out.println( "Enter operator\n-Plus: +\n-Minus: -\nMultiply: *\n-Divide: /\n-Absolute Value: abs" );
        String operator = kboard.next();            // Get operator
        double num2 = 0;        // Initialize num2
        if ( operator.equals( "abs" ) )
        {
        }
        else
        {
            System.out.println( "Enter number 2" );
            num2 = kboard.nextDouble();      // If not absolute value, get 2nd number
        }
        
        // Create an output variable
        double out = 0;
        
        // Determine and use designated operator
        if( operator.equals( "+" ) )
        {
            out = c.add( num1, num2 );
            printIt( Double.toString( out ) );
        }
        else if( operator.equals( "-" ) )
        {
            out = c.subtract( num1, num2 );
            printIt( Double.toString( out ) );
        }
        else if( operator.equals( "*" ) )
        {
            out = c.multiply( num1, num2 );
            printIt( Double.toString( out ) );
        }
        else if( operator.equals( "/" ) )
        {
            out = c.divide( num1, num2 );
            printIt( Double.toString( out ) );
        }
        else if( operator.equals( "abs" ) )
        {
            out = c.absoluteValue( num1 );
            printIt( Double.toString( out ) );
        }
        else
        {
            printIt( "error" );
        }
    }
    
    public static void main( String args[] )
    {
        simple();
        //complex();
    }
}
