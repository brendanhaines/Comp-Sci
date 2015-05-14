import java.util.*;

public class GeoTester
{
    public static void main( String[] args )
    {
        Geocalc calc = new Geocalc();
        
        // Get initial data from user
        Scanner kboard = new Scanner( System.in );
        System.out.println( "Please enter all lengths in INCHES\n" );
        System.out.println( "Enter width:" );
        double width = kboard.nextDouble();
        System.out.println( "Enter height:" );
        double height = kboard.nextDouble();
        System.out.println( "Enter depth:" );
        double depth = kboard.nextDouble();
        
        // convert inches to cm
        width = calc.convertInToCm( width );
        height = calc.convertInToCm( height );
        depth = calc.convertInToCm( depth );
        
        // calculate and print volume
        double volume = calc.calcVolume( width, height, depth );
        System.out.println( "\nVolume: " + volume + "ml" );
        
        // calculate and print surface area
        double surface = calc.calcSurfaceArea( width, height, depth );
        System.out.println( "Surface Area: " + surface + "cm" );
        
        // get "size" of box
        double size = calc.getGeoSize( volume );
        
        // convert "size" to plain text and print
        if( size == 0 )
        {
            System.out.println( "It's tiny." );
        }
        else if( size == 1 )
        {
            System.out.println( "It's pretty small." );
        }
        else if( size == 2 )
        {
            System.out.println( "It's moderately sized." );
        }
        else if( size == 3 )
        {
            System.out.println( "It's pretty large." );
        }
        else if( size == 4 )
        {
            System.out.println( "It's huge." );
        }
        else
        {
            System.out.println( "THERE'S A PROBLEM!!!!!" );
        }
        
        // add whitespace
        System.out.print( "\n\n\n\n" );
    }
}
