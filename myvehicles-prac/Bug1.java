public class Bug1 { 
    public static void main( String[] args )
    {
        int[] blah = { 1, 2, 4 };
        int blahSum = 0;
        for( int i = 0; i < blah.length; i++ )
        {
            blahSum += blah[ i ];
        }
        System.out.println( blahSum );
    }
}