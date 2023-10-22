import Entity.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Player1",1);
        Player player2 = new Player("Player2",1);
        List<Player> players = Arrays.asList(player1,player2);
        Dice dice = new Dice(1);
//        List<Snake> snakeMap = Arrays.asList(new Snake(67,15),new Snake(56,28),new Snake(14,9));
        Map <Integer,Snake> snakeMap = new HashMap<>();
        snakeMap.put(67,new Snake(67,15));
        snakeMap.put(56,new Snake(56,28));
        snakeMap.put(14,new Snake(14,9));
//      //List<Ladder> ladderMap = Arrays.asList(new Ladder(4,34),new Ladder(12,18),new Ladder(78,95));
        Map<Integer,Ladder> ladderMap = new HashMap<>();
        ladderMap.put(4,new Ladder(4,34));
        ladderMap.put(12,new Ladder(12,18));
        ladderMap.put(78,new Ladder(78,95));
        Board board= new Board(ladderMap,snakeMap,100,dice);
//        System.out.println(player2.getPlayerName() +" "+ player2.getPlayerPos());
//        System.out.println(player1.getPlayerName() +" "+ player1.getPlayerPos());
        Game game = new Game(board,players);
        game.playGame();
    }
}