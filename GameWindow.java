import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameWindow
{
    private JFrame mainFrame;
    private JPanel panel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    private JLabel label, label1, label2, label3, label4, label5;
    
    
    public GameWindow( String[] teamList, int numOfTeams )
    {
        // BOARD
        path0 = new Occupant[ 1 ];
        path1 = new Occupant[ 5 ];
        path2 = new Occupant[ 5 ];
        path3 = new Occupant[ 4 ];
        path4 = new Occupant[ 5 ];
        path5 = new Occupant[ 2 ];
        path6 = new Occupant[ 2 ];
        path7 = new Occupant[ 2 ];
        path8 = new Occupant[ 2 ];
        path9 = new Occupant[ 1 ];
        path10 = new Occupant[ 1 ];
        
        teamNames = teamList;
        
        masterArray = new Occupant[ 11 ][];
        masterArray[ 0 ] = path0;
        masterArray[ 1 ] = path1;
        masterArray[ 2 ] = path2;
        masterArray[ 3 ] = path3;
        masterArray[ 4 ] = path4;
        masterArray[ 5 ] = path5;
        masterArray[ 6 ] = path6;
        masterArray[ 7 ] = path7;
        masterArray[ 8 ] = path8;
        masterArray[ 9 ] = path9;
        masterArray[ 10 ] = path10;
        
        startZone = new int[ teamList.length ];
        score = new int[ teamList.length ];
        setUpScoreAndStartZone( teamList.length );
        
        //---------------------------------------
        
        title = new JLabel();
        title.setText( "Yunnori Board" );
        title.setHorizontalAlignment( 0 );
        
        boardPanel = new JPanel();
        boardPanel.setLayout( new GridLayout( 1, 1 ) );
        image = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yunnori Board.jpg" ) ) );
        boardPanel.add( image );
        
        boardFrame = new JFrame();
        boardFrame.setSize( 1000, 800 );
        boardFrame.setTitle( "Yunnori Board" );
        boardFrame.setLayout( new GridLayout( 1, 1 ) );
        boardFrame.add( boardPanel );
        boardFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        boardFrame.setVisible( true );
        
        // TOSS STICKS PANEL
//        numberOfTeams = numOfTeams + 1;
//        setUpTeams( numberOfTeams );
        
        teamText = new JLabel();
        teamText.setText( "Team " + teamNames[ currentTeam ] );
        teamText.setHorizontalAlignment( 0 );
        
        setUpTossButton();
        
        sticksImage = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
        sticksImage.setHorizontalAlignment( 0 );
        tossPanel1 = new JPanel();
        tossPanel1.add( sticksImage );
        tossPanel1.setSize( 300, 400 );
        
        totalText = new JLabel();
        totalText.setText( "TOTAL: " + total );
        totalText.setHorizontalAlignment( 0 );

        setUpEndTurnButton();
        
        //set up layout
        tossMainPanel = new JPanel();
        tossMainPanel.setLayout( new GridLayout( 5, 1 ) );
        // Borderlayout gridbaglayout
//        tossMainPanel.setLayout( new GridBagLayout() );
        tossMainPanel.add( teamText );
        tossMainPanel.add( toss );
        tossMainPanel.add( panel1 ); //Sticks go here
        tossMainPanel.add( totalText );
        tossMainPanel.add( endTurn );
        
        frame = new JFrame();
        frame.setTitle( "Yunnori Sticks" );
        frame.setSize( 350, 450 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( tossMainPanel );
        frame.setVisible( true );
        
        
        // SELECTION PANEL
        directionText = new JLabel();
        directionText.setText( "Move piece(s) from: " );
        toText = new JLabel();
        toText.setText( " to " );
        ifStartText = new JLabel();
        ifStartText.setText( "If starting piece, select team: " );
        
        start = new JComboBox();
        end = new JComboBox();
        
        team = new JComboBox();
        setTeamComboBox( numOfTeams );
        
        setUpMoveButton();
    }

//---------------------------------------------------------------------------------------------------

    // INSERT BOARD CODE
    private JFrame boardFrame;
    private JPanel boardPanel;
    private JLabel title, image;
    
    private Occupant[] path0, path1, path2, path3, path4, path5, path6, path7, path8, path9, path10;
    private Occupant[][] masterArray;
    
    private String[] teamNames;
    
    private int[] startZone;
    private int[] score;
    
    public void setUpScoreAndStartZone( int numTeams )
    {     
        for( int i = 0; i < numTeams; i++ )
        {
            score[ i ] = 0;
            startZone[ i ] = 4;
        }
    }
    
    //revise checking for null/nonexistant location
    public void movePiece( int oldPath, int oldLocation, int newPath, int newLocation )
    {
        if( oldPath == 100 && oldLocation == 100 )
        {
            int t = team.getSelectedIndex() - 1; //team is the ComboBox from SelectionPanel
            if( startZone[ t ] > 0 )
            {
                startZone[ t ] = startZone[ t ] - 1;
                Occupant newPiece = new Occupant( teamNames[ getCurrentTeam() ], 1 ); //getCurrentTeam() is in TossSticksPanel
                if( masterArray[ newPath ][ newLocation ] != null )
                {
                    Occupant temp = new Occupant( masterArray[ newPath ][ newLocation ].getTeamName(), masterArray[ newPath ][ newLocation ].getNumOfPieces() );

                    if( temp.getTeamName().equals( teamNames[ getCurrentTeam() ] ) )
                    {
                        newPiece.addPieces( temp.getNumOfPieces() );
                    }
                    else
                    {
                        for( int i = 0; i < teamNames.length; i++ )
                        {
                            if( teamNames[ i ].equals( temp.getTeamName() ))
                                score[ i ] += temp.getNumOfPieces();
                        }
                    }
                }
                masterArray[ newPath ][ newLocation ] = newPiece;
            }
        }
        
        if( oldPath != 100 && oldLocation != 100 && masterArray[ oldPath ][ oldLocation ] != null )
        {
            Occupant old = masterArray[ oldPath ][ oldLocation ];

            if( newPath == 10 )
            {
                int x = 0;
                for( int i = 0; i < teamNames.length; i++ )
                {
                    if( old.getTeamName().equals( teamNames[ i ] ) )
                        x = i;
                }
                masterArray[ 10 ][ 0 ] = null;
                score[ x ] +=  old.getNumOfPieces();
                if( score[ x ] == 4 )
                {
                    endGame( teamNames[ x ] );
                }
            }
            else
            {
                if( masterArray[ newPath ][ newLocation ] != null )
                {
                    Occupant temp = new Occupant( masterArray[ newPath ][ newLocation ].getTeamName(), masterArray[ newPath ][ newLocation ].getNumOfPieces() );

                    if( temp.getTeamName().equals( old.getTeamName() ) )
                    {
                        old.addPieces( temp.getNumOfPieces() );
                    }

                    else
                    {
                        
                        for( int i = 0; i < teamNames.length; i++ )
                        {
                            if( teamNames[ i ].equals( temp.getTeamName() ))
                                score[ i ] += temp.getNumOfPieces();
                        }

                    }
                }

                masterArray[ newPath ][ newLocation ] = old;
                masterArray[ oldPath ][ oldLocation ] = null;
                
            }
        }

    }

//---------------------------------------------------------------------------------------------------------

    // INSERT TOSS STICKS PANEL CODE
    private JFrame frame;
    private JPanel tossMainPanel, tossPanel1;
    private JButton toss;
    private JLabel tossText;
    private JButton endTurn;
    private JLabel endTurnText;
    private JLabel teamText;
    private int numberOfTeams;
    private int currentTeam;
    private JLabel totalText, sticksImage;
    private JLabel displayTotal;
    private int total;
    
    public int getTotal()
    {
        return total;
    }
    
    public int getCurrentTeam()
    {
        return currentTeam;
    }
    
    public String[] getTeamNames()
    {
        return teamNames;
    }
    
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
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Do.jpg" ) ) );
                    total = 1;
                }
                else if( total == 2 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Gae.jpg" ) ) );
                    total = 2;
                }
                else if( total == 3 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Geol.jpg" ) ) );
                    total = 3;
                }
                else if( total == 4 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Geol.jpg" ) ) );
                    total = 4;
                }
                else if( total == 5 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut.jpg" ) ) );
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

//----------------------------------------------------------------------------------------------------

    // INSERT SELECTION PANEL CODE

//     **GUI FOR SELECTION PANEL**
    private JFrame selectionFrame;
    private JPanel selectionPanel;
    private JLabel directionText;
    private JLabel toText;
    private JLabel ifStartText;
    
    private JComboBox start;
    private JComboBox end;
    private JComboBox team;
    
    private JButton move;
    private JLabel moveLabel;
    
    public void setTeamComboBox( int x )
    {
        String [] list = new String[ x + 1 ];
        for( int i = 0; i < x; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
            if( i == 1 )
                list[ i ] = "A";
            if( i == 2 )
                list[ i ] = "B";
            if( i == 3 )
                list[ i ] = "C";
            if( i == 4 )
                list[ i ] = "D";
        }
        
        team.setModel( new javax.swing.DefaultComboBoxModel( list ) );
    }
    
    public void setStartComboBox()
    {
        String [] list = new String [ 31 ];
        for( int i = 0; i < 31; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
            else
                list[ i ] = i - 1 + "";
        }
        start.setModel( new javax.swing.DefaultComboBoxModel( list ) );
    }
    
    public void setEndComboBox()
    {
        String [] list = new String [ 31 ];
        for( int i = 0; i < 31; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
            else
                list[ i ] = i + " ";
        }
        end.setModel( new javax.swing.DefaultComboBoxModel( list ) );
    }
    
    public int convertToPath( int n )
    {
        if( n == 0 )
            return 100;        
        else if( n == 1 )
            return 9;
        else if( n >= 2 && n <= 6 )
            return 1;
        else if( n >= 7 && n <= 11 )
            return 2;
        else if( n >=12 && n <= 15)
            return 3;
        else if( n >=16 && n <=20 )
            return 4;
        else if( n == 21 && n == 22 )
            return 5;
        else if( n == 23 )
            return 0;
        else if( n == 24 && n == 25 )
            return 8;
        else if( n == 26 && n == 27 )
            return 7;
        else if( n == 28 && n == 29 )
            return 6;
        else if( n == 30 )
            return 10;
        else
            return -1;
 
    }
    
    public int convertToIndex( int n )
    {
        if( n == 0 )
            return 100;
        if(  n == 1 || n == 2 || n == 7 || n == 12 || n == 16 || n == 21 ||n == 23 || n == 24 || n == 26 || n == 28 || n == 30 )
            return 0;
        if(  n == 3 || n == 8 || n == 13 || n == 17 || n == 22 || n == 25 ||n == 27 || n == 29 )
            return 1;
        if(  n == 4 || n == 9 || n == 14 || n == 18 )
            return 2;
        if(  n == 5 || n == 10 || n == 15 || n == 19 )
            return 3;
        if( n == 6 || n == 11 || n == 20 )
            return 4;
        else
            return -1;
    }
    
    public void setUpMoveButton()
    {
        move = new JButton( "Move" );
        
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                //movePiece is from the Board class
                if( start.getSelectedIndex() != 0 && end.getSelectedIndex() != 0 )
                    movePiece( convertToPath( start.getSelectedIndex() - 1 ), convertToIndex( start.getSelectedIndex() - 1 ), convertToPath( end.getSelectedIndex() ), convertToIndex( end.getSelectedIndex() ) );
            }
        }
        ActionListener listener = new ButtonListener();
        start.addActionListener( listener );
    }

//-----------------------------------------------------------------------------------------------------

    public void endGame( String team )
    {
        EndGame end = new EndGame( team );
    }
}