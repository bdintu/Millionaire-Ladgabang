package ml.dice;

import ml.Util;

public abstract class Dice {

<<<<<<< HEAD
    protected final int amount_dice = 2;
    protected final int amount_side = 6;
=======
    protected int amount_dice = 2;
    protected int amount_side = 6;
>>>>>>> origin/master

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

    private void sumPoints() {
        points = 0;
        for (int i = 0; i < amount_dice; ++i) {
            points += points_each_dice[i];
        }
    }

    public int getPoints() {
        sumPoints();
        return points;
    }
}
