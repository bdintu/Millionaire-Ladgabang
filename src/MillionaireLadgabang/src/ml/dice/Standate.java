package ml.dice;

public class Standate extends Dice {

    public Standate() {
    }

    public int getPoint() {
        randomDice();
        return getPoints();
    }
}
