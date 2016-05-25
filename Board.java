import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board
{
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel title, image;
    
    private Occupant[] path0, path1, path2, path3, path4, path5, path6, path7, path8, path9, path10;
    private Occupant[][] masterArray;
    
    private String [] teamNames;
    
    private int[] startZone;
    private int[] score;
    
    public Board( String [] teamList )
    {
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
        
        masterArray = new Occupant[ 10 ][];
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
        
        //----------------------------------------------------------------------------------------------------
        
        title = new JLabel();
        title.setText( "Yunnori Board" );
        title.setHorizontalAlignment( 0 );
        
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 1, 1 ) );
        image = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Board.jpg" ) ) );
        mainPanel.add( image );
        
        frame = new JFrame();
        frame.setSize( 1000, 800 );
        frame.setTitle( "Yunnori Board" );
        frame.setLayout( new GridLayout( 1, 1 ) );
        frame.add( mainPanel );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
    
    public void setUpScoreAndStartZone( int numTeams )
    {     
        for( int i = 0; i < numTeams; i++ )
        {
            score[ i ] = 0;
            startZone[ i ] = 4;
        }
        
    }
    
//    public int getCurrentPath( String teamName, int pieceID )
//    {
//        for( int a = 0; a < 9; a++ )
//        {
//            for( int b = 0; b < masterArray[ a ].length; b++ ) 
//            {
//                if( masterArray[ a ][ b ].getTeamName().equals( teamName ) )
//                {
//                    for( int i = 0; i < masterArray[ a ][ b ].getPieceID().size(); i++ )
//                    {
//                        if( masterArray[ a ][ b ].getPieceID().get( i ) == pieceID )
//                            return a;
//                    }
//                }  
//            }
//        }
//        
//        return 0;
//    }
    
    public void moveFromStartZone()
    {
        
    }
    
    //revise checking for null/nonexistant location
    public void movePiece( int oldPath, int oldLocation, int newPath, int newLocation )
    {
        if( masterArray[ oldPath ][ oldLocation ] != null )
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
                    EndGame yay = new EndGame();
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

                    }
                }
                else
                {
                    masterArray[ newPath ][ newLocation ] = old;
                    masterArray[ oldPath ][ oldLocation ] = null;
                }
            }
        }

    }
}