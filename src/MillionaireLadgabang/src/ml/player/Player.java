package ml.player;

import java.security.NoSuchAlgorithmException;
import ml.Util;

public class Player {

    private String hash;
    private String name;
    private Money money;

    public Player(String name) throws NoSuchAlgorithmException {
        this.name = name;
        this.hash = Util.hash(name);
        this.money = new Money();
    }

    public String getName() {
        return name;
    }

    public String getHash() {
        return hash;
    }

    public Money getMoney() {
        return money;
    }
}