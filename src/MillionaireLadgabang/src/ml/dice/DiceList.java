package ml.dice;

import ml.player.Player;
import ml.player.PlayerList;

public class DiceList {

    private Dice dice[][];

    public DiceList(PlayerList player) {
        dice = new Dice[player.size()][3];
        createDice(player);
    }

    private void createDice(PlayerList player) {
        for (int i = 0; i < player.size(); ++i) {
            dice[i][0] = new Standate();
            dice[i][1] = new EvenOdd();
            dice[i][2] = new HightLow();
        }
    }

    public Standate getStd(Player player) {
        return (Standate) dice[player.getId()][0];
    }

    public EvenOdd getEvenOdd(Player player) {
        return (EvenOdd) dice[player.getId()][1];
    }

    public HightLow getHightLow(Player player) {
        return (HightLow) dice[player.getId()][2];
    }
}