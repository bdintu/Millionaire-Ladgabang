package ml.card;

import ml.Util;

public class Card {
    
    public static int amount_card = 10;
    public static Card[] card;
    
    private int id;
    private String name;
    private String detail;

    public static void main(){
        card = new Card[amount_card];
    }

    public Card(int id, String name, String detail){
        this.id = id;
        this.name = name;
        this.detail = detail;
    }
    
    public int getRandomIndexCard(){
        return Util.randomInt(0,amount_card);
    }
}