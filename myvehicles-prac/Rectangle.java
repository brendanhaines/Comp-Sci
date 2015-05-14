import java.lang.*;

/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle
{
    // Fields
    private int length;
    private int width;
    
    // Constructors
    public Rectangle( int len, int wid )
    {
        this.length = Math.abs( len );
        this.width = Math.abs( wid );
    }
    
    public Rectangle( int dim )
    {
        this.length = Math.abs( dim );
        this.width = Math.abs( dim );
    }
    
    public Rectangle( )
    {
        this.length = 1;
        this.width = 1;
    }
    
    // Methods
    public boolean isSquare( )
    {
        return ( this.length == this.width );
    }
}
