package activity3;


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public static int findString( String searchFor, int startPos )
    {
        String input = "aabaccb";
        int psn = -1;
        
        while( true )
        {
            int index = input.indexOf( searchFor, startPos );
            if( ( ( input.indexOf( searchFor, index + 1 ) != index + 1 ) || ( index == input.length() ) ) &&
                ( ( input.indexOf( searchFor, index - 1 ) != index - 1 ) || ( index == 0 ) ) )
            {
                psn = index;
                break;
            }
            startPos = index + 2;
            if( startPos >= input.length() )
            {
                break;
            }
        }
        return psn;
    }
}
