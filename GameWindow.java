import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class GameWindow
{
    private JFrame mainFrame;
    private JPanel panel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    private JLabel label, label1, label2, label3, label4, label5;
    private JLabel image, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17;
    private JComboBox comboBox1, comboBox2, comboBox3;
 
    private JFrame selectionFrame;
    private JPanel selectionPanel;
    private JLabel directionText;
    
    private JComboBox start;
    private JComboBox end;
    private JComboBox team;
    
    private JPanel pane;
    private GridBagConstraints c;
    private JLabel title;
    private JLabel startZoneLabel;
    private JLabel teamAndPieceLabel, aTeam, bTeam, cTeam, dTeam;
    
    private JLabel movePieceText, fromText, toText, ifStartText, selectTeamText;
    
    private JButton move;
    private JLabel moveLabel;   

    private JFrame boardFrame;
    private JPanel boardPanel;
//    private JLabel title, image;
    
    private Occupant[] masterArray;
    
    private String[] teamNames;
    
    private int[] startZone;
    private int[] score;
    
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
    
    private Board1 board;
    
    int num1, num2;
    
    public GameWindow( String[] teamList, int numOfTeams )
    {
        // BOARD       
        masterArray = new Occupant[ 30 ];
        teamNames = teamList;
        
        startZone = new int[ teamList.length + 1 ];
        score = new int[ teamList.length + 1 ];
        
        for( int i = 0; i < numOfTeams + 1; i++ )
        {
            score[ i ] = 0;
            startZone[ i ] = 4;
        }
//        setUpScoreAndStartZone( teamList.length + 1 );
        
        //START ZONE TABLE
        //This MUST be below setUpScoreAndStartZone

        //---------------------------------------
        //Kelly did this, so hopefully it works :)
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        
        pane = new JPanel( new GridBagLayout() );
        pane.setLayout( new GridBagLayout() );
        c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;

        
        title = new JLabel( "Yunnori" ); //change font size so can fill 3 units (?)
        title.setHorizontalAlignment( 0 );
//        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 0;
        pane.add( title, c );
        
        startZoneLabel = new JLabel( "START ZONE" ); //change font size
        startZoneLabel.setHorizontalAlignment( 0 );
//        c.gridwidth = 11;
        c.gridx = 0;
        c.gridy = 2;
        pane.add( startZoneLabel, c );
        
        teamAndPieceLabel = new JLabel( "Team  ---  # Piece(s)" );
        teamAndPieceLabel.setHorizontalAlignment( 0 );
//        c.gridwidth = 11;
        c.gridx = 0;
        c.gridy = 3;
        pane.add( teamAndPieceLabel, c );
        
        //        // TOSS STICKS PANEL
        numberOfTeams = numOfTeams + 1;
        setUpTeams( numberOfTeams );
        
        //sets up all teams' data and places on pane
        setUpStartChart( numberOfTeams );
        
        //BOARD
//        image1 = new JLabel();
//        image1.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/YunnoriBoard.png" ) ) );
//        c.gridx = 1;
//        c.gridy = 1;
//        pane.add( image1, c );

        
//        backPanel = new BackgroundPanel();
//        c.ipadx = 500;
//        c.ipady = 500;
//        c.gridx = 1;
//        c.gridy = 1;
//        pane.add( backPanel, c );
        
        //Resume TossSticksPanel
        teamText = new JLabel();
        teamText.setText( "Team " + teamNames[ currentTeam ] );
        teamText.setHorizontalAlignment( 0 );
//        c.gridwidth = ;
        c.gridx = 1;
        c.gridy = 2;
        pane.add( teamText, c );
        
        sticksImage = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
        sticksImage.setHorizontalAlignment( 0 );
        c.gridx = 1;
        c.gridy = 3;
        pane.add( sticksImage, c );
        
        totalText = new JLabel();
        totalText.setText( "TOTAL: " + total );
        totalText.setHorizontalAlignment( 0 );
//        c.gridwidth = 16;
        c.gridx = 1;
        c.gridy = 4;
        pane.add( totalText, c );
        
        //sets up button and places on pane
        setUpTossButton();
        setUpEndTurnButton();
        
        //SelectionPanel
        movePieceText = new JLabel( "Move piece(s)" );
        movePieceText.setHorizontalAlignment( 0 );
//        c.gridwidth = 9;
//        c.gridheight = 2;
        c.gridx = 60;
        c.gridy = 0;
        pane.add( movePieceText, c );
        
        //fix formatting
        fromText = new JLabel( "From: " );
        c.gridwidth = 4;
//        c.gridheight = 2;
        c.gridx = 65;
        c.gridy = 2;
        pane.add( fromText, c );

        //start = new JComboBox();
        setStartComboBox();
        c.gridwidth = 4;
        c.gridx = 70;
        c.gridy = 2;
        pane.add( start, c );
        
        toText = new JLabel( "To: " );
        c.gridwidth = 4;
//        c.gridheight = 2;
        c.gridx = 65;
        c.gridy = 3;
        pane.add( toText, c );
        
        //end = new JComboBox();
        setEndComboBox();
        c.gridwidth = 4;
        c.gridx = 70;
        c.gridy = 3;
        pane.add( end, c );
        
        ifStartText = new JLabel( "If moving from START," );
        ifStartText.setHorizontalAlignment( 0 );
//        c.gridwidth = 9;
//        c.gridheight = 2;
        c.gridx = 65;
        c.gridy = 4;
        pane.add( ifStartText, c );
        
        selectTeamText = new JLabel( "select team: " );
        selectTeamText.setHorizontalAlignment( 0 );
//        c.gridwidth = 9;
//        c.gridheight = 2;
        c.gridx = 65;
        c.gridy = 10;
        pane.add( selectTeamText, c );

        team = new JComboBox();
        setTeamComboBox( numOfTeams );
        c.gridx = 70;
        c.gridy = 10;
        pane.add( team, c );
        
//        sets up move button and places on pane
        setUpMoveButton();

        //---------------------------------------
        
//        panel = new JPanel();
//        panel.setLayout( new GridLayout( 1, 1 ) );
//        image = new JLabel();
//        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yunnori Board.jpg" ) ) );
//        panel.add( image );
        
        mainFrame = new JFrame();
        mainFrame.setSize( 600, 500 );
        mainFrame.setTitle( "YUNNORI (Traditional Korean Board Game)" );
        mainFrame.setLayout( new GridBagLayout() );
        mainFrame.add( pane );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.setVisible( true );
        
        //*********************************************************************************************
        //*********************************************************************************************
        
        //backPanel = new BackgroundPanel();
        board = new Board1();
        
        
        
//        image = new JLabel();
//        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 1-1.png" ) ) );
//        boardPanel.add( image );
        
        boardFrame = new JFrame();
        boardFrame.setTitle( "YUNNORI BOARD" );
        boardFrame.setSize( 800,800 );
        boardFrame.add( board );
        boardFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        boardFrame.setVisible( true );
        
//        title = new JLabel();
//        title.setText( "Yunnori Board" );
//        title.setHorizontalAlignment( 0 );
//        
//        boardPanel = new JPanel();
//        boardPanel.setLayout( new GridLayout( 1, 1 ) );
//        image = new JLabel();
//        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
//        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yunnori Board.jpg" ) ) );
//        boardPanel.add( image );
//        
//        boardFrame = new JFrame();
//        boardFrame.setSize( 1000, 800 );
//        boardFrame.setTitle( "Yunnori Board" );
//        boardFrame.setLayout( new GridLayout( 1, 1 ) );
//        boardFrame.add( boardPanel );
//        boardFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        boardFrame.setVisible( true );
//        

//        
//        teamText = new JLabel();
//        teamText.setText( "Team " + teamNames[ currentTeam ] );
//        teamText.setHorizontalAlignment( 0 );
//        
//        setUpTossButton();
//        
//        sticksImage = new JLabel();
//        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
//        sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
//        sticksImage.setHorizontalAlignment( 0 );
//        tossPanel1 = new JPanel();
//        tossPanel1.add( sticksImage );
//        tossPanel1.setSize( 300, 400 );
//        
//        totalText = new JLabel();
//        totalText.setText( "TOTAL: " + total );
//        totalText.setHorizontalAlignment( 0 );
//
//        setUpEndTurnButton();
//        
//        //set up layout
//        tossMainPanel = new JPanel();
//        tossMainPanel.setLayout( new GridLayout( 5, 1 ) );
//        // Borderlayout gridbaglayout
////        tossMainPanel.setLayout( new GridBagLayout() );
//        tossMainPanel.add( teamText );
//        tossMainPanel.add( toss );
//        tossMainPanel.add( panel1 ); //Sticks go here
//        tossMainPanel.add( totalText );
//        tossMainPanel.add( endTurn );
//        
//        frame = new JFrame();
//        frame.setTitle( "Yunnori Sticks" );
//        frame.setSize( 350, 450 );
//        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        frame.add( tossMainPanel );
//        frame.setVisible( true );
//        
//        
//        // SELECTION PANEL
//        directionText = new JLabel();
//        directionText.setText( "Move piece(s) from: " );
//        toText = new JLabel();
//        toText.setText( " to " );
//        ifStartText = new JLabel();
//        ifStartText.setText( "If starting piece, select team: " );
//        
//        start = new JComboBox();
//        end = new JComboBox();
//        
//        team = new JComboBox();
//        setTeamComboBox( numOfTeams );
//        
//        setUpMoveButton();
    }
    //---------------------------------------------------------------------------------------------------
    
    public void setUpStartChart( int n )
    {
        for( int i = 0; i < n; i++ )
        {
            if( i == 0 )
            {
                aTeam = new JLabel( "A   ---   " + startZone[ 0 ] );
                aTeam.setForeground(Color.green);
                aTeam.setHorizontalAlignment( 0 );
                c.gridwidth = 11;
                c.gridx = 0;
                c.gridy = 4;
                pane.add( aTeam, c );
            }
            if( i == 1 )
            {
                bTeam = new JLabel( "B   ---   " + startZone[ 1 ] );
                bTeam.setForeground(Color.blue);
                bTeam.setHorizontalAlignment( 0 );
                c.gridwidth = 11;
                c.gridx = 0;
                c.gridy = 5;
                pane.add( bTeam, c );
            }
            if( i == 2 )
            {
                cTeam = new JLabel( "C   ---   " + startZone[ 2 ] );
                cTeam.setForeground(Color.pink);
                cTeam.setHorizontalAlignment( 0 );
                c.gridwidth = 11;
                c.gridx = 0;
                c.gridy = 6;
                pane.add( cTeam, c );
            }
            if( i == 3 )
            {
                dTeam = new JLabel( "D   ---   " + startZone[ 3 ] );
                dTeam.setForeground(Color.orange);
                dTeam.setHorizontalAlignment( 0 );
                c.gridwidth = 11;
                c.gridx = 0;
                c.gridy = 7;
                pane.add( dTeam, c );
            }                       
        }
    }
    
//---------------------------------------------------------------------------------------------------

    // INSERT BOARD CODE

    
    public void setUpScoreAndStartZone( int numTeams )
    {     
        for( int i = 0; i < numTeams; i++ )
        {
            score[ i ] = 0;
            startZone[ i ] = 4;
        }
    }

    public void movePiece( int oldLocation, int newLocation )
    {
        //moving a piece from the starting zone
        if( oldLocation == 0 )
        {
            int t = team.getSelectedIndex() - 1;
            
            if( startZone[ t ] > 0 )
            {
                startZone[ t ] = startZone[ t ] - 1;
                Occupant newPiece = new Occupant( teamNames[ getCurrentTeam() ], 1 );
                
                if( masterArray[ newLocation ] != null )
                {
                    Occupant temp = masterArray[ newLocation ]; //new Occupant( masterArray[ newLocation ].getTeamName(), masterArray[ newLocation ].getNumOfPieces() );

                    if( temp.getTeamName().equals( teamNames[ getCurrentTeam() ] ) )
                    {
                        newPiece.addPieces( temp.getNumOfPieces() );
                    }
                    else
                    {
                        for( int i = 0; i < teamNames.length; i++ )
                        {
                            if( teamNames[ i ].equals( temp.getTeamName() ))
                                startZone[ i ] += temp.getNumOfPieces();
                        }
                    }
                }
                masterArray[ newLocation ] = newPiece;
            }
        }
        
        if( oldLocation != 0 )// && masterArray[ oldLocation ] != null )
        {
            Occupant old = new Occupant( teamNames[ getCurrentTeam() ], masterArray[ oldLocation ].getNumOfPieces() );

            if( newLocation == 30 )
            {
                int x = 0;
                for( int i = 0; i < teamNames.length; i++ )
                {
                    if( old.getTeamName().equals( teamNames[ i ] ) )
                        x = i;
                }
                masterArray[ 30 ] = null;
                score[ x ] +=  old.getNumOfPieces();
                
                if( score[ x ] == 4 )
                {
                    boardFrame.setVisible( false );
                    mainFrame.setVisible( false );
                    endGame( teamNames[ x ] );
                }
            }
            else
            {
                System.out.println("Pineapple");
                if( masterArray[ newLocation ] != null )
                {
                    System.out.println("Apple");
                    Occupant temp = new Occupant(  masterArray[ newLocation ] );//.getTeamName(), masterArray[ newLocation ].getNumOfPieces() );

                    if( temp != null && temp.getTeamName().equals( old.getTeamName() ) )
                        old.addPieces( temp.getNumOfPieces() );

                    else
                    {
                        for( int i = 0; i < teamNames.length; i++ )
                        {
                            if( temp != null && teamNames[ i ].equals( temp.getTeamName() ) )
                            {
                                startZone[ i ] += temp.getNumOfPieces();
                            }
                            
                        }
                    }
                }
                masterArray[ newLocation ] = new Occupant( old );
                masterArray[ oldLocation ] = null;
            }
        }
        for( Occupant x: masterArray )
        {
            if(x != null )
                System.out.print( x.getNumOfPieces() + " " );
            else
                System.out.print("0 ");
        }
        System.out.println();
    }

//---------------------------------------------------------------------------------------------------------

    // INSERT TOSS STICKS PANEL CODE

    
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
        toss.setHorizontalAlignment( 0 );
//        c.gridwidth = 15;
        c.gridx = 1;
        c.gridy = 5;
        pane.add( toss, c );
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
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Do1.jpg" ) ) );
                    total = 1;
                }
                else if( total == 2 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Gae2.jpg" ) ) );
                    total = 2;
                }
                else if( total == 3 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Geol3.jpg" ) ) );
                    total = 3;
                }
                else if( total == 4 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut4.jpg" ) ) );
                    total = 4;
                }
                else if( total == 5 )
                {
                    sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Mo5.jpg" ) ) );
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
        endTurn.setHorizontalAlignment( 0 );
//        c.gridwidth = 15;
        c.gridx = 1;
        c.gridy = 6;
        pane.add( endTurn, c );
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                total = 0;
                sticksImage.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Sticks.png" ) ) );
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

    
    public void setTeamComboBox( int x )
    {
        String [] list = new String[ x + 2 ];
        for( int i = 0; i < list.length; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
            else if( i == 1 )
                list[ i ] = "A";
            else if( i == 2 )
                list[ i ] = "B";
            else if( i == 3 )
                list[ i ] = "C";
            else if( i == 4 )
                list[ i ] = "D";
        }
        
        team.setModel( new javax.swing.DefaultComboBoxModel( list ) );
    }
    
    public void setStartComboBox()
    {
        String [] list = new String [ 30 ];
        for( int i = 0; i < 30; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
//            else if( i == 1 )
//                list[ i ] = "START";
            else
                list[ i ] = i + "";
        }
        //start.setModel( new javax.swing.DefaultComboBoxModel( list ) );
        start = new JComboBox(list);
        start.addItemListener( new ItemListener(){
        public void itemStateChanged(ItemEvent ie)
        {
            num1 = Integer.parseInt( (String) start.getSelectedItem() );
        }
        });
        //http://www.roseindia.net/java/example/java/swing/ComboBox.shtmlm
    }
    
    public void setEndComboBox()
    {
        String [] list = new String [ 30 ];
        for( int i = 0; i < 30; i++ )
        {
            if( i == 0 )
                list[ i ] = " ";
//            else if( i == 29 )
//                list[ i ] = "30";
            else
                list[ i ] = i + "";
        }
        //end.setModel( new javax.swing.DefaultComboBoxModel( list ) );
        end = new JComboBox(list);
        end.addItemListener( new ItemListener(){
        public void itemStateChanged(ItemEvent ie)
        {
            num2 = Integer.parseInt( (String) end.getSelectedItem() ) - 1;
        }
        });
    }
    
    public void setUpMoveButton()
    {
        move = new JButton( "Move" );
        move.setHorizontalAlignment( 0 );
//        c.gridwidth = 9;
        c.gridx = 65;
        c.gridy = 30;
        pane.add( move, c );

        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                if( start.getSelectedIndex() != 0 && end.getSelectedIndex() != 0 )
                {
                    movePiece( num1 - 1, num2 + 1 );
                    board.update( masterArray );
                }
                
                for( int i = 0; i < teamNames.length; i++ )
                {
                    if( i == 0 )
                        aTeam.setText( "A   ---   " + startZone[ 0 ] );
                    if( i == 1 )
                        bTeam.setText( "B   ---   " + startZone[ 1 ] );
                    if( i == 2 )
                        cTeam.setText( "C   ---   " + startZone[ 2 ] );
                    if( i == 3 )
                        dTeam.setText( "D   ---   " + startZone[ 3 ] );
                }
                
                
            }
        }
        ActionListener listener = new ButtonListener();
        move.addActionListener( listener );
    }

//-----------------------------------------------------------------------------------------------------

    public void endGame( String team )
    {
        EndGame end = new EndGame( team );
    }
}