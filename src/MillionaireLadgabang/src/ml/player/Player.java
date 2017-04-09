package ml.player;

public class Player {

    private int id;
    private int pos;
    private String name;
    private Money money;

    public Player(int id, String name){
        this.name = name;
        this.id = id;
        this.money = new Money();
    }
    
    public boolean isLose(){
        return !money.isMoney();
    }
    
    public void setPos(int pos){
        this.pos = pos;
    }
    
    public int getPos(){
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