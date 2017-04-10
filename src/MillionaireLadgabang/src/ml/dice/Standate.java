package ml.dice;

import ml.Util;

public class Standate extends Dice {

    public Standate() {

    }

    public int getPoints() {
        randomDice();
        sumPoints();
        return points;
    }
}
