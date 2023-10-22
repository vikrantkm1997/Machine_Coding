package Entity;

import java.util.Map;

public class Board {
    private int boardSize;
    Map<Integer,Ladder> ladderMap;
    Map<Integer,Snake> snakeMap;

    private Dice dice;

    public Board(Map<Integer,Ladder> ladderMap, Map<Integer,Snake> snakeMap,int boardSize,Dice dice)
    {
        this.ladderMap = ladderMap;
        this.snakeMap = snakeMap;
        this.boardSize = boardSize;
        this.dice = dice;
    }

    public Boolean hasSnake(int pos)
    {
        if(snakeMap.containsKey(pos))
            return true;
        return false;
    }

    public Boolean hasLadder(int pos)
    {
        if(ladderMap.containsKey(pos))
            return true;
        return false;
    }

    public int getSnakeTail(int pos)
    {
        int tail = -1;
        if(snakeMap.containsKey(pos))
        {
            Snake snake = snakeMap.get(pos);
            tail = snake.getTail();
        }
        return tail;
    }

    public int getLadderStart(int pos)
    {
        int end = -1;
        if(ladderMap.containsKey(pos))
        {
            Ladder ladder = ladderMap.get(pos);
            end = ladder.getEnd();
        }
        return end;
    }

    public int rollDice()
    {
        return dice.rollDice();
    }

    public int getBoardSize()
    {
        return this.boardSize;
    }

}
