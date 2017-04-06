package ml.card;

import ml.player.Player;

public abstract class Card {

    private String name;
    private String detail;

    public Card(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public abstract void AddMoney(Player player);
    public abstract void MovePlanc(Player player);

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
