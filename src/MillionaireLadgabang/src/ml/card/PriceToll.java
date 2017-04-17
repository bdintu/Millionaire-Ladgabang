package ml.card;

import ml.place.Place;
import ml.player.Player;

public class PriceToll extends Card {

    private double discount_percent;

    public PriceToll(String name, String detail, boolean now, double discount_percent) {
        super(name, detail, now);
        this.discount_percent = discount_percent;
    }

    public void effect(Player player, Place place) {
        player.getMoney().addMoney(place.getPrice() * discount_percent);
    }
}
