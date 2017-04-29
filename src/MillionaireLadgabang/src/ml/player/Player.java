package ml.player;

import java.util.ArrayList;
import ml.card.Card;
import static ml.place.PlaceList.amount_place;

public class Player {

    private int id;
    private int pos;
    private String name;
    private boolean lose;
    private Money money;
    private ArrayList<Card> card;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        clear();
    }

    public void clear() {
        this.lose = false;
        this.money = new Money();
        this.card = new ArrayList();
    }

    public void addCard(Card card) {
        this.card.add(card);
    }

    public Card getCard(int i) {
        return card.get(i);
    }

    public int getSizeCard() {
        return card.size();
    }

    private void addMoneyPerRound(int walk, Player player) {
        if (pos + walk > amount_place) {
            player.getMoney().addMoneyPerRound();
        }
    }

    public void setPos(int pos, Player player) {
        addMoneyPerRound(pos, player);
        this.pos = pos;
    }

    public void movePos(int walk, Player player) {
        addMoneyPerRound(walk, player);
        this.pos = (pos + walk) % amount_place;
    }

    public void setLose() {
        this.lose = true;
    }

    public boolean isLose() {
        return lose;
    }

    public int getPos() {
        return pos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getMoney() {
        return money;
    }
}
