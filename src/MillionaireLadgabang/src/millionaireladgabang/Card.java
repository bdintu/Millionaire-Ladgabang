package millionaireladgabang;

public class Card {
    
    private int id;
    private String name;
    private String detail;
    private int deposit;
    private int withdraw;
    private int move;

    public Card(int id, String name, String detail){
        this.id = id;
        this.name = name;
        this.detail = detail;
    }
}