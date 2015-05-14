
/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line
{
    // Fields
    private double slope;
    private double yInt;
    
    // constructors
    public Line()
    {
        this.slope = 0;
        this.yInt = 0;
    }
    
    public Line( double _slope, double _yInt )
    {
        this.slope = _slope;
        this.yInt = _yInt;
    }
    
    // Methods
    public double getSlope()
    {
        return this.slope;
    }
    
    public double getYInt()
    {
        return this.yInt;
    }
    
    public void printLine()
    {
        System.out.printf( "y = %fx + %f\n", this.slope, this.yInt );
    }
    
    public void setSlope( double _slope )
    {
        this.slope = _slope;
    }
    
    public void setYInt( double _yInt )
    {
        this.yInt = _yInt;
    }
    
    public Line shift( double _shift )
    {
        return new Line( this.slope, this.yInt + _shift );
    }
    
    // main()
    public static void main()
    {
        System.out.printf( "test line is: y = 4x + 13\n" );
        Line line1 = new Line( 4, 13 );
        line1.printLine();
        System.out.printf( "changeing slope to \"2.134\"\n" );
        line1.setSlope( 2.134 );
        System.out.printf( "slope is now: %f\n", line1.getSlope() );
        System.out.printf( "changing yInt to \"-1.000001\"\n" );
        line1.setYInt( -1.000001 );
        System.out.printf( "yInt is now: %f\n", line1.getYInt() );
        line1.printLine();
        Line line2 = line1.shift( 1.000001 );
        line2.printLine();
    }
}
