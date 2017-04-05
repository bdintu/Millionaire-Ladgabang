package ml.card;

import ml.player.Player;

public class Joker extends Card {

    private int deposit;
    
    public Joker(int id, String name, String detail, int deposit){
        super(id, name, detail);
        this.deposit = deposit;
    }
    
    public void getDelMoney(Player player){
        player.getMoney().delMoney(deposit);
    }
    
}