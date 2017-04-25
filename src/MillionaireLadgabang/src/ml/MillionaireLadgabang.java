package ml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.paint.Color;

import ml.card.CardList;
import ml.dice.DiceList;
import ml.place.PlaceList;
import ml.player.PlayerList;
import ml.Util;

public class MillionaireLadgabang extends Application {

    final int HEIGHT = 720;
    final int WIDTH = 1280;

    Pane root = new Pane();
    Stage stage = new Stage();

    String[] name = new String[2];
    PlayerList player;

    Bord bord = new Bord();
    CardList card = new CardList();
    PlaceList place = new PlaceList();
    DiceList dice;
    Paoyingshub paoyingshub = new Paoyingshub();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setScene(new Scene(first()));
        stage.setResizable(false);
        primaryStage.setTitle("Millionaire Ladgabang");
        primaryStage.getIcons().add(new Image("img/bord/cover.png"));
        primaryStage.show();
        setImg();
    }

    Parent first() throws Exception {

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_lobby.setFitHeight(HEIGHT);
        bg_lobby.setFitWidth(WIDTH);

        Button btn_start = Util.makeButton(start1, 520, 480, 100, 200);

        btn_start.setOnMouseClicked((event) -> {
            try {
                stage.setScene(new Scene(lobby()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.getChildren().addAll(bg_lobby, btn_start);

        return root;
    }

    Parent lobby() throws Exception {

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_mainmanu.setFitHeight(HEIGHT);
        bg_mainmanu.setFitWidth(WIDTH);
        carddurian.setLayoutX(300);
        carddurian.setLayoutY(150);
        cardcrow.setLayoutX(700);
        cardcrow.setLayoutY(150);
        carddurian.setOnMouseClicked((event) -> {
            try {
                name[0] = "Durian";
                name[1] = "E Ka";
                stage.setScene(new Scene(bord()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cardcrow.setOnMouseClicked((event) -> {
            try {
                name[0] = "E Ka";
                name[1] = "Durian";
                stage.setScene(new Scene(bord()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().addAll(bg_mainmanu, carddurian, cardcrow);
        return root;
    }

    final int AXIS_CHAR_START_X = 650;
    final int AXIS_CHAR_START_Y = 645;

    final int AXIS_CHAR_LEFT_X = 93;
    final int AXIS_CHAR_LEFT_Y = 290;

    final int AXIS_CHAR_TOP_X = 637;
    final int AXIS_CHAR_TOP_Y = 33;

    final int DIAGONAL_LEFT_X = (AXIS_CHAR_START_X - AXIS_CHAR_LEFT_X) / 7;
    final int DIAGONAL_LEFT_Y = (AXIS_CHAR_START_Y - AXIS_CHAR_LEFT_Y) / 7;

    final int DIAGONAL_RIGHT_X = (AXIS_CHAR_TOP_X - AXIS_CHAR_LEFT_X) / 7;
    final int DIAGONAL_RIGHT_Y = (AXIS_CHAR_LEFT_Y - AXIS_CHAR_TOP_Y) / 7;

    int posX[] = new int[2];
    int posY[] = new int[2];

    int indexImg[][] = {{0, 1}, {1, 2}, {2, 4}, {3, 5}, {4, 6}, {5, 8}, {6, 9}, {7, 10}, {8, 12}, {9, 13}, {10, 15}, {11, 16}, {12, 17}, {13, 18}, {14, 19}, {15, 20}, {16, 22}, {17, 23}, {18,}, {19, 26}, {20, 27}};
    int posImg[][] = {{568, 605}, {475, 550}, {393, 497}, {313, 446}, {229, 391}, {147, 338}, {65, 285}, {13, 257}, {97, 214}, {182, 184}, {263, 146}, {344, 108}, {415, 70}, {493, 37}, {570, 5}, {640, 45}, {715, 85}, {790, 127}, {867, 170}, {947, 213}, {1027, 256}, {1110, 305}, {1040, 347}, {965, 386}, {890, 433}, {805, 475}, {732, 520}, {643, 557}};

    int coventIndexToPos(int s) {
        for (int i = 0; i < 21; ++i) {
            if (s == indexImg[i][0]) {
                return indexImg[i][1];
            }
        }
        return -1;
    }

    int coventPosToIndex(int s) {
        for (int i = 0; i < 21; ++i) {
            if (s == indexImg[i][1]) {
                return indexImg[i][0];
            }
        }
        return -1;
    }

    Parent bord() throws Exception {

        player = new PlayerList(name);
        dice = new DiceList(player);
        bord.begin(player);

        if (name[0] == "Durian") {
            chareter[0] = new ImageView("img/char/ทุเรียน2rv.png");
            chareter[1] = new ImageView("img/char/อีกา1rv.png");
            char_winner[0] = new ImageView("img/bord/du_r.png");
            char_winner[1] = new ImageView("img/bord/crow_b.png");
        } else {
            chareter[0] = new ImageView("img/char/อีกา1rv.png");
            chareter[1] = new ImageView("img/char/ทุเรียน2rv.png");
            char_winner[0] = new ImageView("img/bord/crow_r.png");
            char_winner[1] = new ImageView("img/bord/du_b.png");
        }

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_game.setFitHeight(HEIGHT);
        bg_game.setFitWidth(WIDTH);

        posX[0] = AXIS_CHAR_START_X - 100;
        posY[0] = AXIS_CHAR_START_Y - 100;
        posX[1] = posX[0] + 40;
        posY[1] = posY[0] + 10;

        Util.imgSetPos(chareter[0], posX[0], posY[0], 100, 100);
        Util.imgSetPos(chareter[1], posX[1], posY[1] + 10, 100, 100);
        Util.imgSetPos(status, 0, 0, 100, 300);
        Util.imgSetPos(status1, 980, 620, 100, 300);
        Util.imgSetPos(money, 20, 35, 150, 250);
        Util.imgSetPos(money1, 980, 505, 150, 250);
        Util.imgSetPos(bottomDice, 570, 340, 150, 150);
        Util.imgSetPos(askTake, 570, 300, 200, 200);
        Util.imgSetPos(imgBuy, 570, 300, 200, 200);
        Util.imgSetPos(notBuy, 570, 300, 200, 200);
        root.getChildren().addAll(bg_game, chareter[0], chareter[1], status, status1, money, money1, bottomDice);

        Text text = new Text();
        Util.setText(text, 500, 250, 50, 0);

        Text textDur = new Text();
        Util.setText(textDur, 1110, 670, 20, 0);
        textDur.setText("ทุเรียน");
        Text textCrow = new Text();
        Util.setText(textCrow, 140, 25, 20, 1);
        textCrow.setText("อีกา");

        Text moneyDur = new Text();
        Util.setText(moneyDur, 1110, 705, 20, 0);
        Text moneyCrow = new Text();
        Util.setText(moneyCrow, 140, 55, 20, 1);

        root.getChildren().addAll(text, textDur, textCrow, moneyDur, moneyCrow);

        bottomDice.setOnMouseClicked((event) -> {
            try {
                Util.imgSetPos(bottomDiceHover, 570, 340, 150, 150);
                root.getChildren().remove(bottomDice);
                root.getChildren().add(bottomDiceHover);

                int turn = player.getTurn();

                text.setText("ตาของ " + player.getPlayer(turn).getName());
                if (name[0] == "Durian") {

                    moneyDur.setText("เงิน " + String.format("%.2f", player.getPlayer(0).getMoney().getMoney() / 1e7) + "M");
                    moneyCrow.setText("เงิน " + String.format("%.2f", player.getPlayer(1).getMoney().getMoney() / 1e7) + "M");
                } else {
                    moneyCrow.setText("เงิน " + String.format("%.2f", player.getPlayer(0).getMoney().getMoney() / 1e7) + "M");
                    moneyDur.setText("เงิน " + String.format("%.2f", player.getPlayer(1).getMoney().getMoney() / 1e7) + "M");
                }

                int walk = dice.getStd(player.getPlayer(turn)).getPoints();

                charSetPos(chareter, walk);

                player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
                int pos = player.getPlayer(turn).getPos();

                // ปัญหาเรื่อง หน่วงเวลา
                root.getChildren().remove(bottomDiceHover);
                root.getChildren().add(bottomDice);

                // สร้างได้ เป็นของคนอื่น
                if (place.getPlace(pos).canBuild() && place.getPlace(pos).haveOwner() && place.getPlace(pos).isNotOwner(player.getPlayer(turn))) {

                    if (place.getPlace(pos).canPayToll(player.getPlayer(turn))) {
                        //root.getChildren().add(payToll);
                    } else {
                        if (turn == 0) {
                            Util.imgSetPos(char_winner[1], 0, 0, 0, 0);
                            root.getChildren().add(char_winner[1]);
                        } else if (turn == 1) {
                            Util.imgSetPos(char_winner[0], 0, 0, 0, 0);
                            root.getChildren().add(char_winner[0]);
                        }
                        player.getPlayer(turn).setLose();
                    }

                    if (place.getPlace(pos).canTakeOver(player.getPlayer(turn))) {
                        root.getChildren().addAll(askTake, imgBuy, notBuy);
                    }

                    // สร้างได้ ไม่มีเจ้าของ
                } else if (place.getPlace(pos).canBuild() && place.getPlace(pos).haveNotOwner()) {
                    if (place.getPlace(pos).isNotMaxLevel()) {
                        System.out.println("fasf : " + pos);
                        int tmpDeep = coventPosToIndex(pos);
                        root.getChildren().add(deed[tmpDeep]);

                        int check = 0;
                        int level = place.getPlace(pos).getLevel();
                        for (int i = level; i <= 4; ++i) {
                            if (place.getPlace(pos).canBuyPlace(player.getPlayer(turn), level)) {
                                ++check;
                                root.getChildren().add(buy[i]);
                            }
                        }

                        if (check == 0) {
                            root.getChildren().remove(deed[tmpDeep]);
                        }
                    }
                    // จุดพิเศษ
                } else {
                    switch (pos) {
                        // นับช่อง start เป็น 0 จนถึงช่องที่ 27 เป็นช่องสุดท้าย
                        case 0:
                            text.setText("จุดเริ่มต้น");
                            break;
                        case 3:
                            text.setText("เสี่ยงดวง");
                            List<String> ychoices = new ArrayList<>();
                            ychoices.add("1:คู่");
                            ychoices.add("2:คี่");

                            ChoiceDialog<String> ydialog = new ChoiceDialog<>("1:คู่", ychoices);
                            ydialog.setTitle("เสี่ยงดวง");
                            ydialog.setHeaderText("คุณจะมีโอกาศ หากคุณสามารถทายคู่คี่ถูก");
                            ydialog.setContentText("เลือก ");

                            Optional<String> yresult = ydialog.showAndWait();
                            if (yresult.isPresent()) {
                                System.out.println("Your choice: " + yresult.get() + yresult.get().charAt(0));
                                int ran = Util.randomInt(0, 1);
                                int shoud = Character.getNumericValue((yresult.get().charAt(0)));
                                if (ran == shoud) {
                                    text.setText("คุณได้เงินเพิ่ม 1M");
                                    player.getPlayer(turn).getMoney().addMoney(1e7);
                                } else {
                                    text.setText("ไม่เป็นไร คราวหน้าเอาใหม่");
                                }
                            }
                            player.nextTurn();
                            break;
                        case 7:
                            System.out.println("สำนักทะเบียน");
                            text.setText("งดเดิน 3 รอบ");
                            player.setWaitTurn();
                            player.nextTurn();
                            break;
                        case 11:
                            text.setText("สุ่มตาเดินให้คุณเอง");
                            walk = Util.randomInt(0, 12);
                            charSetPos(chareter, walk);
                            player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
                            player.nextTurn();
                            break;
                        case 14:
                            text.setText("วัดปลูก");
                            List<String> choices = new ArrayList<>();
                            for (int i = 0; i < place.size(); ++i) {
                                if (place.getPlace(i).isOwner(player.getPlayer(turn))) {
                                    choices.add(i + ":" + place.getPlace(i).getName());
                                }
                            }

                            ChoiceDialog<String> dialog = new ChoiceDialog<>("1:Start", choices);
                            dialog.setTitle("วัดปลูก");
                            dialog.setHeaderText("เพิ่มค่าผ่านทางเป็น 2 เท่า\nถ้าคุณไม่ได้ดป็นเจ้าของ ฝ่ายตรงข้ามจะต้องถูกบังคับบริจารให้คุณ");
                            dialog.setContentText("เลือกสถานที่ที่ต้องการเพิ่มค่าผ่านทาง");

                            Optional<String> result = dialog.showAndWait();
                            if (result.isPresent()) {
                                System.out.println("Your choice: " + result.get() + result.get().charAt(0));
                                pos = Character.getNumericValue((result.get().charAt(0)));
                                place.getPlace(pos).setOwner(player.getPlayer(turn));
                                place.getPlace(pos).setToll(place.getPlace(pos).getPrice() * 2);
                            }
                            player.nextTurn();
                            break;
                        case 21:
                            System.out.println("วินเกกี");
                            List<String> schoices = new ArrayList<>();
                            for (int i = 0; i < place.size(); ++i) {
                                schoices.add(i + ":" + place.getPlace(i).getName());
                            }

                            ChoiceDialog<String> sdialog = new ChoiceDialog<>("1:Start", schoices);
                            sdialog.setTitle("วินเกกี");
                            sdialog.setHeaderText("วินเกกี");
                            sdialog.setContentText("เลือกสถานที่ต้องการจะไป");

                            Optional<String> sresult = sdialog.showAndWait();
                            if (sresult.isPresent()) {
                                System.out.println("Your choice: " + sresult.get() + sresult.get().charAt(0));
                                walk = (28 - player.getPlayer(turn).getPos() + Character.getNumericValue((sresult.get().charAt(0)))) % 28;
                                charSetPos(chareter, walk);
                                player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
                            }
                            player.nextTurn();
                            break;
                        case 25:
                            text.setText("สุ่มตาเดินให้ฝ่ายตรงข้าม");
                            player.nextTurn();
                            walk = Util.randomInt(0, 12);
                            charSetPos(chareter, walk);
                            player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
                            break;
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        imgBuy.setOnMouseClicked((event) -> {
            try {

                text.setText("เทคโอเวคสำเร็จ");

                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int level = place.getPlace(pos).getLevel();
                place.getPlace(pos).TakeOver(player.getPlayer(turn));

                int tmpPos = coventPosToIndex(pos);
                if (turn == 0) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_red[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                            if (level == 3) {
                                Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 100, 100);
                            } else {
                                Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                            }

                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_red[level][tmpPos]);

                } else if (turn == 1) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_blue[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/blue/a" + (tmpPos + 1) + ".png");
                            if (level == 3) {
                                Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 100, 100);
                            } else {
                                Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                            }

                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_blue[level][tmpPos]);
                }

                root.getChildren().removeAll(askTake, imgBuy, notBuy);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        notBuy.setOnMouseClicked((event) -> {
            try {
                root.getChildren().removeAll(askTake, imgBuy, notBuy);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buy[0].setOnMouseClicked((event) -> {
            try {
                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int level = place.getPlace(pos).getLevel();
                root.getChildren().remove(buy[0]);
                for (int i = level; i <= 4; ++i) {
                    root.getChildren().remove(buy[i]);
                }
                int tmp = coventPosToIndex(pos);
                root.getChildren().remove(deed[tmp]);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buy[1].setOnMouseClicked((event) -> {
            try {

                text.setText("ซื้อบ้านขนาดเล็กสำเร็จ");

                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int tmpPos = coventPosToIndex(pos);
                int level = 0;
                place.getPlace(pos).buyPlace(player.getPlayer(turn), level);

                if (turn == 0) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_red[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_red[level][tmpPos]);

                } else if (turn == 1) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_blue[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/blue/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }
                    root.getChildren().add(place_blue[level][tmpPos]);
                }

                for (int i = 0; i <= 4; ++i) {
                    root.getChildren().remove(buy[i]);
                }

                root.getChildren().remove(deed[tmpPos]);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buy[2].setOnMouseClicked((event) -> {
            try {

                text.setText("ซื้อบ้านขนาดกลางสำเร็จ");

                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int tmpPos = coventPosToIndex(pos);
                int level = 1;
                place.getPlace(pos).buyPlace(player.getPlayer(turn), level);

                if (turn == 0) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_red[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_red[level][tmpPos]);

                } else if (turn == 1) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_blue[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/blue/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }
                    root.getChildren().add(place_blue[level][tmpPos]);
                }

                for (int i = 0; i <= 4; ++i) {
                    root.getChildren().remove(buy[i]);
                }
                root.getChildren().remove(deed[tmpPos]);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buy[3].setOnMouseClicked((event) -> {
            try {

                text.setText("ซื้อบ้านขนาดใหญ่สำเร็จ");

                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int tmpPos = coventPosToIndex(pos);
                int level = 2;
                place.getPlace(pos).buyPlace(player.getPlayer(turn), level);

                if (turn == 0) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_red[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_red[level][tmpPos]);

                } else if (turn == 1) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_blue[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/blue/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 0, 0);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }
                    root.getChildren().add(place_blue[level][tmpPos]);
                }

                for (int i = 0; i <= 4; ++i) {
                    root.getChildren().remove(buy[i]);
                }

                root.getChildren().remove(deed[tmpPos]);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buy[4].setOnMouseClicked((event) -> {
            try {

                text.setText("ซื้อแลนมาร์คสำเร็จ");

                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                int tmpPos = coventPosToIndex(pos);
                int level = 3;
                place.getPlace(pos).buyPlace(player.getPlayer(turn), level);

                if (turn == 0) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_red[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_red[level][tmpPos], posImg[pos][0], posImg[pos][1], 100, 100);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }

                    root.getChildren().add(place_red[level][tmpPos]);

                } else if (turn == 1) {
                    if (place_red[level][tmpPos] == null) {
                        try {
                            place_blue[level][tmpPos] = new ImageView("img/place/" + (level + 1) + "/blue/a" + (tmpPos + 1) + ".png");
                            Util.imgSetPos(place_blue[level][tmpPos], posImg[pos][0], posImg[pos][1], 100, 100);
                        } catch (Exception ex) {
                            System.out.println("img/place/" + (level + 1) + "/red/a" + (tmpPos + 1) + ".png");
                        }
                    }
                    root.getChildren().add(place_blue[level][tmpPos]);
                }

                for (int i = 0; i <= 4; ++i) {
                    root.getChildren().remove(buy[i]);
                }

                root.getChildren().remove(deed[tmpPos]);
                player.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        char_winner[0].setOnMouseClicked((event) -> {
            try {
                stage.setScene(new Scene(first()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        char_winner[1].setOnMouseClicked((event) -> {
            try {
                stage.setScene(new Scene(first()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
            }
        });
        return root;
    }

    void charSetPos(ImageView[] img, int walk) throws InterruptedException {

        int turn = player.getTurn();
        int currentPos = player.getPlayer(turn).getPos();
        int i = currentPos;

        while (i != (currentPos + walk) % 28) {

            if (i >= 0 && i < 7) {
                posX[turn] -= DIAGONAL_LEFT_X;
                posY[turn] -= DIAGONAL_LEFT_Y;
            } else if (i >= 7 && i < 14) {
                posX[turn] += DIAGONAL_RIGHT_X;
                posY[turn] -= DIAGONAL_RIGHT_Y;
            } else if (i >= 14 && i < 21) {
                posX[turn] += DIAGONAL_LEFT_X;
                posY[turn] += DIAGONAL_LEFT_Y;
            } else if (i >= 21 && i <= 27) {
                posX[turn] -= DIAGONAL_RIGHT_X;
                posY[turn] += DIAGONAL_RIGHT_Y;
            }

            if (i != 27) {
                ++i;
            } else {
                i = 0;
            }

            Util.imgSetPos(chareter[turn], posX[turn], posY[turn], 100, 100);
            System.out.println(i + " -> " + (currentPos + walk) + ", pos: " + posX[turn] + ", " + posY[turn]);

            //TimeUnit.SECONDS.sleep(1);
        }

        // อันนี้ให้ระบบรู้ว่า ย้ายไปช่องนี้ละ หลังเดินเสร็จ
    }

    public void setImg() {

        for (int i = 0; i < 21; ++i) {
            deed[i] = new ImageView("img/deed/" + (i + 1) + ".png");
            Util.imgSetPos(deed[i], 500, 200, 300, 300);
        }

        for (int i = 0; i < 5; ++i) {
            buy[i] = new ImageView("img/deed/b" + i + ".png");
            Util.imgSetPos(buy[i], 500, 200, 300, 300);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    ImageView[] chareter = new ImageView[2];
    ImageView[] char_winner = new ImageView[2];
    ImageView[] deed = new ImageView[21];
    ImageView[] buy = new ImageView[5];
    ImageView[][] place_red = new ImageView[4][21];
    ImageView[][] place_blue = new ImageView[4][21];

    ImageView bg_lobby = new ImageView("img/bord/cover.png");
    ImageView start1 = new ImageView("img/bord/start.gif");
    ImageView bg_mainmanu = new ImageView("img/bord/bg_mainmanu.gif");
    ImageView carddurian = new ImageView("img/char/charcard_du.png");
    ImageView cardcrow = new ImageView("img/char/charcard_crow.png");
    ImageView bg_game = new ImageView("img/bord/bg_game.png");
    ImageView status = new ImageView("img/bord/c2r.png");
    ImageView status1 = new ImageView("img/bord/d1b.png");
    ImageView money = new ImageView("img/bord/เงิน.png");
    ImageView money1 = new ImageView("img/bord/เงิน.png");
    ImageView bottomDice = new ImageView("img/bord/btn_1.png");
    ImageView bottomDiceHover = new ImageView("img/bord/btn_2.png");
    ImageView imgLose = new ImageView("img/deed/lose.png");
    ImageView reg = new ImageView("img/deed/reg.png");
    ImageView mea = new ImageView("img/deed/mea.png");
    ImageView exit = new ImageView("img/deed/exit.png");

    ImageView askTake = new ImageView("img/deed/ask_take.png");
    ImageView imgBuy = new ImageView("img/deed/buy.png");
    ImageView notBuy = new ImageView("img/deed/not_buy.png");
}
