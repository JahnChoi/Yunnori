import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SetUp
{
    private JFrame frame;
    private JPanel mainPanel, panel1, panel2;
    private JLabel title, numTeams;
    private JButton start;
    private JSeparator divide;
    private JComboBox comboBox;
    
    public SetUp()
    {
        title = new JLabel();
        title.setText( "YUNNORI" );
        title.setHorizontalAlignment( 0 );

        divide = new JSeparator();
        
        numTeams = new JLabel();
        numTeams.setText( "# of Teams" );
        numTeams.setHorizontalAlignment( 0 );
        
        comboBox = new JComboBox();
        comboBox.setModel( new javax.swing.DefaultComboBoxModel( new String[] { " ", "2", "3", "4" } ) );
        
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 3, 1 ) );
        mainPanel.add( title );
        mainPanel.add( divide );
        mainPanel.add( numTeams );
        mainPanel.add( comboBox );
        
        setUpButton();
        panel1 = new JPanel();
        panel1.add( start );
        
        frame = new JFrame();
        frame.setSize( 200, 200 );
        frame.setTitle( "Yunnori" );
        frame.setLayout( new GridLayout( 2, 1 ) );
        frame.add( mainPanel );
        frame.add( panel1 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
    
    private void setUpButton()
    {
        start = new JButton( "Start Game" );
        
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                //TossSticksPanel startGame = new TossSticksPanel( Integer.parseInt( comboBox.getSelectedItem() ) );
            }
        }
        ActionListener listener = new ButtonListener();
        start.addActionListener( listener );
    }
}