package ml.dice;

public class HightLow extends Dice {

    private final int bound_hightlow = (super.amount_dice * super.amount_side) / 2;

    private boolean select_hight;

    public HightLow() {
        this.select_hight = false;
    }

    public void randomHightLow() {
        while (true) {
            randomDice();
            sumPoints();
            if (select_hight == true && super.getPoints() > bound_hightlow) {
                return;
            } else if (select_hight == false && super.getPoints() <= bound_hightlow) {
                return;
            }
        }
    }

    public void setHight() {
        this.select_hight = true;
    }
    
    public void setLow() {
        this.select_hight = false;
    }

    public int getPoints() {
        randomHightLow();
        return points;
    }
}