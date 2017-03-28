package millionaireladgabang;

import java.security.NoSuchAlgorithmException;

public class Player {

    public static int max_player = 2;

    private String hash;
    private String name;
    private Money money;

    public Player(String name) throws NoSuchAlgorithmException {
        this.name = name;
        hash = Util.hash(name);
        money = new Money();
    }

    public String getName() {
        return name;
    }

    public String getHash() {
        return hash;
    }
}