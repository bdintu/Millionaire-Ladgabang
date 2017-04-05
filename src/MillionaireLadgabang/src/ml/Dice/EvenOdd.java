package ml.dice;

public class EvenOdd extends Dice {
    public boolean isEven() {
        int even = 0;
        for (int i = 0; i < amount_dice; ++i) {
            if (points_dice[i] % 2 == 0) {
                even++;
            }
        }
        return even == amount_dice;
    }

    public boolean isOdd() {
        int odd = 0;
        for (int i = 0; i < amount_dice; ++i) {
            if (points_dice[i] % 2 == 1) {
                odd++;
            }
        }
        return odd == amount_dice;
    }
}