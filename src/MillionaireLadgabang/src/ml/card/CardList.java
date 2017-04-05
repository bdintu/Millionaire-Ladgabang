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

    private Joker[] joker;
    private Loki[] loki;

    public CardList() throws Exception {
        joker = new Joker[amount_card_per_group];
        loki = new Loki[amount_card_per_group];
        genCard();
    }

    public Card getCard(int index_group, int index_card) {

        switch (index_group) {
            case 0:
                return joker[index_group];
                
            case amount_card_per_group:
                return loki[index_card];
                
        }
        return null;
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
                        joker[i] = new Joker(Integer.parseInt(list.get(i).get(0).toString()), list.get(i).get(1).toString(), list.get(i).get(2).toString(), Integer.parseInt(list.get(i).get(3).toString()));
                        break;
                    case amount_card_per_group:
                        loki[i] = new Loki(Integer.parseInt(list.get(i).get(0).toString()), list.get(i).get(1).toString(), list.get(i).get(2).toString(), Integer.parseInt(list.get(i).get(3).toString()));
                        break;
                }
            }
        }
    }
}
