public class Stick
{
    private boolean flatSideUp; 
    
    public Stick()
    {
        flatSideUp = toss();
    }
    
    public boolean toss()
    {
        double x = Math.random();
        if( x < .6 )
            return true;
        else
            return false;
    }
    
    public boolean getFlatSideUp()
    {
        if( flatSideUp )
            return true;
        else
            return false;
    }
    
}