package ml.dice;

import ml.Util;

public abstract class Dice {

    protected int amount_dice = 1;
    protected int amount_side = 6;

    protected int[] points_dice;
    protected int sum;

    public Dice(){
        points_dice = new int[amount_dice];
        sum = 0;
    }

    public void randomPoint(){
        for(int i=0; i<amount_dice; ++i){
            points_dice[i] = Util.randomInt(1, amount_side);
        }
    }

    public void sumPoints(){
        sum = 0;
        for(int i=0; i<amount_dice; ++i){
            sum += points_dice[i];
        }
    }

    public int getPoints(){
        return sum;
    }
}