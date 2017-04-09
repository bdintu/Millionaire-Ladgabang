package ml.player;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PlayerList {

    private int amount_player;
    private int trun_player;
    private ArrayList<Player> player;

    public PlayerList(String[] name) throws NoSuchAlgorithmException {
        this.amount_player = name.length;
        this.trun_player = 0;
        this.player = new ArrayList();
        createPlayer(name);
    }

    private void createPlayer(String[] name) throws NoSuchAlgorithmException {
        for (int i = 0; i < amount_player; ++i) {
            player.add(new Player(i, name[i]));
        }
    }

    public Player getPlayer(int i) {
        return player.get(i);
    }
    
    public void nextTrun() {
        this.trun_player = (trun_player+1) % amount_player;
    }
    
    public int getTrun() {
        return trun_player;
    }
    
    public int size(){
        return amount_player;
    }
}