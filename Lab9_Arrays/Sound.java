public class Sound
{
    private int[] samples;
    
    public int limitAmplitude( int limit )
    {
        int count = 0; // stores the number of values changed
        for( int i = 0; i < this.samples.length; i++ )
        {
            if( this.samples[ i ] > limit )
            {
                this.samples[ i ] = limit;
                count++;
            }
            else if( this.samples[ i ] < - limit )
            {
                this.samples[ i ] = - limit;
                count++;
            }
        }
        return count;
    }
    
    // trims leading zeros off of this.samples and reduces the length as to not add trailing zeroes.
    public void trimSilenceFromBeginning()
    {
        int i = 0; // i is the index of samples[]
        while( this.samples[ i ] == 0 ) i++; // increment through leading zeroes
        
        int[] newSamples = new int[ this.samples.length - i ]; // create new array long enough for samples[] without leading zeros
        
        for( int j = 0; i < this.samples.length; i++, j++ ) // i is the index of samples[], j is the index of newSamples[]
        {
            newSamples[ j ] = this.samples[ i ];
        }
        this.samples = newSamples;
    }
}
