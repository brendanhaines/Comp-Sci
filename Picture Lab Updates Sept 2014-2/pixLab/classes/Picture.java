import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set red and green to 0 */
  public void keepOnlyBlue()
  {
      Pixel[][] pixels = this.getPixels2D();
      for( Pixel[] row : pixels )
      {
          for( Pixel pixelObj : row )
          {
              pixelObj.setRed(0);
              pixelObj.setGreen(0);
          }
      }
  }
  
  /** Method to set pixels to 255 - original value */
  public void negate()
  {
      Pixel[][] pixels = this.getPixels2D();
      for( Pixel[] row : pixels )
      {
          for( Pixel pixelObj : row )
          {
              pixelObj.setBlue( 255 - pixelObj.getBlue() );
              pixelObj.setGreen( 255 - pixelObj.getGreen() );
              pixelObj.setRed( 255 - pixelObj.getRed() );
          }
      }
  }
  
  /** Method that sets red, green, and blue equal to eachother and the average original value of that pixel */
  public void grayscale()
  {
      Pixel[][] pixels = this.getPixels2D();
      for( Pixel[] row : pixels )
      {
          for( Pixel pixelObj : row )
          {
              int ave = (int) pixelObj.getAverage();
              pixelObj.setBlue( ave );
              pixelObj.setGreen( ave );
              pixelObj.setRed( ave );
          }
      }
  }
  
  /**
   * Method takes the average r, g, and b values in a sample and, for any pixel with a color within distance, increases blue by 50
   * @param rLow upper edge (physical top, low index) bound of averaging sample
   * @param cLow left edge bound
   * @param rHigh bottom edge bound
   * @param cHigh right edge bound
   * @param maxDistance greatest colordistance acceptable for a pixel to be considered part of a fish
   * @param deltaR red scalar (all pixels considered fish color are R,G,B scaled by deltaR, deltaG, deltaB)
   * @param deltaG green scalar
   * @param deltaB blue scalar
   */
  public void fixUnderwater( int rLow, int cLow, int rHigh, int cHigh, int maxDistance, double deltaR, double deltaG, double deltaB )
  {
      int rSum = 0;
      int gSum = 0;
      int bSum = 0;
      int numPixels = 0;
      
      Pixel[][] pixels = this.getPixels2D();
      for( int row = rLow; row <= rHigh; row++ )
      {
          for( int col = cLow; col <= cHigh; col++ )
          {
              rSum += pixels[ row ][ col ].getRed();
              gSum += pixels[ row ][ col ].getGreen();
              bSum += pixels[ row ][ col ].getBlue();
              numPixels++;
          }
      }
      
      // Average R, G, B values
      int rAve = (int)( rSum / numPixels );
      int gAve = (int)( gSum / numPixels );
      int bAve = (int)( bSum / numPixels );
      Color aveColor = new Color( rAve, gAve, bAve );
      
      for( Pixel[] pixelRow : pixels )
      {
          for( Pixel pixelObj : pixelRow )
          {
              if( pixelObj.colorDistance( aveColor ) <= maxDistance )
              {
                  pixelObj.setRed( (int)( pixelObj.getRed() * deltaR ) );
                  pixelObj.setGreen( (int)( pixelObj.getGreen() * deltaG ) );
                  pixelObj.setBlue( (int)( pixelObj.getBlue() * deltaB ) );
              }
          }
      }
  }
  
  /**
   * 
   */
  public void mirrorVerticalRightToLeft()
  {
      Pixel[][] pixels = this.getPixels2D();
      
      Pixel rightPixel;
      Pixel leftPixel;
      
      for( int row = 0; row < pixels.length; row++ )
      {
          for( int col = pixels[0].length -1; col >= pixels[0].length / 2; col-- )
          {
              rightPixel = pixels[row][col];
              //leftPixel = pixels[row][ pixels[0].length -1 -col ];
              pixels[ row ][ pixels[ 0 ].length - 1 - col ].setColor( rightPixel.getColor() );
          }
      }
  }
  
  /**
   * 
   */
  public void mirrorHorizontal()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel;
      Pixel bottomPixel;
      for( int row = 0; row < pixels.length / 2; row++ )
      {
          for( int col = 0; col < pixels[0].length; col++ )
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[ pixels.length - 1 - row ][ col ];
              bottomPixel.setColor( topPixel.getColor() );
          }
      }
  }
  
  public void mirrorHorizontalBotToTop()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel;
      Pixel bottomPixel;
      for( int row = 0; row < pixels.length / 2; row++ )
      {
          for( int col = 0; col < pixels[0].length; col++ )
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[ pixels.length - 1 - row ][ col ];
              topPixel.setColor( bottomPixel.getColor() );
          }
      }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println( count );
  }
  
  /**
   * bounds are for the source to copy from
   */
  private void mirrorPart( int leftX, int rightX, int topY, int bottomY, int mirrorX, int mirrorY )
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel origPixel;  // the pixel to be covered
      Pixel newPixel;   // the pixel to replace origPixel
      
      for( int row = topY; row <= bottomY; row++ )
      {
          int dy = row - mirrorY;
          
          for( int col = leftX; col <= rightX; col++ )
          {
              int dX = col - mirrorX;
              newPixel = pixels[ row ][ col ];
              origPixel = pixels[ mirrorY - dy ][ mirrorX - dX ];
              origPixel.setColor( newPixel.getColor() );
          }
      }
  }
  
 /* 
  public void mirrorArms()
  {
      // mirror the viewer-right arm
      int mirrorX = 205;    // x value to mirror around (vertical line/mirror)
      int mirrorY = 192;    // y value to mirror around (horizontal line/mirror)
      
      // bounds of mirroring
      int leftX = 240;
      int rightX = 300;
      int topY = 170;
      int bottomY = 192;
      
      this.mirrorPart( leftX, rightX, topY, bottomY, mirrorX, mirrorY );
      
      // mirror the viewer-left arm
      // mirror the viewer-right arm
      int mirrorX = 205;    // x value to mirror around (vertical line/mirror)
      int mirrorY = 192;    // y value to mirror around (horizontal line/mirror)
      
      // bounds of mirroring
      int leftX = 240;
      int rightX = 300;
      int topY = 170;
      int bottomY = 192;
      
      this.mirrorPart( leftX, rightX, topY, bottomY, mirrorX, mirrorY );
  }
  */
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
