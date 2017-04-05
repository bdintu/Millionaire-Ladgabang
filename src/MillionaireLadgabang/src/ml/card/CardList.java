package ml.card;

import ml.Util;

public class CardList {
    
    
    public static int amount_group = 2;
    public static int amount_joker = 5;
    public static int amount_loki = 5;
    
    private Card[][] card = new Card[amount_group][];


    public CardList() {
        card[0] = new Joker[5];
        card[1] = new Loki[5];
        genCard();
    }
    
    public Card getCard(int index_group, int index_card) {
        return card[index_group][index_card];
    }

    public Card RandomCard(){
        int ran_group = Util.randomInt(0, amount_group);
        int ran_card = Util.randomInt(0, amount_group);
        
        return getCard(ran_group, ran_card);
    }
    
    private void genCard(){
        card[0][0] = new Joker(0,"asds", "asasdsd",200);
        card[0][4] = new Joker(0,"asds", "asasdsd",200);
        card[1][0] = new Loki(0,"asds", "asasdsd",300);
        card[1][4] = new Loki(0,"asds", "asasdsd",200);
    }
}