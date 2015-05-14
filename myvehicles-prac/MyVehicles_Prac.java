
/**
 * Write a description of class MyVehicles_Prac here.
 * Add code to get information about the 3 vehicles and print it out, then change the price and color
 * of vehicle 3 and print out the new values.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyVehicles_Prac
{
  public static void main() {
    // Create some vehicles
    Vehicle_Prac v1 = new Vehicle_Prac("Robert","SUV","Jeep","Liberty","Red");
    Vehicle_Prac v2 = new Vehicle_Prac("Katie","Truck","Ford","F350","Blue");
    Vehicle_Prac v3 = new Vehicle_Prac("Sara","Motorcycle","Silver and Black", 4020.00);
    Vehicle_Prac v4 = new Vehicle_Prac();

    // Get the vehicle specs and print them

    String tmp;

    // Vehicle #1
    System.out.println("\n\n\nVEHICLE 1");
    tmp = v1.getVOwner();
    System.out.println(tmp);


    // Vehicle #2
    System.out.println();
    System.out.println("VEHICLE 2");
    tmp = v2.getVOwner();
    System.out.println(tmp);



    // Vehicle #3
    System.out.println();
    System.out.println("VEHICLE 3");
    System.out.println( v3.getVOwner() );
    

    // Paint vehicle #2 Green
    System.out.println();
    System.out.println("VEHICLE 3 was repainted");
    tmp = v3.setVColor("Green");
    tmp = v3.getVColor();
    System.out.println(tmp);
    
    // Revalue vehicle #3
    System.out.printf( "\nVEHICLE 3 was revalued\n" );
    System.out.printf( "old price: %f\n", v3.getVPrice() );
    v3.setVPrice( v3.getVPrice() + 14000 );
    System.out.printf( "new price: %f\n", v3.getVPrice() );
    
    // Vehicle #4
    System.out.printf( "Vehicle 4 is currently %s\n", v4.getVColor() );
    v4.setVColor( "brown" );
    System.out.printf( "Vehicle 4 has been repainted %s\n", v4.getVColor() );
    
    // set v2's color to v3's color and check
    System.out.printf( "set vehicle 2 to the color of vehicle 3\n" );
    v2.setVColor( v3.getVColor() );
    System.out.printf( "vehicle 2 is now %s\n", v2.getVColor() );
    if( v2.getVColor().equals( v3.getVColor() ) )
    {
        System.out.printf( "they are equal\n" );
    }
    else
    {
        System.out.printf( "they aren't equal\n" );
    }
  }
}
