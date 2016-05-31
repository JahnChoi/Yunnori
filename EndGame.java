import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EndGame
{
    //makes new panel displaying a cheerful messge of victory
    private JFrame frame;
    private JPanel panel;
    private JLabel label, label2;
    private JButton button;
    
    public EndGame( String team )
    {
        label = new JLabel();
        label.setText( "CONGRATULATIONS TEAM " + team + "!");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setHorizontalAlignment( 0 );
//        label.setForeground(new Color(0xffffdd));
        label2 = new JLabel();
        label2.setText( "YOU WIN!!!" );
        label2.setFont(new Font("Serif", Font.PLAIN, 14));
//        label2.setForeground(new Color(0xffffdd));
        label2.setHorizontalAlignment( 0 );
        
        panel = new JPanel();
        panel.setLayout( new GridLayout( 3, 1 ) );
        panel.add( label );
        panel.add( label2 );
        setUpButton();
        panel.add( button );
        
        frame = new JFrame();
        frame.setTitle( "Team " + team );
        frame.setSize( 400, 400 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( panel );
        frame.setVisible( true );
    }
    
    public void setUpButton()
    {
        button = new JButton( "Exit Game" );
        
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                System.exit( 0 );
            }
        }
        ActionListener listener = new ButtonListener();
        button.addActionListener( listener );
    }
}