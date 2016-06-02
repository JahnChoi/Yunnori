import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class BackgroundPanel extends JPanel
{
    Image img;
    public BackgroundPanel()
    {
        try
        {
            img = ImageIO.read( new File( "Yunnori Board.png" ) );
        }
        catch (IOException e)
        {
            System.out.println("Error reading dir: " + e.getMessage());
        }
    }

    @Override
    public void paint(Graphics g)
    {
         Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - img.getWidth(null)) / 2;
        int y = (this.getHeight() - img.getHeight(null)) / 2;
        g2d.drawImage(img, x,y, null);
    }
}