package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;

    private String name;
    private double[] price;
    private int level;
    private int owner;

    public Place(String name, double[] price) {
        this.name = name;
        this.price = price;
    }

    public boolean checkBuyPlace(Player player) {
        if (player.getMoney().checkMoney(price[level])) {
            return true;
        } else {
            return false;
        }
    }

    public void buyPlace(Player player) {
        this.owner = player.getId();
        player.getMoney().addMoney(price[level]);
    }
}