import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board
{
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel title, image;
    
    private String currentPath;
    private Occupant[] path0, path1, path2, path3, path4, path5, path6, path7, path8;
    private Occupant[][] masterArray;
    
    public Board()
    {
        path0 = new Occupant[ 1 ];
        path1 = new Occupant[ 6 ];
        path2 = new Occupant[ 5 ];
        path3 = new Occupant[ 4 ];
        path4 = new Occupant[ 5 ];
        path5 = new Occupant[ 2 ];
        path6 = new Occupant[ 2 ];
        path7 = new Occupant[ 2 ];
        path8 = new Occupant[ 2 ];
        masterArray = new Occupant[ 9 ][];
        masterArray[ 0 ] = path0;
        masterArray[ 1 ] = path1;
        masterArray[ 2 ] = path2;
        masterArray[ 3 ] = path3;
        masterArray[ 4 ] = path4;
        masterArray[ 5 ] = path5;
        masterArray[ 6 ] = path6;
        masterArray[ 7 ] = path7;
        masterArray[ 8 ] = path8;
        
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
    
    public int getcurrentPath()
    {
        return ;
    }
    
    public int findPath( String teamName, int pieceID )
    {
        for( Occupant[] x : masterArray )
        {
            for( Occupant y : x )
            {
                if( y.getTeamName().equals( teamName ) && y.ge)
                    
            }
        }
    }
}