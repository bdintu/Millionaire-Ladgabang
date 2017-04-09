package ml.player;

public class Player {

    private int id;
    private String name;
    private Money money;

    public Player(int id, String name){
        this.name = name;
        this.id = id;
        this.money = new Money();
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