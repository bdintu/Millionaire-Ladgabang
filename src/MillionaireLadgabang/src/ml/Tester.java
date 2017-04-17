package ml;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import ml.card.CardList;
import ml.dice.DiceList;
import ml.place.PlaceList;
import ml.player.PlayerList;

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

        // สร้างลูกเต๋า
        DiceList dice = new DiceList(player);
        // สร้างมินิเกมส์เป่ายิ่งฉุบ
        Paoyingshub paoyingshub = new Paoyingshub();

        // ลูปเกมส์ละ
        while (bord.haveContinueGame(player)) {

            /**
             * เช็คว่า turn ของใคร
             */
            int turn = player.getTurn();
            System.out.println("Turn : " + turn);

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
                    // Std คือชื่แลูกเต๋าปกติ ส่ง ผู้เล่นเข้าไปเพราะ ผู้เล่นจำกัดจำนวนครั้งที่ทอยได้
                    walk = dice.getStd(player.getPlayer(turn)).getPoints();
                    break;
                case 2:
                    System.out.println("เลือกคู่คี่");
                    // เช็คว่าใช้ครบไปยั้งงง
                    System.out.println("เหลือคู่คี่อีก : " + dice.getEvenOdd(player.getPlayer(turn)).getLimit() + "ครั้ง");
                    if (dice.getEvenOdd(player.getPlayer(turn)).isNotLimit()) {
                        System.out.println("เลือกลูกเต๋า 1)คู่ 2)คี่");
                        select_dice = sn.nextInt();
                        switch (select_dice) {
                            case 1:
                                dice.getEvenOdd(player.getPlayer(turn)).setEven();
                                break;
                            case 2:
                                dice.getEvenOdd(player.getPlayer(turn)).setOdd();
                                break;
                        }
                        walk = dice.getEvenOdd(player.getPlayer(turn)).getPoints();
                    } else {
                        System.out.println("ใช้คู่คี่เต็มลิมิตแย้ววว");
                    }
                    break;
                case 3:
                    System.out.println("เลือกสูงต่ำ");
                    // เช็คว่าใช้ครบไปยั้งงง
                    System.out.println("เหลือสูงต่ำอีก : " + dice.getHightLow(player.getPlayer(turn)).getLimit() + "ครั้ง");
                    if (dice.getHightLow(player.getPlayer(turn)).isNotLimit()) {
                        System.out.println("เลือกลูกเต๋า 1)สูง 2)ต่ำ");
                        select_dice = sn.nextInt();
                        switch (select_dice) {
                            case 1:
                                dice.getHightLow(player.getPlayer(turn)).setHight();
                                break;
                            case 2:
                                dice.getHightLow(player.getPlayer(turn)).setLow();
                                break;
                        }
                        walk = dice.getHightLow(player.getPlayer(turn)).getPoints();
                    } else {
                        System.out.println("ใช้สูงต่ำเต็มลิมิตแย้ววว");
                    }
                    break;
            }
            System.out.println("ทอยลูกเต๋าได้ : " + walk + "แต้ม");
            System.out.println("ช่องเดิม : " + player.getPlayer(turn).getPos());

            /**
             * เดินไป walk ช่อง
             */
            player.getPlayer(turn).addPos(walk, player.getPlayer(turn));
            int pos = player.getPlayer(turn).getPos();

            System.out.println("เดินไปตกช่องที่ : " + pos);

            /**
             * พิมพ์ข้อมูลของช่องที่ตก
             */
            System.out.println("\tplace name : " + place.getPlace(pos).getName());
            System.out.println("\tOwner : " + place.getPlace(pos).getOwner());
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
                    if (!place.getPlace(pos).isMaxLevel()) {
                        System.out.println("ช่องนี้ยังเวลไม่ตัน จะซื้อมายยย true) ซื้อ false) ไม่ซื้อ");
                        boolean is_buy = sn.nextBoolean();

                        // อันนี้ จะซื้อบ้าน / อัพเวลนะ
                        if (is_buy) {
                            System.out.println("ต้องการอัพเกตบ้านน");
                            System.out.println("เช็คก่อนว่ายังมีตังจ่ายค่าซื้อบ้านเวลต่อไปหรอไม่");
                            if (place.getPlace(pos).canBuyPlace(player.getPlayer(turn))) {
                                System.out.println("\t อัพเกตบ้านเรียบร้อยย");
                                place.getPlace(pos).buyPlace(player.getPlayer(turn));
                            } else {
                                System.out.println("\tไม่มีตังจ่ายยอัพเกตบ้าน ล้มละลายยยยย");
                                player.getPlayer(turn).setLose();
                                // อย่าลืม break เดี่ยวแม่งวิ่งมั่ว
                                break;
                            }
                        }
                    }

                } else if (place.getPlace(pos).haveOwner()) {
                    System.out.println("\tช่องนี้เป็นของคนอื่น");

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
                        System.out.println("\tค่าผ่านทางเลเวลที่ : " + place.getPlace(pos).getLevel());
                        System.out.println("\tเสียค่าผ่านทาง : " + place.getPlace(pos).getToll() + "หน่วยย");

                    } else {
                        System.out.println("\tไม่มีตังจ่ายยค่าปรับ ล้มละลายยยยย");
                        player.getPlayer(turn).setLose();
                        // อย่าลืม break เดี่ยวแม่งวิ่งมั่ว
                        break;
                    }

                    System.out.println("จะซื้อต่ออะเป่าาาา true) ซื้อ false) ไม่ซื้อ");
                    boolean is_buy = sn.nextBoolean();

                    // อันนี้ จะซื้อบ้านต่อนะ
                    if (is_buy) {
                        System.out.println("ต้องการซื้อบ้านต่อ");
                        System.out.println("เช็คก่อนว่ายังมีตังจ่ายค่าซื้อบ้านเวลต่อไปหรอไม่");
                        if (place.getPlace(pos).canTakeOver(player.getPlayer(turn))) {
                            System.out.println("\t อัพเกตบ้านเรียบร้อยย");
                            place.getPlace(pos).TakeOver(player.getPlayer(turn));
                        } else {
                            System.out.println("\tไม่มีตังจ่ายยอัพเกตบ้าน ล้มละลายยยยย");
                            player.getPlayer(turn).setLose();
                            // อย่าลืม break เดี่ยวแม่งวิ่งมั่ว
                            break;
                        }
                    }

                } else {
                    System.out.println("\tช่องนี้ไม่มีเจ้าของ");
                    System.out.println("จะซื้อบ้านมายยย true) ซื้อ false) ไม่ซื้อ");
                    boolean is_buy = sn.nextBoolean();

                    // อันนี้ จะซื้อบ้าน
                    if (is_buy) {
                        System.out.println("ต้องการซื้อบ้านน");
                        System.out.println("เช็คก่อนว่ายังมีตังจ่ายค่าซื้อบ้านหรือไม่");
                        if (place.getPlace(pos).canBuyPlace(player.getPlayer(turn))) {
                            System.out.println("\t ซื้อบ้านเรียบร้อยย");
                            place.getPlace(pos).buyPlace(player.getPlayer(turn));
                        } else {
                            System.out.println("\tไม่มีตังจ่ายยอัพเกตบ้าน ล้มละลายยยยย");
                            player.getPlayer(turn).setLose();
                            // อย่าลืม break เดี่ยวแม่งวิ่งมั่ว
                            break;
                        }
                    }
                }

                /**
                 * พิมพ์ข้อมูลของช่องที่ตก
                 */
                System.out.println("\tplace name : " + place.getPlace(pos).getName());
                System.out.println("\tOwner : " + place.getPlace(pos).getOwner());
                System.out.println("\tplace level : " + place.getPlace(pos).getLevel());

            } else {
                System.out.println("\tช่องนี้ไม่สามารถซื้อบ้านได้");
                switch (pos) {
                    // นับช่อง start เป็น 0 จนถึงช่องที่ 27 เป็นช่องสุดท้าย
                    case 0:
                        System.out.println("Start");
                        break;
                    case 3:
                        System.out.println("มินิเกมส์");
                        System.out.println("คุณเลือก 0)scissor 1)rock 2)paper 3)ไม่เลือก");
                        int select = sn.nextInt();
                        /**
                         * อันนี้ ตามที่คุยไว่ ว่ามันจะล็อครอบที่ชนะเลยยย
                         *
                         */
                        System.out.println("จำนวนรอบที่ล็อคให้ชนะ" + paoyingshub.getRandomRound());
                        while (paoyingshub.play(player.getPlayer(turn), select)) {
                            // อันนี้ผู้ใช้ออกอะไร ก็ให้ใส่ภาพตามที่ผู้ใช้เลือก
                            System.out.println("Dice Chalenge game : You win");
                        }
                        paoyingshub.reSet();
                        break;
                    case 7:
                        System.out.println("สำนักทะเบียน");
                        /**
                         * อันนี้ให้ทำไรอะ ปรับตังมะ
                         */
                        if (place.getPlace(pos).canPayToll(player.getPlayer(turn))) {
                            System.out.println("\t จ่ายค่าทะเบียนเรียน เรียบร้อยย");
                            place.getPlace(pos).payToll(player.getPlayer(turn));
                        } else {
                            System.out.println("\tไม่มีตังจ่ายยค่าทะเบียนเรียน ล้มละลายยยยย");
                            player.getPlayer(turn).setLose();
                            // อย่าลืม break เดี่ยวแม่งวิ่งมั่ว
                            break;
                        }
                        break;
                    case 11:
                        System.out.println("การ์ด");
                        break;
                    case 14:
                        System.out.println("วัดปลูก");
                        /**
                         * อันนี้ให้ทำไรวะ 555
                         */
                        break;
                    case 21:
                        System.out.println("วินเกกี");
                        // ให้ผู้ใช้เลือกที่ต้องการจะไป
                        int select_pos = sn.nextInt();
                        player.getPlayer(turn).setPos(select_pos, player.getPlayer(turn));
                        pos = player.getPlayer(turn).getPos();
                        break;
                    case 25:
                        System.out.println("การ์ด");
                        break;
                }
            }

            player.nextTurn();
            System.out.println("เชิญ เทรินต่อไป");
            System.out.println("----------------------------------------");
        }
    }
}
