package ml;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import ml.card.CardList;

import ml.dice.HightLow;
import ml.dice.Standate;
import ml.player.PlayerList;

public class Tester {

    public static void main(String[] argv) throws NoSuchAlgorithmException, IOException, Exception {

        /**
         * Player
         */
        String[] name = {"E Ka", "Duran"};
        PlayerList player = new PlayerList(name);

        player.getPlayer(0).getMoney().startMoney();
        player.getPlayer(1).getMoney().startMoney();

        System.out.println(  player.getPlayer(1).getName()    );
        System.out.println(  player.getPlayer(1).getMoney().getAmount()  );
        System.out.println(  "555"  );
        
        /**
         * Dice
         */
        Standate dice_std = new Standate();
        System.out.println(dice_std.getStandate());

        HightLow dice_hightlow = new HightLow();
        System.out.println(dice_hightlow.isHighLow(true));
        
        /**
         * Card
         */
        
        CardList card = new CardList();
        System.out.println(card.getCard(0,0).getDetail());
        
        
        

    }
}