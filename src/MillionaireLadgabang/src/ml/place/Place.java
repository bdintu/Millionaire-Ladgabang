package ml.place;

import ml.player.Player;

public class Place {

    public final int amount_level = 4;
    private final double price_take_over = 0.6;

    private String name;
    private boolean can_build;
    private int owner;
    private int current_level;
    private double[] toll;
    private double[] price;

    public Place(String name, boolean can_build, double[] toll, double[] price) {
        this.name = name;
        this.can_build = can_build;
        this.owner = -1;
        this.current_level = 0;
        this.toll = toll;
        this.price = price;
    }

    public void setToll(int i, double amount) {
        this.toll[i] = amount;
    }

    public boolean canPayToll(Player player) {
        return player.getMoney().checkMoney(toll[current_level]);
    }

    public void payToll(Player player) {
        player.getMoney().addMoney(toll[current_level]);
    }

    public double getToll() {
        return toll[current_level];
    }

    public boolean canBuyPlace(Player player) {
        return player.getMoney().checkMoney(price[current_level]);
    }

    public boolean canBuyPlace(Player player, int level) {
        return player.getMoney().checkMoney(price[level]);
    }

    public void buyPlace(Player player) {
        setOwner(player);
        player.getMoney().addMoney(price[current_level]);
        ++current_level;
    }

    public void buyPlace(Player player, int level) {
        setOwner(player);
        player.getMoney().addMoney(price[level]);
        this.current_level = level;
    }

    public double getPrice() {
        return price[current_level];
    }

    public double getPrice(int level) {
        return price[level];
    }

    public boolean canTakeOver(Player player) {
        return player.getMoney().checkMoney(price[current_level] * price_take_over);
    }

    public void TakeOver(Player player) {
        setOwner(player);
        player.getMoney().addMoney(price[current_level] * price_take_over);
    }

    public double getPriceTakeOver() {
        return price[current_level] * price_take_over;
    }

    public boolean canBuild() {
        return can_build;
    }

    public String getName() {
        return name;
    }

    public boolean isNotMaxLevel() {
        return current_level != (amount_level - 1);
    }

    public int getLevel() {
        return current_level;
    }

    public void setOwner(Player player) {
        this.owner = player.getId();
    }

    public boolean isOwner(Player player) {
        return owner == player.getId();
    }

    public boolean isNotOwner(Player player) {
        return owner != player.getId();
    }

    public boolean haveOwner() {
        return owner != -1;
    }

    public boolean haveNotOwner() {
        return owner == -1;
    }

    public int getOwner() {
        return owner;
    }
}
