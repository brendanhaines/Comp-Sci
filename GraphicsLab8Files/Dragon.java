import java.awt.Graphics;
import java.awt.*;

public class Dragon
{
    public String curve;
    public int steps = 1;
    private int scale = 1;
    private int angle = 0;
    private Color color = Color.BLACK;
    
    public Dragon( int order )
    {
        this.curve = this.dragonCurves( order );
    }
    
    public Dragon( int order, int startAngle )
    {
        this.curve = this.dragonCurves( order );
        this.angle = startAngle;
    }
    
    public Dragon( int order, Color colorIn )
    {
        this.curve = this.dragonCurves( order );
        this.color = colorIn;
    }
    
    public Dragon( int order, Color colorIn, int startAngle )
    {
        this.curve = this.dragonCurves( order );
        this.color = colorIn;
        this.angle = startAngle;
    }
    
    private String dragonCurves( int order)
    {
        boolean showF = true;
        
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
        return output;
    }
    
    public void draw( Graphics g, int x, int y )
    {
        int newX = x, newY = y;
        
        //int angle = 0;  
        // 0 is up, 1 left, 2 down, 3 right
        for( int step = 0; step < steps && step < this.curve.length(); step++ )
        {
            if( this.curve.charAt( step ) == 'F' )
            {
                if( angle % 4 == 0 )    // up
                {
                    newY = y - this.scale;
                }
                else if( angle % 4 == 1 )   // left
                {
                    newX = x - this.scale;
                }
                else if( angle % 4 == 2 )   // down
                {
                    newY = y + this.scale;
                }
                else    //right
                {
                    newX = x + this.scale;
                }
                g.drawLine( x, y, newX, newY );
                x = newX;
                y = newY;
            }
            else if( this.curve.charAt( step ) == 'R' )
            {
                this.angle -= 1;
            }
            else if( this.curve.charAt( step ) == 'L' )
            {
                this.angle += 1;
            }
        }
    }
}