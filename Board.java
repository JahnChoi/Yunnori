import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board
{
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel title, image;
    
    public Board()
    {
        title = new JLabel();
        title.setText( "Yunnori Board" );
        title.setHorizontalAlignment( 0 );
        
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 1, 1 ) );
        ImageIcon icon = new ImageIcon( "Yut Board.jpg" );
        image = new JLabel();
        image.setIcon( icon );
        mainPanel.add( image );
        
        frame = new JFrame();
        frame.setSize( 500, 500 );
        frame.setTitle( "Yunnori Board" );
        frame.setLayout( new GridLayout( 1, 1 ) );
        frame.add( mainPanel );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}