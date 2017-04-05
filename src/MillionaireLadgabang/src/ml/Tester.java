package ml;

import java.security.NoSuchAlgorithmException;
import ml.player.PlayerList;

public class Tester {

    public static void main(String[] argv) throws NoSuchAlgorithmException {

        String[] name = {"E Ka", "Duran"};
        PlayerList player = new PlayerList(name);

        player.getPlayer(0).getMoney().startMoney();
        player.getPlayer(1).getMoney().startMoney();

        System.out.println(  player.getPlayer(1).getName()    );
        System.out.println(  player.getPlayer(1).getMoney().getAmount()  );
        System.out.println(  "555"  );

    }
}