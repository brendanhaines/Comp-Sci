package activity3;

/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

    public static void main(String[] args)
    {
        String sample = "The quick brown fox jumped over the lazy dog.";

        //  Demonstrate the indexOf method.
        int position = sample.indexOf("quick");
        System.out.println ("sample.indexOf(\"quick\") = " + position);

        //  Demonstrate the toLowerCase method.
        String lowerCase = sample.toLowerCase();
        System.out.println ("sample.toLowerCase() = " + lowerCase);
        System.out.println ("After toLowerCase(), sample = " + sample);

        //  Try other methods here:

        // indexOf with 2 parameters
        String text = "The quick brown fox jumped over the lazy dog";
        
        int foxIndex = text.indexOf( "fox" );
        int dogIndex = text.indexOf( "dog" );
        
        System.out.printf( "index of fox: %d\n", foxIndex );
        System.out.printf( "index of dog: %d\n", dogIndex );
        System.out.printf( "indexOf( \"dog\", foxIndex );\t%d\n", text.indexOf( "dog", foxIndex ) );
    }

}
