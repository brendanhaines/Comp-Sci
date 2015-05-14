public class PlayCube
{
    public PlayCube()
    {
    }
    
    public static int[] getCubeTosses( NumberCube cube, int rolls )
    {
        int[] output = new int[ rolls ];
        for( int roll = 0; roll < rolls; roll++ )
        {
            output[ roll ] = cube.toss();
        }

        return output;
    }

    public static int getLongestRun( int[] values)
    {
        int longest = 1; // length of longest run
        int longestIndex = -1; // starting index of longest run
        int currentLength = 1;
        
        for( int i = 0; i < values.length - 1; i++ )
        {
            if( i == values.length )
            {
            }
            else if( values[ i ] == values[ i + 1 ] )
            {
                currentLength += 1;
            }
            else
            {
                currentLength = 1;
            }
            
            if( currentLength > longest )
            {
                longest = currentLength;
                longestIndex = i - ( currentLength - 2 );
            }
            
        }
        
        if( longest > 1 )
        {
            return longestIndex;
        }
        return -1;
    }
}
