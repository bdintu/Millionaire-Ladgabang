package ml.player;

import java.security.NoSuchAlgorithmException;

public class PlayerList {

    private int amount_player;
    private Player[] player;

    public PlayerList(String[] name) throws NoSuchAlgorithmException {
        this.amount_player = name.length;
        this.player = new Player[2];
        createPlayer(name);
    }

    private void createPlayer(String[] name) throws NoSuchAlgorithmException {
        for (int i = 0; i < amount_player; ++i) {
            player[i] = new Player(name[i]);
        }
    }

    public Player getPlayer(int i) {
        if (i < amount_player) {
            return player[i];
        }
        return null;
    }
}
