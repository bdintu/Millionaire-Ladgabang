package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;

    private String name;
    private boolean can_build;
    private int owner;
    private int level;
    private double[] toll;
    private double[] price;

    public Place(String name, boolean can_build, double[] toll, double[] price) {
        this.name = name;
        this.can_build = can_build;
        this.owner = -1;
        this.level = 0;
        this.toll = toll;
        this.price = price;
    }

    public boolean canPayToll(Player player){
        if (player.getMoney().checkMoney(toll[level])) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canBuyPlace(Player player) {
        if (player.getMoney().checkMoney(price[level])) {
            return true;
        } else {
            return false;
        }
    }

    public void buyPlace(Player player) {
        setOwner(player);
        player.getMoney().addMoney(price[level]);
        level++;
    }

    public boolean canBuild() {
        return can_build;
    }

    public String getName() {
        return name;
    }
    
    public boolean isMaxLevel() {
        return amount_level == level;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setOwner(Player player){
        this.owner = player.getId();
    }

    public boolean isOwner(Player player){
        return owner==player.getId();
    }

    public int getOwner() {
        return owner;
    }
}