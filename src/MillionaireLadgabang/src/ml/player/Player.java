package ml.player;

import java.security.NoSuchAlgorithmException;
import ml.Util;

public class Player {

    private int id;
    private String name;
    private Money money;

    public Player(int id, String name) throws NoSuchAlgorithmException {
        this.name = name;
        this.id = id;
        this.money = new Money();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Money getMoney() {
        return money;
    }
}