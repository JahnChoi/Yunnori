import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//When do we change teams?

public class TossSticksPanel
{
    private JFrame frame;
    private JPanel mainPanel;
    private JButton toss;
    private JLabel buttonText;
    private JLabel teamText;
    private int numberOfTeams;
    private int team;
    private JLabel totalText;
    private JLabel displayTotal;
    private int total;
    
    public TossSticksPanel( int numberOfTeams )
    {
        mainPanel = new JPanel();
        buttonText = new JLabel( "Toss" );
        totalText = new JLabel( "TOTAL: " );
        displayTotal = new JLabel( " " );
        this.numberOfTeams = numberOfTeams;
        setUpButton();
        
        //set up layout
        
        frame = new JFrame();
        //set frame dimensions
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //frame.add( ) <-- add panels to frame
        frame.setVisible( true );
    }
    
    public int getTeam()
    {
        return team;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setUpButton()
    {
        toss = new JButton( "Toss" );
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                Stick one = new Stick();
                Stick two = new Stick();
                Stick three = new Stick();
                Stick four = new Stick();
                
                //figure out how to display sticks on panel
                
                total = calculateTotal( one, two, three, four );
                
            }
        }
    }
    
    public int calculateTotal( Stick a, Stick b, Stick c, Stick d )
    {
        Stick [] group = new Stick[ 4 ];
        group[ 0 ] = a;
        group[ 1 ] = b;
        group[ 2 ] = c;
        group[ 4 ] = d;
        int t = 0;
        for( int i = 0; i < 4; i++ )
        {
        if( group[ i ].getFlatSideUp() == true )
            t++;
        }
        if( t == 0 )
            return 5;
        else
            return t;
    }
}
