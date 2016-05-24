import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TossSticksPanel
{
    private JFrame frame;
    private JPanel mainPanel, panel1, panel2;
    private JButton toss;
    private JLabel tossText;
    private JButton endTurn;
    private JLabel endTurnText;
    private JLabel teamText;
    private int numberOfTeams;
    private int currentTeam;
    private String [] teamNames;
    private JLabel totalText, image;
    private JLabel displayTotal;
    private int total;
    
    public TossSticksPanel( int numTeams )
    {
        teamText = new JLabel();
        teamText.setText( "Team A" );
        teamText.setHorizontalAlignment( 0 );
        
        setUpTossButton();
        
        image = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
        image.setHorizontalAlignment( 0 );
        panel1 = new JPanel();
        panel1.add( image );
        
        totalText = new JLabel();
        totalText.setText( "TOTAL: " + total );
        totalText.setHorizontalAlignment( 0 );
        
        numberOfTeams = numTeams;
        setUpTeams( numberOfTeams );

        setUpEndTurnButton();
        
        //set up layout
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 5, 1 ) );
        mainPanel.add( teamText );
        mainPanel.add( toss );
        mainPanel.add( panel1 ); //Sticks go here
        mainPanel.add( totalText );
        mainPanel.add( endTurn );
        
        frame = new JFrame();
        frame.setSize( 350, 450 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( mainPanel );
        frame.setVisible( true );
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public String[] getTeamNames()
    {
        return teamNames;
    }
    
    public void nextTeam()
    {
        if( currentTeam + 1 == numberOfTeams )
        {
            currentTeam = 0;
        }
        else
            currentTeam++;
        
        teamText.setText( "Team " + teamNames[ currentTeam ] );
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
    
    public void setUpTossButton()
    {
        toss = new JButton( "Toss" );
        class TossButtonListener implements ActionListener
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
    
    public void setUpEndTurnButton()
    {
        endTurn = new JButton( "End Turn" );
        class EndTurnListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                displayTotal.setText( " " );
                nextTeam();
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