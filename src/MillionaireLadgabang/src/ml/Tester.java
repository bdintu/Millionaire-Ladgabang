package ml;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import ml.card.CardList;

import ml.place.PlaceList;
import ml.player.PlayerList;

import ml.dice.EvenOdd;
import ml.dice.HightLow;
import ml.dice.Paoyingshub;
import ml.dice.Standate;

public class Tester {

    public static void main(String[] argv) throws NoSuchAlgorithmException, IOException, Exception {

        // ลบด้วย อันนี้ใช้เทส เฉยๆ
        Scanner sn = new Scanner(System.in);

        // สร้างชื่อผู้เล่น โดยใส่ใน อาเรย์ name เลย ใส่กี่คนก็ว่าไป ได้หมด
        System.out.println("ถ้าไม่ใช่ของตัวเอง ก็จ่ายค่าผ่านทาง");
        String[] name = {"E Ka", "Durian"};

        /**
         * อันนี้ต้องกำหนดลำดับว่าใครเล่นก่อนหลัง ทำใน String[] name
         * ให้เรียบร้อย เดี่ยวมาทำ ขีเกียจ
         */
        // เออ แล้วเอามายัดในนี้
        PlayerList player = new PlayerList(name);
        
        // อันนี้ลองพิมพ์ชื่อคน เงิน กะตำแหน่งมาดูเฉยๆ
        System.out.println("amount player : " + player.size());
        for (int i = 0; i < player.size(); ++i) {
            System.out.println("Player " + i);
            // ที่แม่งยาวเพราะ ArrayList ล้วนๆ ไม่ได้เกิดจากการออกแบบคลาสไม่ดีเลยย
            System.out.println("\tname : " + player.getPlayer(i).getName());
            System.out.println("\tmoney : " + player.getPlayer(i).getMoney().getMoney());
            System.out.println("\tpos : " + player.getPlayer(i).getPos());
        }

        // สร้างกระดานมาอันหนึ่ง
        Bord bord = new Bord();

        // อันนี้มันจะกำหนด เงินเริ่มต้น ตำแหน่งเริ่มต้น ลำดับของตาเดิน
        bord.begin(player);

        // สร้างการ์ดมาก่อนน
        CardList card = new CardList();

        // สร้างสถานที่ตามมาา
        PlaceList place = new PlaceList();

        // สร้างลูกเต๋าสุ่มปกติ 0-12
        Standate dice_std = new Standate();
        // สร้างลูกเต๋าสูงต่ำ
        HightLow dice_hightlow = new HightLow();
        // สร้างลูกเต๋าคู่คี่
        EvenOdd dice_evenodd = new EvenOdd();
        // สร้างเกมส์เป่ายิ่งฉุบ
        Paoyingshub paoyingshub = new Paoyingshub();

        // ลูปเกมส์ละ
        while (bord.haveContinueGame(player)) {

            // เช็คว่า turn ของใคร
            int turn = player.getTurn();
            System.out.println("ตาของผู้เล่นชื่อ : " + player.getPlayer(turn).getName());

            // สุ่มเต๋าปกติ 0-12
            int walk = dice_std.getPoints();
            System.out.println("ทอยลูกเต๋าได้เท่านี้แต้ม : " + walk);

            /**
             *
             * เดี่ยวมาทำ คู่คี่ สูงต่ำ
             *
             */
            // เดินไป walk ช่อง
            player.getPlayer(turn).addPos(walk);
            System.out.println("ได้เดินไปเท่านี้ช่อง : " + walk);
            System.out.println("เดินไปตกช่องที่ : " + player.getPlayer(turn).getPos());
            System.out.println("ซึ่งช่องนี้มีชื่อว่าาา ว่าาา : " + player.getPlayer(turn).getName());

            System.out.println("เมื่อมาตกแล้ว เช็คว่าช่องนี้เป็นประเภทสิ่งก่อสร้าง หรือ สถานที่วัดดวง/ พิเศษ");
            if (place.getPlace(player.getPlayer(turn).getPos()).canBuild()) {
                System.out.println("ช่องนี้เป็นสิ่งก็สร้างได้");
                System.out.println("เช็คว่าเป็นช่องของตัวเองหรือเปล่า");
                if (place.getPlace(player.getPlayer(turn).getPos()).isOwner(player.getPlayer(turn))) {
                    System.out.println("ถ้าเป็นช่องของตัวเอง");
                    /**
                     * 
                     * จะอัพไรมั้ยย
                     * เดี่ยวมาทำเหมือนกันน เยอะไปละ
                     * 
                     */

                } else {
                    System.out.println("ถ้าไม่ใช่ของตัวเอง ก็จ่ายค่าผ่านทาง");

                    /**
                     * 
                     * จะใช้การ์ดอะไรมั้ยยยย
                     * เดี่ยวมาทำเหมือนกันน เยอะไปละ
                     * 
                     */                

                    System.out.println("โดยเช็คก่อนว่ายังมีตังจ่ายค่าผ่านทางใหม");
                    if (place.getPlace(player.getPlayer(turn).getPos()).canBuyPlace(player.getPlayer(turn))) {
                        System.out.println("ถ้ามีตังจ่ายย ก็จ่ายค่าปรับปายยย");
                        place.getPlace(player.getPlayer(turn).getPos()).canPayToll(player.getPlayer(turn));

                    } else {
                        System.out.println("ถ้าไม่มีตังจ่ายย ล้มละลายยยยย");
                        break;
                    }

                    System.out.println("ในเมื่อไม่ใช่ของตัวเอง แล้วจ่ายค่าผ่านทางละ จะซื้อ/ซื้อต่ออะเป่าาาา");
                    /**
                     * 
                     * จะซื้อต่ออะเป่าาาา
                     * เดี่ยวมาทำเหมือนกันน เยอะไปละ
                     * 
                     */
                }
                player.nextTurn();
                System.out.println("เชิญ เทรินต่อไป");
                System.out.println("------------------------------");
            } else {
                System.out.println("ช่องนี้ไมาสามารถก่อสร้างได้");
            }
        }

            

        // อันนี้ลองเทสลูกเต๋า
        /**
         * while (paoyingshub.play(player.getPlayer(1), int_select)) {
         * System.out.println("Dice Chalenge game : You win"); }
         * paoyingshub.reSet();
         */
    }
}
