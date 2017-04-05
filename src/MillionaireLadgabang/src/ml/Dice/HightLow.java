package ml.dice;

public class HightLow extends Dice {

    private int bound_hightlow = (super.amount_dice * super.amount_side) / 2;

    private boolean take_hight;
    private boolean is_hight;

    public HightLow() {
        this.take_hight = false;
        this.is_hight = false;
    }

    public boolean isHighLow(boolean take_hight) {
        this.setHight(take_hight);
        super.randomPoint();
        super.sumPoints();
        return this.isHight();
    }

    public void setHight(boolean take_hight) {
        this.take_hight = take_hight;
    }

    public boolean isHight() {
        return super.sum > this.bound_hightlow;
    }
}
