package ml.card;

import java.util.ArrayList;
import ml.Util;

public class CardList {

    private final int amount_group = 2;
    private final int amount_card_per_group = 5;

    private ArrayList<Card> joker;
    private ArrayList<Card> loki;

    public CardList() {
        joker = new ArrayList();
        loki = new ArrayList();
        createCard();
    }

    public Card getCard(int index_group, int index_card) {
        switch (index_group) {
            case 0:
                return joker.get(index_card);
            case 1:
                return loki.get(index_card);
            default:
                return null;
        }
    }

    public Card RandomCard() {
        int ran_group = Util.randomInt(0, amount_group);
        int ran_card = Util.randomInt(0, amount_card_per_group);
        return getCard(ran_group, ran_card);
    }

    private void createCard() {
        joker.add( new Joker("fdsf", "dfdsff", 200) );
        loki.add( new Loki("fdsf", "dfdsff", 200) );
    }
    
    public int size() {
        return amount_group;
    }
}