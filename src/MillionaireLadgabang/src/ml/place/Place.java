package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;

    private String name;
    private int owner;
    private int level;
    private double fine;
    private double[] price;

    public Place(String name, double fine, double[] price) {
        this.name = name;
        this.price = price;
        this.owner = -1;
    }
    
    public boolean checkOwner(Player player){
        return owner==player.getId();
    }

    public boolean checkBuyPlace(Player player) {
        if (player.getMoney().checkMoney(price[level])) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkMaxLevel() {
        return amount_level == level;
    }

    public void buyPlace(Player player) {
        this.owner = player.getId();
        player.getMoney().addMoney(price[level]);
        level++;
    }

    public String getName() {
        return name;
    }

    public int getOwner() {
        return owner;
    }
}