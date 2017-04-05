package ml.card;

import ml.player.Player;

public class Joker extends Card {

    private int amount_money;

    public Joker(int id, String name, String detail, int amount_money) {
        super(id, name, detail);
        this.amount_money = amount_money;
    }

    public void DelMoney(Player player) {
        player.getMoney().delMoney(amount_money);
    }

}
