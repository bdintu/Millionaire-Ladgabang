package ml;

import ml.Util;
import ml.player.Player;
import ml.player.Player;

public class Paoyingshub {

    private final int max_round = 3;
    //private final int amount_play_game = (int) -5e5;
    private final int money[] = {(int) 1e6, (int) 4e6, (int) 10e6};
    private final String str[] = {"scissor", "rock", "paper", "exit"};

    private int random_round;
    private int tmp_money;
    private int round;

    private void begin() {
        this.random_round = Util.randomInt(0, max_round);
        this.tmp_money = 0;
        this.round = 0;
    }

    public void reSet() {
        this.tmp_money = 0;
        this.round = 0;
    }

    public boolean play(Player player, int choice) {

        if (round == 0) {
            //player.getMoney().addMoney(amount_play_game);
            begin();
            System.out.println("random_number_win:" + random_round);
        }

        if (choice == 3) {
            player.getMoney().addMoney(tmp_money);
            return false;
        }

        if (random_round > 0) {
            this.tmp_money += money[round];
            ++round;
            --random_round;
            return true;
        } else {
            player.getMoney().addMoney(tmp_money);
            return false;
        }
    }

    public int getRandomRound() {
        return random_round;
    }
}
