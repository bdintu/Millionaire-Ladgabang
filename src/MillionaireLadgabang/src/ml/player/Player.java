package ml.player;

import java.util.ArrayList;
import ml.card.Card;
import static ml.place.PlaceList.amount_place;

public class Player {

    private int id;
    private int pos;
    private String name;
    private Money money;
    private ArrayList<Card> card;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.money = new Money();
        this.card = new ArrayList();
    }

    public void addCard(Card card) {
        this.card.add(card);
    }

    public boolean isLose() {
        return !money.isMoney();
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void addPos(int walk, Player player) {
        if(pos + walk > amount_place){
            player.getMoney().addMoneyPerRound();
        }
        this.pos = (pos + walk) % amount_place;
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
