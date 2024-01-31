package src.model;

import java.util.Random;

public class Dice {
    private int maxInt;

    Random rand;

    private Dice() {
        rand = new Random();
        maxInt = 6;
    }

    static Dice dice;
    public static  Dice getInstance() {
        if(dice == null) {
            synchronized (Dice.class) {
                if(dice == null)
                    dice = new Dice();
            }
        }
        return  dice;
    }

    /* This method is used to configure the dice */
    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public int rollDice() {
        return (Math.abs(rand.nextInt()) % maxInt) + 1;
    }
}
