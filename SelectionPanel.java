import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SelectionPanel
{
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel directionText;
    private JLabel toText;
    private JLabel ifStartText;
    
    private JComboBox start;
    private JComboBox end;
    private JComboBox team;
    
    private JButton move;
    private JLabel moveLabel;
    
    public SelectionPanel( int numOfTeams )
    {
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
    }
    
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
            if( i == 1 )
                list[ i ] = "START";
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
            if( i == 30 )
                list[ i ] = "END";
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
        else if( n >= 12 && n <= 15)
            return 3;
        else if( n >= 16 && n <= 20 )
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
}