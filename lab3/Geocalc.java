
/**
 * Write a description of class Geocalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Geocalc
{
    // calcVolume returns the volume of a rectangular prism in cubic cm. inputs are the dimensions in cm
    double calcVolume( double x, double y, double z )
    {
        return ( x * y * z );
    }
    
    // calcSurfaceArea returns the surface area of a rectangular prism
    double calcSurfaceArea( double x, double y, double z )
    {
        return 2 * ( ( x * y ) + ( y * z ) + ( z * x ) ); // calculate the total surface area 
    }
    
    // getGeoSize returns the percieved size of a rectangular prism.
    // 0 is tiny
    // 1 is small
    // 2 is medium
    // 3 is large
    // 4 is huge
    int getGeoSize( double volume)
    {
        int out; // initialize variable to hold output
        
        if( volume < 10 )
        {
            out = 0;    // tiny
        }
        else if( volume < 100 )
        {
            out = 1;    // small
        }
        else if( volume < 1000 )
        {
            out = 2;    // medium
        }
        else if( volume < 10000 )
        {
            out = 3;    // large
        }
        else
        {
            out = 4;    // huge
        }
        
        return out;
    }
    
    // convertInTo
    double convertInToCm( double in )
    {
        return in * 2.54;
    }
    
    double convertCmtoM( double cm )
    {
        double out;
        if( cm > 100 )
        {
            out = cm/1000;
        }
        else
        {
            out = cm;
        }
        return out;
    }
}
