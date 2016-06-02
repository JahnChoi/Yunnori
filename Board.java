import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel
{
    private JLabel image;
       
    private String [] teamNames;

    public Board()
    {
        
        setLayout( new GridLayout( 15, 15 ) );
        
        //----------------------------------------------------------------------------------------------------
//        
//        title = new JLabel();
//        title.setText( "Yunnori Board" );
//        title.setHorizontalAlignment( 0 );
//        
//        mainPanel = new JPanel();
//        mainPanel.setLayout( new GridLayout( 1, 1 ) );
        image = new JLabel();
        // http://stackoverflow.com/questions/20886415/displaying-image-in-jpanel-from-netbeans-gui-builder
        image.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Yut Board.jpg" ) ) );
        add( image );
//        mainPanel.add( image );
        
//        frame = new JFrame();
//        frame.setSize( 1000, 800 );
//        frame.setTitle( "Yunnori Board" );
//        frame.setLayout( new GridLayout( 1, 1 ) );
//        frame.add( mainPanel );
//        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        frame.setVisible( true );
    }
    
//    protected void paintComponent( Graphics g )
//    {
//        super.paintComponent( g );
//        g.drawImage( image, 0, 0, null ); //need image, not JLabel
//    }
    
    public void update( Occupant [] newBoard )
    {
        for( int r = 0; r < 15; r++ )
        {
            for( int c = 0; c < 15; c++ )
            {
                if( r != 0 && c != 0 )
                    remove( 0 );
                
                if( r == 1 )
                {
                    if( c == 1 && newBoard[ 16 ] != null )
                        add( insertPiece( newBoard[ 16 ] ) );
                    if( c == 3 && newBoard[ 15 ] != null )
                        add( insertPiece( newBoard[ 15 ] ) );
                    if( c == 6 && newBoard[ 14 ] != null )
                        add( insertPiece( newBoard[ 14 ] ) );
                    if( c == 8 && newBoard[ 13 ] != null )
                        add( insertPiece( newBoard[ 13 ] ) );
                    if( c == 11 && newBoard[ 12 ] != null )
                        add( insertPiece( newBoard[ 12 ] ) );
                    if( c == 13 && newBoard[ 11 ] != null )
                        add( insertPiece( newBoard[ 11 ] ) );
                }
                else if( r == 3 )
                {
                    if( c == 1 && newBoard[ 17 ] != null )
                        add( insertPiece( newBoard[ 17 ] ) );
                    if( c == 3 && newBoard[ 29 ] != null )
                        add( insertPiece( newBoard[ 29 ] ) );
                    if( c == 11 && newBoard[ 26 ] != null )
                        add( insertPiece( newBoard[ 26 ] ) );
                    if( c == 13 && newBoard[ 10 ] != null )
                        add( insertPiece( newBoard[ 10 ] ) );                    
                }
                else if( r == 5 )
                {
                    if( c == 5 && newBoard[ 28 ] != null )
                        add( insertPiece( newBoard[ 28 ] ) );
                    if( c == 9 && newBoard[ 27 ] != null )
                        add( insertPiece( newBoard[ 27 ] ) );
                }
                else if( r == 6 )
                {
                    if( c == 1 && newBoard[ 18 ] != null )
                        add( insertPiece( newBoard[ 18 ] ) );
                    if( c == 13 && newBoard[ 9 ] != null )
                        add( insertPiece( newBoard[ 9 ] ) );
                }
                else if( r == 7 && c == 7 && newBoard[ 23 ] != null )
                {
                    add( insertPiece( newBoard[ 23 ] ) );
                }
                else if( r == 8 )
                {
                    if( c == 1 && newBoard[ 19 ] != null )
                        add( insertPiece( newBoard[ 18 ] ) );
                    if( c == 13 && newBoard[ 8 ] != null )
                        add( insertPiece( newBoard[ 8 ] ) );
                }
                else if( r == 9 )
                {
                    if( c == 5 && newBoard[ 24 ] != null )
                        add( insertPiece( newBoard[ 24 ] ) );
                    if( c == 9 && newBoard[ 22 ] != null )
                        add( insertPiece( newBoard[ 22 ] ) );
                }
                else if( r == 11 )
                {
                    if( c == 1 && newBoard[ 20 ] != null )
                        add( insertPiece( newBoard[ 20 ] ) );
                    if( c == 3 && newBoard[ 25 ] != null )
                        add( insertPiece( newBoard[ 25 ] ) );
                    if( c == 11 && newBoard[ 21 ] != null )
                        add( insertPiece( newBoard[ 21 ] ) );
                    if( c == 13 && newBoard[ 7 ] != null )
                        add( insertPiece( newBoard[ 7 ] ) );                    
                }
                else if( r == 13 )
                {
                    if( c == 1 && newBoard[ 1 ] != null )
                        add( insertPiece( newBoard[ 1 ] ) );
                    if( c == 3 && newBoard[ 2 ] != null )
                        add( insertPiece( newBoard[ 2 ] ) );
                    if( c == 6 && newBoard[ 3 ] != null )
                        add( insertPiece( newBoard[ 3 ] ) );
                    if( c == 8 && newBoard[ 4 ] != null )
                        add( insertPiece( newBoard[ 4 ] ) );
                    if( c == 11 && newBoard[ 5 ] != null )
                        add( insertPiece( newBoard[ 5 ] ) );
                    if( c == 13 && newBoard[ 6 ] != null )
                        add( insertPiece( newBoard[ 6 ] ) );
                }
                else
                    add( new JLabel() ); 
            }
        }
    }
    
    public JLabel insertPiece( Occupant x )
    {
        JLabel piece = new JLabel();
        
        if( x.getTeamName().equals( "A" ) )
        {
            if( x.getNumOfPieces() == 1 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 1-1.png" ) ) );             
            else if( x.getNumOfPieces() == 2 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 1-2.png" ) ) );              
            else if( x.getNumOfPieces() == 3 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 1-3.png" ) ) );             
            else
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 1-4.png" ) ) );  
        }
        else if( x.getTeamName().equals( "B" ) )
        {
            if( x.getNumOfPieces() == 1 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 2-1.png" ) ) );             
            else if( x.getNumOfPieces() == 2 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 2-2.png" ) ) );              
            else if( x.getNumOfPieces() == 3 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 2-3.png" ) ) );             
            else
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 2-4.png" ) ) ); 
        }
        else if( x.getTeamName().equals( "C" ) )
        {
            if( x.getNumOfPieces() == 1 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 3-1.png" ) ) );             
            else if( x.getNumOfPieces() == 2 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 3-2.png" ) ) );              
            else if( x.getNumOfPieces() == 3 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 3-3.png" ) ) );             
            else
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 3-4.png" ) ) ); 
        }
        else
        {
            if( x.getNumOfPieces() == 1 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 4-1.png" ) ) );             
            else if( x.getNumOfPieces() == 2 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 4-2.png" ) ) );              
            else if( x.getNumOfPieces() == 3 )
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 4-3.png" ) ) );             
            else
                piece.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/Piece 4-4.png" ) ) ); 
        }
        
        return piece;
    }

    
    
}