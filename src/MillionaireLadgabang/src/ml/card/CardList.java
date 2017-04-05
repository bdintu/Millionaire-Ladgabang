package ml.card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static ml.CSVUtils.CSVUtils;
import ml.Util;

public class CardList {

    public static final int amount_group = 2;
    public static final int amount_card_per_group = 5;

    public static String file_name = "src/ml/card/card.csv";

    private Card[][] card = new Card[amount_group][];

    public CardList() throws IOException, Exception {
        card[0] = new Joker[5];
        card[1] = new Loki[5];
        genCard();
    }

    public Card getCard(int index_group, int index_card) {
        return card[index_group][index_card];
    }

    public Card RandomCard() {
        int ran_group = Util.randomInt(0, amount_group);
        int ran_card = Util.randomInt(0, amount_group);

        return getCard(ran_group, ran_card);
    }

    private void genCard() throws IOException, Exception {
        ArrayList<List> list = CSVUtils(file_name);
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < 3; ++j) {
                switch (i) {
                    case 0:
                        card[i] = new Joker(Integer.parseInt(list.get(i).get(0)), list.get(i).get(1), list.get(i).get(2), Integer.parseInt(list.get(i).get(3)));
                        break;
                    case amount_card_per_group:
                        card[i] = new Loki(Integer.parseInt(list.get(i).get(0)), list.get(i).get(1), list.get(i).get(2), Integer.parseInt(list.get(i).get(3)));
                        break;
                }
            }
        }
    }
}