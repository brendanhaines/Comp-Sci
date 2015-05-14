
/**
 * Write a description of class Calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator
{
    public double add( double a, double b )
    {
        return a + b;
    }
    
    public double subtract( double a, double b )
    {
        return a - b;
    }
    
    public double multiply( double a, double b )
    {
        return a * b;
    }
    
    public double divide( double a, double b )
    {
        return a / b;
    }
    
    public double absoluteValue( double a )
    {
        if( a < 0 )
        {
            a = -1*a;
        }
        return a;
        //return ( a >>> 1 );
    }
}