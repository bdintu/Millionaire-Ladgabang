package ml.place;

import ml.player.Player;

public class Place {

    private final int amount_level = 3;
    private final double price_take_over = 0.6;

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

    public boolean canPayToll(Player player) {
        return player.getMoney().checkMoney(toll[level]);
    }

    public void payToll(Player player) {
        player.getMoney().addMoney(toll[level]);
    }

    public double getToll() {
        return toll[level];
    }

    public boolean canBuyPlace(Player player) {
        return player.getMoney().checkMoney(price[level]);
    }

    public void buyPlace(Player player) {
        setOwner(player);
        player.getMoney().addMoney(price[level]);
        level++;
    }

    public double getPrice() {
        return price[level];
    }

    public boolean canTakeOver(Player player) {
        return player.getMoney().checkMoney(price[level] * price_take_over);
    }

    public void TakeOver(Player player) {
        setOwner(player);
        player.getMoney().addMoney(price[level] * price_take_over);
    }

    public double getPriceTakeOver() {
        return price[level] * price_take_over;
    }

    public boolean canBuild() {
        return can_build;
    }

    public String getName() {
        return name;
    }

    public boolean isMaxLevel() {
        return level == (amount_level - 1);
    }

    public int getLevel() {
        return level;
    }

    public void setOwner(Player player) {
        this.owner = player.getId();
    }

    public boolean isOwner(Player player) {
        return owner == player.getId();
    }

    public boolean haveOwner() {
        return owner == -1;
    }

    public int getOwner() {
        return owner;
    }

}
