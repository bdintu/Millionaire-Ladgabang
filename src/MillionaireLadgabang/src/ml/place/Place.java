package ml.place;

import ml.player.Player;

public class Place {
    
    public static int amount_level = 3;
    
    int id;
    String name;
    int[] price;
    int[] buyed;
    Player player;
    
    public Place(int id, String name){
        this.id = id;
        this.name = name;
        this.price = new int[amount_level];
        this.buyed = new int[amount_level];
    }
    
    public void buyPlace(Player player){
        //if(Player.money)
    }
    
    public boolean isOwner(Player player){
        return this.player.getHash() == player.getHash();
    }
}