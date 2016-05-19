import java.util.ArrayList;

public class Occupant
{
    private int numOfPieces;
    private String teamName;
    private int currentPath;
    private int previousPath;
    private ArrayList< Integer > pieceID;
    
    public Occupant( String team, int pieces )
    {
        numOfPieces = pieces;
        teamName = team;
        
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
    
    public int getpieceID()
    {
        
    }
}