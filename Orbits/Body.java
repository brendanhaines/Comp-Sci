import java.*;

public class Body extends JPanel
    implements ActionListener
{
    // Fields
    public int x, y, xv, yv, m, r;
    
    // Constuctors
    public Body( int xPos, int yPos, int xVel, int yVel, int mass, int radius )
    {
        this.x = xPos;
        this.y = yPos;
        this.xv = xVel;
        this.yv = yVel;
        this.m = mass;
        this.r = radius;
    }
    
    public Body( int xPos, int yPos, int xVel, int yVel, int mass )
    {
        this( xPos, yPos, xVel, yVel, mass, 0 );
    }
    
    // Methods
    public int getAttractionTo( Body otherBody )
    {
        int distance = Math.sqrt( (otherBody.x - this.x)*(otherBody.x - this.x) + (otherBody.y - this.y)*(otherBody.y - this.y) );
    }
}
