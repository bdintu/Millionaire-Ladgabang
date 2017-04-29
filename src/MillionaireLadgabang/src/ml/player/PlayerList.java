package ml.player;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PlayerList {

    private final int max_turn = 40;

    private int amount_player;
    private int turn_player;
    private int waitTurn;
    private int current_turn;
    private ArrayList<Player> player;

    public PlayerList(String[] name) throws NoSuchAlgorithmException {
        this.amount_player = name.length;
        this.turn_player = 0;
        this.waitTurn = 0;
        this.current_turn = 0;
        this.player = new ArrayList();
        createPlayer(name);
    }

    public void clear() {
        for (int i = 0; i < amount_player; ++i) {
            player.get(i).clear();
        }
    }

    private void createPlayer(String[] name) throws NoSuchAlgorithmException {
        for (int i = 0; i < amount_player; ++i) {
            player.add(new Player(i, name[i]));
        }
    }

    public Player getPlayer(int i) {
        return player.get(i);
    }

    public void nextTurn() {
        if (waitTurn == 0) {
            this.turn_player = (turn_player + 1) % amount_player;
        } else {
            --waitTurn;
        }
        ++current_turn;
    }

    public void setWaitTurn() {
        this.waitTurn = 3;
        this.turn_player = (turn_player + 1) % amount_player;
    }

    public int getTurn() {
        return turn_player;
    }

    public int getMaxTurn() {
        return max_turn;
    }

    public int getCurrentTurn() {
        return current_turn;
    }

    public int size() {
        return amount_player;
    }
}
