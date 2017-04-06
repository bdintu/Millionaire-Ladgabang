package ml;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import ml.card.CardList;
import ml.dice.Dice;
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
        
        for(int i=0; i<player.size(); ++i){
            player.getPlayer(i).getMoney().startMoney();
        }

        System.out.println("player 1 name : " + player.getPlayer(1).getName());
        System.out.println("player 1 money : " + player.getPlayer(1).getMoney().getMoney());
        System.out.println();

        /**
         * Dice
         */
        Standate dice_std = new Standate();
        System.out.println("Dice random : " + dice_std.getPoint());

        HightLow dice_hightlow = new HightLow();
        System.out.println("Dice Hight/Low : " + dice_hightlow.isHighLow(true));
        System.out.println();

        /**
         * Card
         */
        CardList card = new CardList();
        System.out.println(card.getCard(0, 0).getDetail());
    }
}
