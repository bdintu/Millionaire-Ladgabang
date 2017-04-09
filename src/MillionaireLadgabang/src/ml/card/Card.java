package ml.card;

import ml.player.Player;

public class Card {

    private String name;
    private String detail;
    
    private double amount_money;
    private int pos_place;

    public Card(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public double getMoney() {
        return amount_money;
    }

    public void setMoney(double amount_money) {
        this.amount_money = amount_money;
    }

    public int getPos() {
        return pos_place;
    }

    public void setPos(int pos_place) {
        this.pos_place = pos_place;
    }
}
