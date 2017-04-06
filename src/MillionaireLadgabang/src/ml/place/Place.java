package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;

    private String name;
    private int[] price;

    public Place(String name, int[] price) {
        this.name = name;
        this.price = price;
    }

    public void buyPlace(Player player) {
        //if(Player.money)
    }
}