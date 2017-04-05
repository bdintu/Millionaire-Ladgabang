package ml.card;

import ml.player.Player;

public class Loki extends Card {

    private int amount_money;

    public Loki(int id, String name, String detail, int amount_money) {
        super(id, name, detail);
        this.amount_money = amount_money;
    }

    public void AddMoney(Player player) {
        player.getMoney().addMoney(amount_money);
    }

}
