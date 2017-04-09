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

        /**
         *
         * ลองอ่านๆ ดู มันน่าจะยัดใน action ได้นะ
         *
         */
        // ลบด้วย อันนี้ใช้เทส เฉยๆ
        Scanner sn = new Scanner(System.in);

        /**
         *
         * ไปที่ ml.card.CardList.java ต่อ method createCard ใส่การ์ดเพิ่มด้วยยย
         *
         * ไปที่ ml.place.PlaceList.java ต่อ method createCard
         * ใส่สถานที่เพิ่มด้วยยย กะแลนมาร์ค
         *
         */
        // สร้างชื่อผู้เล่น โดยใส่ใน อาเรย์ name เลย ใส่กี่คนก็ว่าไป ได้หมด
        String[] name = {"E Ka", "Durian"};

        /**
         * อันนี้ต้องกำหนดลำดับว่าใครเล่นก่อนหลัง ทำใน String[] name เช้น
         * String[] name = {"E Ka", "Durian"}; คือ E Ka เล่นก่อน แต่ String[]
         * name = {"Durian", "E Ka"}; คือ Durian เล่นก่อน
         *
         * อันนี้ทำไม่ทัน ฝากทำต่อด้วยเน้ออออ อันนี้ทำไม่ทัน ฝากทำต่อด้วยเน้ออออ
         * 
         * หรือขี้เกียจ ก็ข้ามไปเลย 555 
         *
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

            /**
             * เช็คว่า turn ของใคร
             */
            int turn = player.getTurn();
   
            /**
             * พิมพ์ข้อมูลส่วนตัววว
             */
            System.out.println("\tname : " + player.getPlayer(turn).getName());
            System.out.println("\tmoney : " + player.getPlayer(turn).getMoney().getMoney());
            System.out.println("\tpos : " + player.getPlayer(turn).getPos());

            /**
             * Dicee
             */
            System.out.println("เลือกลูกเต๋า 1)ปกติ 2)คู่คี่ 3)สูงต่ำ");
            int select_dice = sn.nextInt();
            int walk = 0;
            switch (select_dice) {
                case 1:
                    System.out.println("เลือกสุ่มเต๋าปกติ 0-12");
                    walk = dice_std.getPoints();
                    break;
                case 2:
                    System.out.println("เลือกคู่คี่");
                    System.out.println("เลือกลูกเต๋า 1)คู่ 2)คี่");
                    select_dice = sn.nextInt();
                    switch (select_dice) {
                        case 1:
                            dice_evenodd.setEven();
                            break;
                        case 2:
                            dice_evenodd.setOdd();
                            break;
                    }
                    walk = dice_evenodd.getPoints();
                    break;
                case 3:
                    System.out.println("เลือกสูงต่ำ");
                    System.out.println("เลือกลูกเต๋า 1)สูง 2)ต่ำ");
                    select_dice = sn.nextInt();
                    switch (select_dice) {
                        case 1:
                            dice_hightlow.setHight();
                            break;
                        case 2:
                            dice_hightlow.setLow();
                            break;
                    }
                    walk = dice_hightlow.getPoints();
                    break;
            }
            System.out.println("ทอยลูกเต๋าได้เท่านี้แต้ม : " + walk);

            /**
             * เดินไป walk ช่อง
             */
            player.getPlayer(turn).addPos(walk, player.getPlayer(turn));
            int pos = player.getPlayer(turn).getPos();

            System.out.println("ได้เดินไป : " + walk + "ช่อง");
            System.out.println("เดินไปตกช่องที่ : " + pos);
            
            /**
             * พิมพ์ข้อมูลของช่องที่ตก
             */
            System.out.println("\tplace level : " + place.getPlace(pos).getName());
            System.out.println("\tplace level : " + place.getPlace(pos).getOwner());
            System.out.println("\tplace level : " + place.getPlace(pos).getLevel());         

            /**
             * มาสู่อันที่เยอะที่สุดละะะ
             */
            System.out.println("เมื่อมาตกแล้ว เช็คว่าช่องนี้สามารถซื้อบ้านได้หรือไม่");
            if (place.getPlace(pos).canBuild()) {
                System.out.println("\tช่องนี้เป็นสามารถซื้อบ้านได้");

                System.out.println("ช่องนี้เป็นของตัวเองหรือเปล่า");
                if (place.getPlace(pos).isOwner(player.getPlayer(turn))) {
                    System.out.println("\tช่องนี้เป็นของตัวเอง");

                    // จะซื้อบ้าน เช็คว่าเวลตันยังง
                    if(!place.getPlace(pos).isMaxLevel()){
                        System.out.println("ช่องนี้ยังเวลไม่ตัน จะซื้อมายยย 1) ซื้อ 2) ไม่ซื้อ");
                        boolean is_buy = sn.nextBoolean();
                        
                        // อันนี้ จะซื้อบ้าน / อัพเวลนะ
                        if(is_buy){
                            System.out.println("ต้องการอัพเกตบ้านน");
                            System.out.println("เช็คก่อนว่ายังมีตังจ่ายค่าซื้อบ้านเวลต่อไปหรอไม่");
                            if (place.getPlace(pos).canBuyPlace(player.getPlayer(turn))) {
                                System.out.println("\t อัพเกตบ้านเรียบร้อยย");
                                place.getPlace(pos).buyPlace(player.getPlayer(turn));
                            } else {
                               System.out.println("\tไม่มีตังจ่ายยอัพเกตบ้าน ล้มละลายยยยย");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("\tช่องนี้ไม่ใช้ของตัวเอง");

                    System.out.println("สามารถใช้การ์ดได้");
                    /**
                     *
                     * จะใช้การ์ดอะไรมั้ยยยย เดี่ยวมาทำเหมือนกันน เยอะไปละ
                     *
                     */
                    System.out.println("เช็คก่อนว่ายังมีตังจ่ายค่าผ่านทางใหม");
                    if (place.getPlace(pos).canPayToll(player.getPlayer(turn))) {
                        place.getPlace(pos).payToll(player.getPlayer(turn));
                        System.out.println("\tมีตังจ่ายยค่าปรับ จ่ายเรียบร้อยย");

                    } else {
                        System.out.println("\tไม่มีตังจ่ายยค่าปรับ ล้มละลายยยยย");
                        break;
                    }

                    System.out.println("ในเมื่อไม่ใช่ของตัวเอง แล้วจ่ายค่าผ่านทางละ จะซื้อ/ซื้อต่ออะเป่าาาา");
                    /**
                     *
                     * จะซื้อต่ออะเป่าาาา เดี่ยวมาทำเหมือนกันน เยอะไปละ
                     *
                     */
                }
                player.nextTurn();
                System.out.println("เชิญ เทรินต่อไป");
                System.out.println("----------------------------------------");
            } else {
                switch(pos){
                    case 0:
                        //start
                }
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
