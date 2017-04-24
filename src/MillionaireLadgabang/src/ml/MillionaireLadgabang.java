/**
 * -Xmx
 */
package ml;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;

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

    int getPosX(int i) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 200;
            default:
                return 0;
        }
    }

    int getPosY(int i) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 200;
            default:
                return 0;
        }
    }

    int indexImg[][] = {{0, 1}, {1, 2}, {2, 4}, {3, 5}, {4, 6}, {5, 8}, {6, 9}, {7, 10}, {8, 12}, {9, 13}, {10, 15}, {11, 16}, {12, 17}, {13, 18}, {14, 19}, {15, 20}, {16, 22}, {17, 23}, {18,}, {19, 26}, {20, 27}};

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
            char_winner[0] = new ImageView("img/bord/crow_b.png");
            char_winner[1] = new ImageView("img/bord/du_r.png");
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
        Util.imgSetPos(status, 0, 0, 75, 350);
        Util.imgSetPos(status1, 950, 645, 75, 350);
        Util.imgSetPos(money, 20, 35, 150, 250);
        Util.imgSetPos(money1, 980, 505, 150, 250);
        Util.imgSetPos(bottomDice, 570, 340, 150, 150);
        root.getChildren().addAll(bg_game, chareter[0], chareter[1], status, status1, money, money1, bottomDice);

        Label lblStatus = new Label("X's turn to play");

        bottomDice.setOnMouseClicked((event) -> {
            try {
                Util.imgSetPos(bottomDiceHover, 570, 340, 150, 150);
                root.getChildren().remove(bottomDice);
                root.getChildren().add(bottomDiceHover);

                int turn = player.getTurn();
                int walk = dice.getStd(player.getPlayer(turn)).getPoints();

                charSetPos(chareter, walk);

                player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
                int pos = player.getPlayer(turn).getPos();

                // ปัญหาเรื่อง หน่วงเวลา
                root.getChildren().remove(bottomDiceHover);
                root.getChildren().add(bottomDice);

                // สร้างได้ มีเจ้าของที่ไม่ใช่เรา
                if (place.getPlace(pos).canBuild() && place.getPlace(pos).haveOwner() && place.getPlace(pos).isNotOwner(player.getPlayer(turn))) {

                    if (place.getPlace(pos).canPayToll(player.getPlayer(turn))) {
                        //root.getChildren().add(payToll);
                    } else {
                        player.getPlayer(turn).setLose();
                    }

                    // สร้างได้ ไม่มีเจ้าของ
                } else if (place.getPlace(pos).canBuild() && place.getPlace(pos).haveNotOwner()) {
                    if (place.getPlace(pos).isNotMaxLevel()) {
                        int tmpDeep = coventPosToIndex(pos);
                        root.getChildren().add(deed[tmpDeep]);

                        int level = place.getPlace(pos).getLevel();
                        for (int i = level; i <= 4; ++i) {
                            if (place.getPlace(pos).canBuyPlace(player.getPlayer(turn), level)) {
                                root.getChildren().add(buy[i]);
                            }
                        }
                    }
                    // จุดพิเศษ
                } else {
                    switch (pos) {

                    }
                }

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
                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                place.getPlace(pos).buyPlace(player.getPlayer(turn), 0);

                int level = place.getPlace(pos).getLevel();
                if (turn == 0) {
                    place_red[level][pos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (pos + 1) + ".png");
                    Util.imgSetPos(place_red[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_red[level][pos]);

                } else if (turn == 1) {
                    place_blue[level][pos] = new ImageView("img/place/" + (level + 1) + "/blue/" + (pos + 1) + ".png");
                    Util.imgSetPos(place_blue[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_blue[level][pos]);
                }

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

        buy[2].setOnMouseClicked((event) -> {
            try {
                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                place.getPlace(pos).buyPlace(player.getPlayer(turn), 1);

                int level = place.getPlace(pos).getLevel();
                if (turn == 0) {
                    place_red[level][pos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (pos + 1) + ".png");
                    Util.imgSetPos(place_red[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_red[level][pos]);

                } else if (turn == 1) {
                    place_blue[level][pos] = new ImageView("img/place/" + (level + 1) + "/blue/" + (pos + 1) + ".png");
                    Util.imgSetPos(place_blue[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_blue[level][pos]);
                }

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

        buy[3].setOnMouseClicked((event) -> {
            try {
                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                place.getPlace(pos).buyPlace(player.getPlayer(turn), 2);

                int level = place.getPlace(pos).getLevel();
                if (turn == 0) {
                    place_red[level][pos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (pos + 1) + ".png");
                    Util.imgSetPos(place_red[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_red[level][pos]);

                } else if (turn == 1) {
                    place_blue[level][pos] = new ImageView("img/place/" + (level + 1) + "/blue/" + (pos + 1) + ".png");
                    Util.imgSetPos(place_blue[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_blue[level][pos]);
                }

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

        buy[4].setOnMouseClicked((event) -> {
            try {
                int turn = player.getTurn();
                int pos = player.getPlayer(turn).getPos();
                place.getPlace(pos).buyPlace(player.getPlayer(turn), 3);

                int level = place.getPlace(pos).getLevel();
                if (turn == 0) {
                    place_red[level][pos] = new ImageView("img/place/" + (level + 1) + "/red/a" + (pos + 1) + ".png");
                    Util.imgSetPos(place_red[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_red[level][pos]);

                } else if (turn == 1) {
                    place_blue[level][pos] = new ImageView("img/place/" + (level + 1) + "/blue/" + (pos + 1) + ".png");
                    Util.imgSetPos(place_blue[level][pos], 500, 500, 150, 400);
                    root.getChildren().add(place_blue[level][pos]);
                }

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

        /*root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
            }
        });*/
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
            Util.imgSetPos(deed[i], 400, 200, 200, 400);
        }

        for (int i = 0; i < 5; ++i) {
            buy[i] = new ImageView("img/deed/b" + i + ".png");
            Util.imgSetPos(buy[i], 400, 200, 200, 400);
        }

        /*for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 21; ++j) {
                place_red[i][j] = new ImageView("img/place/" + (i + 1) + "/red/a" + (j + 1) + ".png");
                place_blue[i][j] = new ImageView("img/place/" + (i + 1) + "/blue/a" + (j + 1) + ".png");
                Util.imgSetPos(place_red[i], 500, 500, 150, 400);
                Util.imgSetPos(place_blue[i], 500, 500, 150, 400);
            }
        }*/

 /*
        for i in range(0,4):
                for j in range(0,21):
                        print "place_red["+str(i)+"]["+str(j)+"] = new ImageView(\"img/place/"+str(i+1)+"/red/a"+str(j+1)+".png\");"
                        print "place_blue["+str(i)+"]["+str(j)+"] = new ImageView(\"img/place/"+str(i+1)+"/blue/a"+str(j+1)+".png\");"    
         */
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

    ImageView askTake = new ImageView("img/deed/ask_take.png");
    ImageView imgBuy = new ImageView("img/deed/buy.png");
    ImageView notBuy = new ImageView("img/deed/not_buy.png");
}
