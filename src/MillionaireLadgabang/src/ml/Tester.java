package ml;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import ml.card.CardList;

import ml.dice.HightLow;
import ml.dice.Paoyingshub;
import ml.dice.Standate;
import ml.player.PlayerList;

public class Tester {

    public static void main(String[] argv) throws NoSuchAlgorithmException, IOException, Exception {

        //ลบด้วย อันนี้ใช้เทส เฉยๆ
        Scanner sn = new Scanner(System.in);

        // สร้างชื่อผู้เล่น โดยใส่ใน อาเรย์ name เลย ใส่กี่คนก็ว่าไป ได้หมด
        String[] name = {"E Ka", "Durian"};
        
        // อันนี้ต้องกำหนดลำดับว่าใครเล่นก่อนหลัง ทำใน String[] name ให้เรียบร้อย
        // เดี่ยวมาทำ
        
        // แล้วเอามายัดในนี้
        PlayerList player = new PlayerList(name);

        // สร้างกระดานมาอันหนึ่ง
        Bord bord = new Bord();
        // อันนี้มันจะกำหนด เงินเริ่มต้น ตำแหน่งเริ่มต้น ลำดับของตาเดิน
        bord.begin(player);
        
        // สร้างลูกเต๋าปกติ
        Standate dice_std = new Standate();
        int walk; 
        
        // ลูปเกมส์ละ
        while(!bord.isEndGame(player)){
            
            // สุ่มเต๋าปกติ
            walk = dice_std.getPoint();

            // เดินไป walk ช่อง
            player.getPlayer( player.getTrun() ).setPos(walk);
            
            // จ่ายค่าปรับ
            
            // ใช้การ์ด
            
            // ซื้อบ้าน
            
            // เชิญ เทรินต่อไป
            player.nextTrun();
        }
        
        // อันนี้ลองพิมพ์ชื่อคน เงิน กะตำแหน่งมาดูเฉยๆ
        for (int i = 0; i < player.size(); ++i) {
            System.out.println("Player " + i);
            // ที่แม่งยาวเพราะ ArrayList ล้วนๆ ไม่ได้เกิดจากการออกแบบคลาสไม่ดีเลยย
            System.out.println("\tname : " + player.getPlayer(i).getName());
            System.out.println("\tmoney : " + player.getPlayer(i).getMoney().getMoney());
            System.out.println("\tpos : " + player.getPlayer(i).getPos());
        }

        // อันนี้ลองเทสลูกเต๋า
        
        /**
         * Dice
        
        HightLow dice_hightlow = new HightLow();
        
        boolean bool_select = sn.nextBoolean();
        
        dice_hightlow.isHighLow(bool_select);

        HightLow dice_hightlow = new HightLow();
        System.out.println("Dice Hight/Low : " + dice_hightlow.isHighLow(true));
        System.out.println();

        Paoyingshub paoyingshub = new Paoyingshub();
        int int_select = sn.nextInt();
        while (paoyingshub.play(player.getPlayer(1), int_select)) {
            System.out.println("Dice Chalenge game : You win");
        }
        paoyingshub.reSet();
        */

        /**
         * Card
         */
        CardList card = new CardList();
        System.out.println(card.getCard(0, 0).getDetail());
        
        /**
         * Buy Place
         */
        //PlaceList place = new PlaceList();
        //p
    }
}
