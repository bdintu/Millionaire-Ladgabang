/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ml.dice;

/**
 *
 * @author Flim
 */
public class EvenOdd extends Dice {

    private boolean select_even;

    public EvenOdd() {
        this.select_even = false;
    }

    public void randomHightLow() {
        while (true) {
            randomDice();
            sumPoints();
            if (select_even == true && super.getPoints()%2==0) {
                return;
            } else if (select_even == false && super.getPoints()%2==1) {
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
        return points;
    }
}
