package ml.card;

import ml.player.Player;

public class Assist extends Card {

    private int amount_money;
    private int point_place;

    public Assist(String name, String detail, int amount_money, int point_place) {
        super(name, detail);
        this.amount_money = amount_money;
        this.point_place = point_place;
    }

    @Override
    public void AddMoney(Player player) {
        player.getMoney().addMoney(amount_money);
    }

    @Override
    public void MovePlanc(Player player) {

    }
}
