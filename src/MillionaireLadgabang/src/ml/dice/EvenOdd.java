package ml.dice;

public class EvenOdd extends Dice {

    private final int max_limit = 3;

    private boolean select_even;

    public EvenOdd() {
        setLimit(max_limit);
        this.select_even = false;
    }

    public void randomHightLow() {
        while (true) {
            randomDice();
            sumPoints();
            if (select_even == true && super.getPoints() % 2 == 0) {
                return;
            } else if (select_even == false && super.getPoints() % 2 == 1) {
                return;
            }
        }
    }

    public void setEven() {
        this.select_even = true;
    }

    public void setOdd() {
        this.select_even = false;
    }

    public int getPoints() {
        randomHightLow();
        delLimit();
        return points;
    }
}
