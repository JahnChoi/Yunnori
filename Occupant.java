import java.util.ArrayList;

public class Occupant
{
    private int numOfPieces;
    private String teamName;
    private int lastNum;
    private int lastNumP;
    
    public Occupant( String team, int pieces )
    {
        numOfPieces = pieces;
        teamName = team;
        lastNum = 0;
        lastNumP = 0;
    }
    
    public Occupant( Occupant x )
    {
        this.numOfPieces = 0;
        this.teamName = x.teamName;
        this.lastNum = x.lastNum;
        this.lastNumP = x.lastNumP;
    }
    
    public int getNumOfPieces()
    {
        return numOfPieces;
    }
    
    public String getTeamName()
    {
        return teamName;
    }
    
    public void addPieces( int num )
    {
        numOfPieces += num;
    }
    
    public void setLastNum( int num )
    {
        lastNum = num;
    }
    
    public int getLastNum()
    {
        return lastNum;
    }
    
    public void setLastNumP( int num )
    {
        lastNumP = num;
    }
    
    public int getLastNumP()
    {
        return lastNumP;
    }
}