package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;

    private String name;
    private int[] price;
    private int[] buyed;

    public Place(String name) {
        this.name = name;
        this.price = new int[amount_level];
        this.buyed = new int[amount_level];
    }

    public void buyPlace(Player player) {
        //if(Player.money)
    }

    public boolean isOwner(Player player) {
        return this.player.getHash() == player.getHash();
    }
}
