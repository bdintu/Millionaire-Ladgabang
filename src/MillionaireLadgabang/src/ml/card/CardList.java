package ml.card;

public class CardList {
    
    public static int amount_group = 3;
    public static int amount_each_group = 5;
    
    private Joker[] joker;

    public CardList(Joker[] joker) {
        this.joker = new Joker[5];
    }
}
