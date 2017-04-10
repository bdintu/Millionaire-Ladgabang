package ml.card;

import java.util.ArrayList;
import ml.Util;

public class CardList {

    private final int amount_card = 10;

    private ArrayList<Card> card;

    public CardList() {
        card = new ArrayList();
        createCard();
    }

    public Card getCard(int index_card) {
        return card.get(index_card);
    }

    public Card RandomCard() {
        int random_int = Util.randomInt(0, amount_card);
        return getCard(random_int);
    }

    private void createCard() {
        card.add(new Card("ปรับตัง 100k", "เสียค่า 100k"));
        card.get(0).setMoney(1e6);

        card.add(new Card("ไปจุดเริ่มต้น", "ไปยังกลับจุดเริ่ต้น"));
        card.get(1).setPos(0);

        card.add(new Card("เดินไป 5 ช่อง", "เดินไป 5 ช่อง"));
        card.get(2).setPos(0);
    }

    public int size() {
        return amount_card;
    }
}
