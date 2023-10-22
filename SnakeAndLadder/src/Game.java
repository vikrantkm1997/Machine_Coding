import Entity.Board;
import Entity.Player;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winnerPlayer;

    public Game(Board board,List<Player> players)
    {
        this.board = board;
        this.players = players;
        this.winnerPlayer = null;
    }
    void playGame()
    {
        while(winnerPlayer == null)
        {
            int numOfPlayers = players.size();
            for(int i=0;i<numOfPlayers;i++)
            {
                Player currPlayer = players.get(i);
                int currPos = currPlayer.getPlayerPos();
                int diceOutput= board.rollDice();
                currPos = currPos + diceOutput;
                if(currPos < board.getBoardSize())
                {
                    Boolean hasNofLag = false;
                    while(!hasNofLag) {
                        if (board.hasSnake(currPos)) {
                            currPos = board.getSnakeTail(currPos);
                        }
                        if (board.hasLadder(currPos)) {
                            currPos = board.getLadderStart(currPos);
                        }
                        if(!board.hasLadder(currPos) && !board.hasSnake(currPos))
                            hasNofLag = true;
                    }
                }
                else if(currPos > board.getBoardSize())
                {
                    currPos -= diceOutput;
                }
                else
                {
                    winnerPlayer = currPlayer;
                    currPlayer.setCurrentPos(currPos);
                    break;
                }
                currPlayer.setCurrentPos(currPos);
                System.out.println("The "+ currPlayer.getPlayerName()+" pos " + currPlayer.getPlayerPos());
            }
        }
        System.out.printf("\nThe winner is: %s\nPlayer position: %d\n", winnerPlayer.getPlayerName(), winnerPlayer.getPlayerPos());
    }

}
