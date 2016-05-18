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
    private int currentTeam;
    private String [] teamNames;
    private JLabel totalText;
    private JLabel displayTotal;
    private int total;
    
    public TossSticksPanel( int numTeams )
    {
        mainPanel = new JPanel();
        teamText = new JLabel( "A" );
        buttonText = new JLabel( "Toss" );
        totalText = new JLabel( "TOTAL: " );
        displayTotal = new JLabel( " " );
        numberOfTeams = numTeams;
        setUpTeams( numberOfTeams );
        setUpButton();
        
        //set up layout
        
        frame = new JFrame();
        //set frame dimensions
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //frame.add( ) <-- add panels to frame
        frame.setVisible( true );
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void nextTeam()
    {
        if( currentTeam + 1 == numberOfTeams )
        {
            currentTeam = 0;
        }
        else
            currentTeam++;
        
        teamText.setText( teamNames[ currentTeam ] );
    }
    
    public void setUpTeams( int numberOfTeams )
    {
        teamNames = new String[ numberOfTeams ];
        for( int i = 0; i < numberOfTeams; i++ )
        {
            if( i == 0 )
                teamNames[ i ] = "A";
            if( i == 1 )
                teamNames[ i ] = "B";
            if( i == 2 )
                teamNames[ i ] = "C";
            if( i == 3 )
                teamNames[ i ] = "D";
        }
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
                displayTotal.setText( total + "" );
            }
        }
    }
    
    public int calculateTotal( Stick a, Stick b, Stick c, Stick d )
    {
        Stick [] group = new Stick[ 4 ];
        group[ 0 ] = a;
        group[ 1 ] = b;
        group[ 2 ] = c;
        group[ 3 ] = d;
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
