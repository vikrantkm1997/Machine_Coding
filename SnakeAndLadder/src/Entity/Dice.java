package Entity;

import java.lang.Math;
import java.util.Random;

public class Dice {
    private int numOfDice;
    public Dice(int numOfDice)
    {
        this.numOfDice =  numOfDice;
    }

    int rollDice()
    {
        Random random = new Random();
        return 1 + random.nextInt(6);
    }
}
