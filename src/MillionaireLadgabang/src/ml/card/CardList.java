package ml.card;

import java.util.ArrayList;
import ml.Util;

public class CardList {

    private final int amount_group = 2;
    private final int amount_card_per_group = 5;

    private ArrayList<Assist> assist;
    private ArrayList<Libel> libel;

    public CardList() {
        assist = new ArrayList();
        libel = new ArrayList();
        createCard();
    }

    public Card getCard(int index_group, int index_card) {
        switch (index_group) {
            case 0:
                return assist.get(index_card);
            case 1:
                return libel.get(index_card);
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
        assist.add( new Assist("fdsf", "dfdsff", 200, 5) );
        libel.add( new Libel("fdsf", "dfdsff", 200, 6) );
    }
    
    public int size() {
        return amount_group;
    }
}