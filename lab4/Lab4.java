import java.util.*;
import java.lang.*;

public class Lab4
{
    static public void mutualDivisors()
    {
        Scanner kboard = new Scanner( System.in );
        
        // Get numbers from command line
        System.out.println( "WARN: will only accept positive integers" );
        System.out.println( "enter first #:" );
        int num1 = kboard.nextInt();
        System.out.println( "enter second #:" );
        int num2 = kboard.nextInt();
        
        // Do they divide eachother?
        boolean divide = false;
        if ( num1 % num2 == 0 )
        {
            divide = true;
        }
        else if( num2 % num1  == 0 )
        {
            divide = true;
        }
        
        // Print answer
        if( divide == true )
        {
            System.out.println( "yes\n" );
        }
        else
        {
            System.out.println( "no\n" );
        }
    }
    
    static public void possibleTriangle()
    {
        Scanner kboard = new Scanner( System.in );
        
        // Get inputs
        System.out.println( "WARN: will only accept positive integers" );
        System.out.println( "enter first #:" );
        int num1 = kboard.nextInt();
        System.out.println( "enter second #:" );
        int num2 = kboard.nextInt();
        System.out.println( "enter third #:" );
        int num3 = kboard.nextInt();
        
        // check numbers
        boolean works = false;
        if( ( num1 + num2 > num3 ) && ( num2 + num3 > num1 ) && ( num3 + num1 > num2 ) )
        {
            works = true;
        }
        
        // print answer
        System.out.println( works );
        
    }
    
    static public void randAB()
    {
        Scanner kboard = new Scanner( System.in );
        
        // Get bounds
        System.out.printf( "WARN: will only accept integers\n" );
        System.out.printf( "enter left bound\n" );
        int num1 = kboard.nextInt();
        System.out.printf( "enter right bound\n" );
        int num2 = kboard.nextInt();
        
        // get random number
        int out = (int)( ( num2 - num1 ) * Math.random() + num1 );
        
        // print number
        System.out.println( out );
    }
    
    static public void dice()
    {
        System.out.println( "rolling dice..." );
        
        int num1 = (int)( Math.round( 6 * Math.random() + 1 ) );
        int num2 = (int)( Math.round( 6 * Math.random() + 1 ) );
        
        // print
        System.out.printf( "die 1: %d\n", num1 );
        System.out.printf( "die 2: %d\n", num2 );
        System.out.printf( "sum: %d\n", num2 + num1 );
    }
    
    static public void order()
    {
        Scanner kboard = new Scanner( System.in );
        
        // Get x, y, z
        System.out.printf( "enter x:\n" );
        double x = kboard.nextDouble();
        System.out.printf( "enter y:\n" );
        double y = kboard.nextDouble();
        System.out.printf( "enter z:\n" );
        double z = kboard.nextDouble();
        
        // determine if ordered
        boolean ordered = false;
        if( ( ( x < y ) && ( y < z ) ) || ( ( z < y ) && ( y < x ) ) )
        {
            ordered = true;
        }
        
        // print answer
        System.out.println( ordered );
    }
    
    static public void RGBtoCMYK()
    {
        Scanner kboard = new Scanner( System.in );
        
        // get RGB
        System.out.printf( "enter red\n" );
        double red = kboard.nextInt();
        System.out.printf( "enter green\n" );
        double green = kboard.nextInt();
        System.out.printf( "enter blue\n" );
        double blue = kboard.nextInt();
        
        // conver rgb to cmyk
        double w = Math.max( red, Math.max( green, blue ) ) / 255;
        double c = ( w - ( red / 255 ) ) / w;
        double m = ( w - ( green / 255 ) ) / w;
        double y = ( w - ( blue / 255 ) ) / w;
        double k = 1 - w;
        
        // output CMYK
        System.out.printf( "OUTPUT:\nC: %f\nM: %f\nY: %f\nK: %f\n", c, m, y, k );
    } 
    
    static public void dragonCurves()
    {
        boolean showF = false;
        
        // Get order from terminal
        Scanner kboard = new Scanner( System.in );
        System.out.println( "enter order:" );
        int order = kboard.nextInt();
        
        String output = "";
        if( showF == true ) // if showing 'F's, add leading F
        {
            output = "F";
        }
        
        for( int ord = order; ord > 0; ord--)
        {
            String previous = output;
            
            output = output + "L";
            for( int i = previous.length(); i > 0; i-- )
            {
                char digit = previous.charAt( i - 1 );
                if( digit == 'L' )
                {
                    output += "R";
                }
                else if( digit == 'R' )
                {
                    output += "L";
                }
                else if( showF )
                {
                    output += "F";
                }
            }
        }
        
        System.out.println( output );   // print string of turns
    }
}
