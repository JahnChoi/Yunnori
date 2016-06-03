
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Board extends JPanel
{
    private Button[][] buttons;
    
    public Board()
    {
        setLayout( new GridLayout(11, 11));
        buttons = new Button[11][11];
        
        for( int r = 0; r < buttons[0].length; r++ )
        {
            for( int c = 0; c < buttons.length; c++ )
            {
                buttons[r][c] = new Button();
                add(buttons[r][c]);
                buttons[r][c].setVisible(false);
            }
        }
        
        setUpButtons();
    }
    
    public void setUpButtons()
    {
        buttons[0][0].setVisible(true);
        buttons[0][0].setLabel( "16" );
        buttons[0][2].setVisible(true);
        buttons[0][2].setLabel( "15" );
        buttons[0][4].setVisible(true);
        buttons[0][4].setLabel( "14" );
        buttons[0][6].setVisible(true);
        buttons[0][6].setLabel( "13" );
        buttons[0][8].setVisible(true);
        buttons[0][8].setLabel( "12" );
        buttons[0][10].setVisible(true);
        buttons[0][10].setLabel( "11" );
        buttons[2][0].setVisible(true);
        buttons[2][0].setLabel( "17" );
        buttons[2][2].setVisible(true);
        buttons[2][2].setLabel( "29" );
        buttons[2][8].setVisible(true);
        buttons[2][8].setLabel( "26" );
        buttons[2][10].setVisible(true);
        buttons[2][10].setLabel( "10" );
        buttons[4][0].setVisible(true);
        buttons[4][0].setLabel( "18" );
        buttons[4][3].setVisible(true);
        buttons[4][3].setLabel( "28" );
        buttons[4][7].setVisible(true);
        buttons[4][7].setLabel( "27" );
        buttons[4][10].setVisible(true);
        buttons[4][10].setLabel( "9" );
        buttons[5][5].setVisible(true);
        buttons[5][5].setLabel( "23" );
        buttons[6][0].setVisible(true);
        buttons[6][0].setLabel( "19" );
        buttons[6][3].setVisible(true);
        buttons[6][3].setLabel( "24" );
        buttons[6][7].setVisible(true);
        buttons[6][7].setLabel( "22" );
        buttons[6][10].setVisible(true);
        buttons[6][10].setLabel( "8" );
        buttons[8][0].setVisible(true);
        buttons[8][0].setLabel( "20" );
        buttons[8][2].setVisible(true);
        buttons[8][2].setLabel( "25" );
        buttons[8][8].setVisible(true);
        buttons[8][8].setLabel( "21" );
        buttons[8][10].setVisible(true);
        buttons[8][10].setLabel( "7" );
        buttons[10][0].setVisible(true);
        buttons[10][0].setLabel( "1" );
        buttons[10][2].setVisible(true);
        buttons[10][2].setLabel( "2" );
        buttons[10][4].setVisible(true);
        buttons[10][4].setLabel( "3" );
        buttons[10][6].setVisible(true);
        buttons[10][6].setLabel( "4" );
        buttons[10][8].setVisible(true);
        buttons[10][8].setLabel( "5" );
        buttons[10][10].setVisible(true);
        buttons[10][10].setLabel( "6" );
    }
    
    public void update( Occupant[] masterArray )
    {
        for( int r = 0; r < buttons.length; r++ )
        {
            for( int c = 0; c < buttons[0].length; c++ )
            {
                for( int b = 1; b < masterArray.length; b++ )
                {
                    if( masterArray[b] != null && buttons[r][c].isVisible() )
                    {
                        int num = 0;
                        //( buttons[r][c].getLabel().length() != 1 && buttons[r][c].getLabel().length() != 2 && ( buttons[r][c].getLabel().charAt( 1 ) ) == ' ' || buttons[r][c].getLabel().charAt( 2 ) == ' ' )
                        if( buttons[r][c].getLabel().indexOf( "(" ) != -1 )
                        {
                            int x = buttons[r][c].getLabel().indexOf( " " );
                            num += Integer.parseInt( buttons[r][c].getLabel().substring( 0, x ) );
                        }
                        else
                            num = Integer.parseInt( buttons[r][c].getLabel() );
                        if( num == b + 1 && masterArray[b].getLastNum() != num && masterArray[b].getLastNumP() != masterArray[b].getNumOfPieces() )
                        {
                            if( masterArray[b].getTeamName().equals( "A" ) )
                            {
                                buttons[r][c].setBackground( Color.green );
                                buttons[r][c].setLabel( num + " (" + masterArray[b].getNumOfPieces() + ")" );
                            }
                            else if( masterArray[b].getTeamName().equals( "B" ) )
                            {
                                buttons[r][c].setBackground( Color.blue );
                                buttons[r][c].setLabel( num + " (" + masterArray[b].getNumOfPieces() + ")" );
                            }
                            else if( masterArray[b].getTeamName().equals( "C" ) )
                            {
                                buttons[r][c].setBackground( Color.pink );
                                buttons[r][c].setLabel( num + " (" + masterArray[b].getNumOfPieces() + ")" );
                            }
                            else if( masterArray[b].getTeamName().equals( "D" ) )
                            {
                                buttons[r][c].setBackground( Color.yellow );
                                buttons[r][c].setLabel( num + " (" + masterArray[b].getNumOfPieces() + ")" );
                            }
                            else
                            {
                                buttons[r][c].setLabel( buttons[r][c].getLabel() + "\b\b\b\b" );
                                buttons[r][c].setBackground( buttons[10][0].getBackground() );
                            }
                            masterArray[b].setLastNum( num );
                        }
                    }
                }        
            }
        }
    }
}