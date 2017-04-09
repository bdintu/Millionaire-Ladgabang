package ml.dice;

import ml.Util;

public abstract class Dice {

    protected final int amount_dice = 2;
    protected final int amount_side = 6;

    protected int[] points_each_dice;
    protected int points;

    public Dice() {
        points_each_dice = new int[amount_dice];
        points = 0;
    }

    public void randomDice() {
        for (int i = 0; i < amount_dice; ++i) {
            points_each_dice[i] = Util.randomInt(1, amount_side);
        }
    }

    protected void sumPoints() {
        points = 0;
        for (int i = 0; i < amount_dice; ++i) {
            points += points_each_dice[i];
        }
    }

    public int getPoints() {
        return points;
    }
    
    public int[] getDice(){
        return points_each_dice;
    }
    
    public int size(){
        return amount_dice;
    }
 }
