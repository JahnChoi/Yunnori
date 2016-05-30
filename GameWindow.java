import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameWindow
{
    private JFrame frame;
    
    public GameWindow( int numTeams )
    {
        
    }

//---------------------------------------------------------------------------------------------------

    // INSERT BOARD CODE

//---------------------------------------------------------------------------------------------------------

    // INSERT TOSS STICKS PANEL CODE

//----------------------------------------------------------------------------------------------------

    // INSERT SELECTION PANEL CODE

//-----------------------------------------------------------------------------------------------------

    public void endGame( String team )
    {
        EndGame end = new EndGame( team );
    }
}