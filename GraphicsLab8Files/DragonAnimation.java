import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragonAnimation extends JPanel
    implements ActionListener
{
    private Dragon curve, curve1;
    private int steps = 10;
    private Timer clock;
    
    public DragonAnimation( int orderIn )
    {
        this.curve = new Dragon( orderIn );
        //this.curve1 = new Dragon( orderIn, Color.BLUE, 1 );
        
        this.clock = new Timer( 1, this );
        this.clock.start();
    }
    
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        if( steps < this.curve.curve.length() )
        {
            curve.draw( g, w/2, h/2 );
            //curve1.draw( g, w/2, h/2 );
        }
        else
        {
            g.drawRect( w / 2 - 10, h / 2 - 5, w / 2 + 10, h / 2 + 5 );
            g.drawString( "FINISHED", w / 2 - 9, h / 2 - 4 );
            this.clock.stop();
        }
    }
    
    public void actionPerformed( ActionEvent e )
    {
        this.curve.steps += steps;
        //this.curve1.steps += steps;
        repaint();
    }
    
    public static void main( int orderInput )
    {
        JFrame w = new JFrame("Dragon Curve");
        w.setSize( 1000, 1000 );
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DragonAnimation panel = new DragonAnimation( orderInput );
        panel.setBackground(Color.WHITE);
        w.getContentPane().add(panel);
        w.setVisible(true);
    }
}
