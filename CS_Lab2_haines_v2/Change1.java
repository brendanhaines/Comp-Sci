import java.util.*;

public class Change1
{
    public static void main( String[] args )
    {
      System.out.println( "Enter the amount of money, then press enter:" );
      
      // Retrieve data from keyboard
      Scanner kboard = new Scanner( System.in );
      double TotalMoney = kboard.nextDouble();
      System.out.println( "You entered: " + TotalMoney );
      
      // Determine whether to use integer or decimal math
      //System.out.println( "Enter \"0\" for integer math or \"1\" for decimal math:" );
      //double IntOrDecimal = kboard.nextDouble();
      double IntOrDecimal = 0;
      
      // Define integers for calculation of change
      int NumQuarters, NumDimes, NumNickels, NumPennies;
      
      if( IntOrDecimal == 0 )
      {
        // Convert to cents for calculation using integers
        NumPennies = (int)( TotalMoney*100 );
        
        NumQuarters = (int)( NumPennies / 25 );
        NumPennies -= NumQuarters * 25;
        
        NumDimes = (int)( NumPennies / 10 );
        NumPennies -= NumDimes * 10;
        
        NumNickels = (int)( NumPennies / 5 );
        NumPennies -= NumNickels * 5;
      }
      else
      {
        // Define a double to keep track of remaining change to give
        double Remainder = TotalMoney;
        
        // Calculate using doubles
        NumQuarters = (int)( TotalMoney * 4 );
        Remainder -= NumQuarters / 4;
        
        NumDimes = (int)( TotalMoney * 10 );
        Remainder -= NumDimes / 10;
        
        NumNickels = (int)( TotalMoney * 20 );
        Remainder -= NumNickels / 20;
        
        NumPennies = (int)( TotalMoney * 100 );
        Remainder -= NumPennies / 100;
        
        if( Remainder != 0 );
        {
          System.out.println( "REMAINDER DOES NOT EQUAL 0!!!!!!" );
          System.out.printf( "Remainder:\t\t%1.9f\n", Remainder );
        }
      }
      // Display output
      System.out.println( "Num of quarters:\t" + NumQuarters );
      System.out.println( "Num of dimes:\t\t" + NumDimes );
      System.out.println( "Num of Nickels\t\t" + NumNickels );
      System.out.println( "Num of Pennies\t\t" + NumPennies );
      System.out.printf( "Total Money:\t\t\t%7.2f\n", TotalMoney );
    }
}
