package ml.dice;

import ml.Util;
import ml.player.Player;

public class Paoyingshub {

    private final int max_round = 3;
    //private final int amount_play_game = (int) -5e5;
    private final int money[] = {(int) 1e6, (int) 4e6, (int) 10e6};
    private final String str[] = {"scissor", "rock", "paper", "exit"};

    private int random_clutter;
    private int tmp_money;
    private int iter;

    private void begin() {
        this.random_clutter = Util.randomInt(0, max_round + 1);
        this.tmp_money = 0;
        this.iter = 0;
    }

    public void reSet() {
        this.tmp_money = 0;
        this.iter = 0;
    }

    public boolean play(Player player, int choice) {

        if (iter == 0) {
            //player.getMoney().addMoney(amount_play_game);
            begin();
        }

        if (random_clutter > 0) {

            if (true) {
                this.tmp_money += money[iter];
                ++iter;
                return true;
            }
        } else {
            player.getMoney().addMoney(tmp_money);
            return false;
        }

        return false;
    }
}