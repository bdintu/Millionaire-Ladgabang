package ml.card;

import ml.Util;

public class CardList {

    public static final int amount_group = 2;
    public static final int amount_card_per_group = 5;

    private Joker[] joker;
    private Loki[] loki;

    public CardList(){
        joker = new Joker[amount_card_per_group];
        loki = new Loki[amount_card_per_group];
        genCard();
    }

    public Joker getCard(int index_group, int index_card) {

        switch (index_group) {
            case 0:
                return joker[index_card];
            case 1:
                //return loki[index_card];
            default:
                return null;
        }
    }

    public Card RandomCard() {
        int ran_group = Util.randomInt(0, amount_group);
        int ran_card = Util.randomInt(0, amount_group);

        return getCard(ran_group, ran_card);
    }

    private void genCard(){
        joker[0] = new Joker(0,"fdsf","dfdsff",200);
    }
}