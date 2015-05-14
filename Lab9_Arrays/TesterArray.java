import java.util.*;

public class TesterArray
{
    public static void main( String[] args )
    {
        double[] array = new double[ 100 ];
        for( int i = 0; i < 100; i++ )
        {
            array[ i ] = ( Math.random() * 50 ) + 50;
            //System.out.printf( "%f\n", array[ i ] );
        }
        //System.out.printf( "Average: %f\n", average( array ) );
        System.out.printf( "Count over 60: %d\n", numOverSixty( array ) );
    }
    
    public static int numOverSixty( double[] input )
    {
        int count = 0;
        for( int i = 0; i < 100; i++ )
        {
            if( input[ i ] > 60 )
            {
                count++;
            }
        }
        return count;
    }
    
    public static double average( double[] input )
    {
        double sum = 0;
        for( int i = 0; i < 100; i++ )
        {
            sum += input[ i ];
        }
        return sum / 100;
    }
}
