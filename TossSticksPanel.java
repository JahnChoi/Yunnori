import java.awt.GridBagLayout;
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
//        numberOfTeams = numTeams + 1;
//        setUpTeams( numberOfTeams );
        
        teamText = new JLabel();
        teamText.setText( "Team " + teamNames[ currentTeam ] );
        teamText.setHorizontalAlignment( 0 );
        
        setUpTossButton();
        
        image = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
        image.setHorizontalAlignment( 0 );
        panel1 = new JPanel();
        panel1.add( image );
        panel1.setSize( 300, 400 );
        
        totalText = new JLabel();
        totalText.setText( "TOTAL: " + total );
        totalText.setHorizontalAlignment( 0 );

        setUpEndTurnButton();
        
        //set up layout
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 5, 1 ) );
        // Borderlayout gridbaglayout
//        mainPanel.setLayout( new GridBagLayout() );
        mainPanel.add( teamText );
        mainPanel.add( toss );
        mainPanel.add( panel1 ); //Sticks go here
        mainPanel.add( totalText );
        mainPanel.add( endTurn );
        
        frame = new JFrame();
        frame.setTitle( "Yunnori Sticks" );
        frame.setSize( 350, 450 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( mainPanel );
        frame.setVisible( true );
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public int getCurrentTeam()
    {
        return currentTeam;
    }
    
//    public String[] getTeamNames()
//    {
//        return teamNames;
//    }
    
    public void nextTeam()
    {
        if( currentTeam + 1 == numberOfTeams )
            currentTeam = 0;
        else
            currentTeam++;

        teamText.setText( "Team " + teamNames[ currentTeam ] );
    }
    
//    public void setUpTeams( int numberOfTeams )
//    {
//        teamNames = new String[ numberOfTeams ];
//        for( int i = 0; i < numberOfTeams; i++ )
//        {
//            if( i == 0 )
//                teamNames[ i ] = "A";
//            if( i == 1 )
//                teamNames[ i ] = "B";
//            if( i == 2 )
//                teamNames[ i ] = "C";
//            if( i == 3 )
//                teamNames[ i ] = "D";
//        }
//    }
    
    public void setUpTossButton()
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

                total = calculateTotal( one, two, three, four );
//                displayTotal.setText( total + "" );
                if( total == 1 )
                {
                    image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Do.jpg" ) ) );
                    total = 1;
                }
                else if( total == 2 )
                {
                    image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Gae.jpg" ) ) );
                    total = 2;
                }
                else if( total == 3 )
                {
                    image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Geol.jpg" ) ) );
                    total = 3;
                }
                else if( total == 4 )
                {
                    image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Geol.jpg" ) ) );
                    total = 4;
                }
                else if( total == 5 )
                {
                    image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut.jpg" ) ) );
                    total = 5;
                }
                totalText.setText( "TOTAL: " + total );
            }
        }
        ActionListener listener = new ButtonListener();
        toss.addActionListener( listener );
    }
    
    public void setUpEndTurnButton()
    {
        endTurn = new JButton( "End Turn" );
        
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                total = 0;
                totalText.setText( "TOTAL: " + total );
                nextTeam();
            }
        }
        ActionListener listener = new ButtonListener();
        endTurn.addActionListener( listener );
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