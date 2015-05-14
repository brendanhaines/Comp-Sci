
/**
 * Write a description of class Vehicle_Prac here.
 * TASK: Write get and set methods for color, owner, price of vehicles; write get methods for type
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehicle_Prac
{
  // VOwner is vehicle owner name
  private String VOwner;
  
  //price
  private double VPrice;

  // VType is vehicle type: Truck, Compact, SUV, etc
  private String VType;

  // VMake is Maker/Manufacturer of vehicle: Toyota, Ford, Jeep, etc
  private String VMake;

  // VModel is Model: Prius, Insight, Liberty, Focus, Navigator, etc.
  private String VModel;

  // VColor is vehicle color: Green, Red, Light Blue.
  // Can be changed by method v.setColor("New Color") to handle vehicle painting
  private String VColor;

  /**
  * Constructor
  **/
  public Vehicle_Prac(String vown, String vtyp, String vmak, String vmod, String vcol) {
    VOwner = vown;
    VType = vtyp;
    VMake = vmak;
    VModel = vmod;
    VColor = vcol;
  }
  
  /**
  * Second Constructor
  **/
  public Vehicle_Prac(String vown, String vtyp, String vcol, double vprice) {
    VOwner = vown;
    VType = vtyp;
    VColor = vcol;
    VPrice = vprice;
  }
  
  /**
   * Third Constructor
  **/
  public Vehicle_Prac()
  {
  }

  /**
  * This method returns the vehicle owner
  **/
  public String getVOwner() {
    return VOwner;
  }
  
  /**
  * This method changes the vehicle owner
  **/
  public String setVOwner( String vown ) {
    VOwner = vown;
    return VOwner;
  }

  /**
  * This method returns the vehicle make
  **/
  public String getVMake() {
    return VMake;
  }

  /**
  * This method returns the vehicle model
  **/
  public String getVModel() {
    return VModel;
}

  /**
  * This method returns the vehicle color
  **/
  public String getVColor() {
    return VColor;
  }

  /**
  * This method sets the vehicle color
  **/
  public String setVColor(String newColor) {
    VColor = newColor;
    return VColor;
  }

   /**
  * This method returns the vehicle price
  **/
  public double getVPrice() {
    return VPrice;
  }

  /**
  * This method sets the vehicle color
  **/
  public double setVPrice(double newPrice) {
    VPrice = newPrice;
    return VPrice;
  }
  
  /**
   * This method returns VType
   */
  public String getVType()
  {
      return VType;
  }

}