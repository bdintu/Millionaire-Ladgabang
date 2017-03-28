package millionaireladgabang;

public class Player {

    public static int max_player = 2;

    int id;
    String name;
    Money money;
    
    public Player(int id, String name){
        this.id = id;
        this.name = name;
        money = new Money();
    }
}