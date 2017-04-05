package ml.dice;

public class Standate extends Dice {

    public void Standate() {

    }

    public int getStandate() {
        super.randomPoint();
        super.sumPoints();
        return super.getPoints();
    }
}
