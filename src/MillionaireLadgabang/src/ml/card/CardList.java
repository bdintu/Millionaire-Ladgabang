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
        card.add(new SetPos("ไปจุดเริ่มต้น", "ไปยังกลับจุดเริ่ต้น", true, 0));
        card.add(new MovePos("เดินไป 5 ช่อง", "เดินไป 5 ช่อง", true, 5));
        card.add(new PriceToll("ฟรีค่าผ่านทาง", "", false, 1));
        card.add(new PriceToll("เสียค่าผ่านทาง 50%", "", false, 0.5));
    }

    public int size() {
        return amount_card;
    }
}
