import java.util.*;
import java.lang.*;

public class Lab5
{
    public static boolean zeroToOne( double a, double b )
    {
        System.out.println( a >= 0 && a < 1 && b >= 0 && b < 1 );
        return ( a >= 0 && a < 1 && b >= 0 && b < 1 );
    }
    
    public static void kTo2k()
    {
        for( int i = 1000; i < 2000; i += 5 )
        {
            System.out.printf( "%d\t%d\t%d\t%d\t%d\n", i, i+1, i+2, i+3, i+4 );
        }
        System.out.printf( "2000" );
    }
    
    public static void nRand()
    {
        Scanner kboard = new Scanner( System.in );
        System.out.printf( "Enter n:\n" );
        int n = kboard.nextInt();
        
        double cumSum = 0; // cumSum is a cumulative sum in the for loop
        for( int i = 0; i < n; i++ )
        {
            double num = Math.random();
            System.out.printf( "%d\t%f\n", i, num );
            cumSum += num;
        }
        double average = cumSum / n;
        System.out.printf( "Average:\t%f\n\n", average );
    }
    
    public static void main()
    {
        System.out.printf( "\n1000 to 2000:" );
        kTo2k();
        System.out.printf( "\nTesting between 1 and 0\nzeroToOne(.1,3):\n" );
        zeroToOne( .1, 3 );
        System.out.printf( "\nTesting random number averaging:\n");
        nRand();
    }
}
