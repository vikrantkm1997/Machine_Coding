package Entity;

public class Player {
    private String playerName;
    private int currentPos;

    public Player(String playerName,int currentPos)
    {
        this.playerName = playerName;
        this.currentPos = currentPos;
    }

    public int getPlayerPos()
    {
        return this.currentPos;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }
    public void setCurrentPos(int currentPos)
    {
        this.currentPos = currentPos;
    }
}
