import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel
{
    private BufferedImage img;
    public BackgroundPanel()
    {
        try
        {
            img = ImageIO.read( new File( "C:/Users/JohnC/Documents/NetBeansProjects/Yunnori/src/resources/YunnoriBoard.png" ) );
        }
        catch (IOException e)
        {
            System.out.println("Error reading dir: " + e.getMessage());
        }
    }
    
//    @Override
//    public void paint(Graphics g)
//    {
//        Graphics2D g2d = (Graphics2D) g;
////        int x = (this.getWidth() - img.getWidth(null)) / 2;
////        int y = (this.getHeight() - img.getHeight(null)) / 2;
//        g2d.drawImage(img, 0, 0, null);
//    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null); // see javadoc for more info on the parameters            
    }
}