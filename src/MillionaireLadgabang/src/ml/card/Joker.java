package ml.card;

import ml.player.Player;

public class Joker extends Card {

    private int amount_money;

    public Joker(String name, String detail, int amount_money) {
        super(name, detail);
        this.amount_money = amount_money;
    }

    public void AddMoney(Player player) {
        player.getMoney().addMoney(amount_money);
    }
}
