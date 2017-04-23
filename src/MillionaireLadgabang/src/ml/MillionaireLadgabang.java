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

    Parent bord() throws Exception {

        place_red[0][0] = new ImageView("img/place/1/red/a1.png");
        place_red[0][1] = new ImageView("img/place/1/red/a2.png");
        place_red[0][2] = new ImageView("img/place/1/red/a3.png");
        place_red[0][3] = new ImageView("img/place/1/red/a4.png");
        place_red[0][4] = new ImageView("img/place/1/red/a5.png");
        place_red[0][5] = new ImageView("img/place/1/red/a6.png");
        place_red[0][6] = new ImageView("img/place/1/red/a7.png");
        place_red[0][7] = new ImageView("img/place/1/red/a8.png");
        place_red[0][8] = new ImageView("img/place/1/red/a9.png");
        place_red[0][9] = new ImageView("img/place/1/red/a10.png");
        place_red[0][10] = new ImageView("img/place/1/red/a11.png");
        place_red[0][11] = new ImageView("img/place/1/red/a12.png");
        place_red[0][12] = new ImageView("img/place/1/red/a13.png");
        place_red[0][13] = new ImageView("img/place/1/red/a14.png");
        place_red[0][14] = new ImageView("img/place/1/red/a15.png");
        place_red[0][15] = new ImageView("img/place/1/red/a16.png");
        place_red[0][16] = new ImageView("img/place/1/red/a17.png");
        place_red[0][17] = new ImageView("img/place/1/red/a18.png");
        place_red[0][18] = new ImageView("img/place/1/red/a19.png");
        place_red[0][19] = new ImageView("img/place/1/red/a20.png");
        place_red[0][20] = new ImageView("img/place/1/red/a21.png");
        place_red[1][0] = new ImageView("img/place/2/red/a1.png");
        place_red[1][1] = new ImageView("img/place/2/red/a2.png");
        place_red[1][2] = new ImageView("img/place/2/red/a3.png");
        place_red[1][3] = new ImageView("img/place/2/red/a4.png");
        place_red[1][4] = new ImageView("img/place/2/red/a5.png");
        place_red[1][5] = new ImageView("img/place/2/red/a6.png");
        place_red[1][6] = new ImageView("img/place/2/red/a7.png");
        place_red[1][7] = new ImageView("img/place/2/red/a8.png");
        place_red[1][8] = new ImageView("img/place/2/red/a9.png");
        place_red[1][9] = new ImageView("img/place/2/red/a10.png");
        place_red[1][10] = new ImageView("img/place/2/red/a11.png");
        place_red[1][11] = new ImageView("img/place/2/red/a12.png");
        place_red[1][12] = new ImageView("img/place/2/red/a13.png");
        place_red[1][13] = new ImageView("img/place/2/red/a14.png");
        place_red[1][14] = new ImageView("img/place/2/red/a15.png");
        place_red[1][15] = new ImageView("img/place/2/red/a16.png");
        place_red[1][16] = new ImageView("img/place/2/red/a17.png");
        place_red[1][17] = new ImageView("img/place/2/red/a18.png");
        place_red[1][18] = new ImageView("img/place/2/red/a19.png");
        place_red[1][19] = new ImageView("img/place/2/red/a20.png");
        place_red[1][20] = new ImageView("img/place/2/red/a21.png");
        place_red[2][0] = new ImageView("img/place/3/red/a1.png");
        place_red[2][1] = new ImageView("img/place/3/red/a2.png");
        place_red[2][2] = new ImageView("img/place/3/red/a3.png");
        place_red[2][3] = new ImageView("img/place/3/red/a4.png");
        place_red[2][4] = new ImageView("img/place/3/red/a5.png");
        place_red[2][5] = new ImageView("img/place/3/red/a6.png");
        place_red[2][6] = new ImageView("img/place/3/red/a7.png");
        place_red[2][7] = new ImageView("img/place/3/red/a8.png");
        place_red[2][8] = new ImageView("img/place/3/red/a9.png");
        place_red[2][9] = new ImageView("img/place/3/red/a10.png");
        place_red[2][10] = new ImageView("img/place/3/red/a11.png");
        place_red[2][11] = new ImageView("img/place/3/red/a12.png");
        place_red[2][12] = new ImageView("img/place/3/red/a13.png");
        place_red[2][13] = new ImageView("img/place/3/red/a14.png");
        place_red[2][14] = new ImageView("img/place/3/red/a15.png");
        place_red[2][15] = new ImageView("img/place/3/red/a16.png");
        place_red[2][16] = new ImageView("img/place/3/red/a17.png");
        place_red[2][17] = new ImageView("img/place/3/red/a18.png");
        place_red[2][18] = new ImageView("img/place/3/red/a19.png");
        place_red[2][19] = new ImageView("img/place/3/red/a20.png");
        place_red[2][20] = new ImageView("img/place/3/red/a21.png");
        place_red[3][0] = new ImageView("img/place/4/red/a1.png");
        place_red[3][1] = new ImageView("img/place/4/red/a2.png");
        place_red[3][2] = new ImageView("img/place/4/red/a3.png");
        place_red[3][3] = new ImageView("img/place/4/red/a4.png");
        place_red[3][4] = new ImageView("img/place/4/red/a5.png");
        place_red[3][5] = new ImageView("img/place/4/red/a6.png");
        place_red[3][6] = new ImageView("img/place/4/red/a7.png");
        place_red[3][7] = new ImageView("img/place/4/red/a8.png");
        place_red[3][8] = new ImageView("img/place/4/red/a9.png");
        place_red[3][9] = new ImageView("img/place/4/red/a10.png");
        place_red[3][10] = new ImageView("img/place/4/red/a11.png");
        place_red[3][11] = new ImageView("img/place/4/red/a12.png");
        place_red[3][12] = new ImageView("img/place/4/red/a13.png");
        place_red[3][13] = new ImageView("img/place/4/red/a14.png");
        place_red[3][14] = new ImageView("img/place/4/red/a15.png");
        place_red[3][15] = new ImageView("img/place/4/red/a16.png");
        place_red[3][16] = new ImageView("img/place/4/red/a17.png");
        place_red[3][17] = new ImageView("img/place/4/red/a18.png");
        place_red[3][18] = new ImageView("img/place/4/red/a19.png");
        place_red[3][19] = new ImageView("img/place/4/red/a20.png");
        place_red[3][20] = new ImageView("img/place/4/red/a21.png");
        place_blue[0][0] = new ImageView("img/place/1/blue/a1.png");
        place_blue[0][1] = new ImageView("img/place/1/blue/a2.png");
        place_blue[0][2] = new ImageView("img/place/1/blue/a3.png");
        place_blue[0][3] = new ImageView("img/place/1/blue/a4.png");
        place_blue[0][4] = new ImageView("img/place/1/blue/a5.png");
        place_blue[0][5] = new ImageView("img/place/1/blue/a6.png");
        place_blue[0][6] = new ImageView("img/place/1/blue/a7.png");
        place_blue[0][7] = new ImageView("img/place/1/blue/a8.png");
        place_blue[0][8] = new ImageView("img/place/1/blue/a9.png");
        place_blue[0][9] = new ImageView("img/place/1/blue/a10.png");
        place_blue[0][10] = new ImageView("img/place/1/blue/a11.png");
        place_blue[0][11] = new ImageView("img/place/1/blue/a12.png");
        place_blue[0][12] = new ImageView("img/place/1/blue/a13.png");
        place_blue[0][13] = new ImageView("img/place/1/blue/a14.png");
        place_blue[0][14] = new ImageView("img/place/1/blue/a15.png");
        place_blue[0][15] = new ImageView("img/place/1/blue/a16.png");
        place_blue[0][16] = new ImageView("img/place/1/blue/a17.png");
        place_blue[0][17] = new ImageView("img/place/1/blue/a18.png");
        place_blue[0][18] = new ImageView("img/place/1/blue/a19.png");
        place_blue[0][19] = new ImageView("img/place/1/blue/a20.png");
        place_blue[0][20] = new ImageView("img/place/1/blue/a21.png");
        place_blue[1][0] = new ImageView("img/place/2/blue/a1.png");
        place_blue[1][1] = new ImageView("img/place/2/blue/a2.png");
        place_blue[1][2] = new ImageView("img/place/2/blue/a3.png");
        place_blue[1][3] = new ImageView("img/place/2/blue/a4.png");
        place_blue[1][4] = new ImageView("img/place/2/blue/a5.png");
        place_blue[1][5] = new ImageView("img/place/2/blue/a6.png");
        place_blue[1][6] = new ImageView("img/place/2/blue/a7.png");
        place_blue[1][7] = new ImageView("img/place/2/blue/a8.png");
        place_blue[1][8] = new ImageView("img/place/2/blue/a9.png");
        place_blue[1][9] = new ImageView("img/place/2/blue/a10.png");
        place_blue[1][10] = new ImageView("img/place/2/blue/a11.png");
        place_blue[1][11] = new ImageView("img/place/2/blue/a12.png");
        place_blue[1][12] = new ImageView("img/place/2/blue/a13.png");
        place_blue[1][13] = new ImageView("img/place/2/blue/a14.png");
        place_blue[1][14] = new ImageView("img/place/2/blue/a15.png");
        place_blue[1][15] = new ImageView("img/place/2/blue/a16.png");
        place_blue[1][16] = new ImageView("img/place/2/blue/a17.png");
        place_blue[1][17] = new ImageView("img/place/2/blue/a18.png");
        place_blue[1][18] = new ImageView("img/place/2/blue/a19.png");
        place_blue[1][19] = new ImageView("img/place/2/blue/a20.png");
        place_blue[1][20] = new ImageView("img/place/2/blue/a21.png");
        place_blue[2][0] = new ImageView("img/place/3/blue/a1.png");
        place_blue[2][1] = new ImageView("img/place/3/blue/a2.png");
        place_blue[2][2] = new ImageView("img/place/3/blue/a3.png");
        place_blue[2][3] = new ImageView("img/place/3/blue/a4.png");
        place_blue[2][4] = new ImageView("img/place/3/blue/a5.png");
        place_blue[2][5] = new ImageView("img/place/3/blue/a6.png");
        place_blue[2][6] = new ImageView("img/place/3/blue/a7.png");
        place_blue[2][7] = new ImageView("img/place/3/blue/a8.png");
        place_blue[2][8] = new ImageView("img/place/3/blue/a9.png");
        place_blue[2][9] = new ImageView("img/place/3/blue/a10.png");
        place_blue[2][10] = new ImageView("img/place/3/blue/a11.png");
        place_blue[2][11] = new ImageView("img/place/3/blue/a12.png");
        place_blue[2][12] = new ImageView("img/place/3/blue/a13.png");
        place_blue[2][13] = new ImageView("img/place/3/blue/a14.png");
        place_blue[2][14] = new ImageView("img/place/3/blue/a15.png");
        place_blue[2][15] = new ImageView("img/place/3/blue/a16.png");
        place_blue[2][16] = new ImageView("img/place/3/blue/a17.png");
        place_blue[2][17] = new ImageView("img/place/3/blue/a18.png");
        place_blue[2][18] = new ImageView("img/place/3/blue/a19.png");
        place_blue[2][19] = new ImageView("img/place/3/blue/a20.png");
        place_blue[2][20] = new ImageView("img/place/3/blue/a21.png");
        place_blue[3][0] = new ImageView("img/place/4/blue/a1.png");
        place_blue[3][1] = new ImageView("img/place/4/blue/a2.png");
        place_blue[3][2] = new ImageView("img/place/4/blue/a3.png");
        place_blue[3][3] = new ImageView("img/place/4/blue/a4.png");
        place_blue[3][4] = new ImageView("img/place/4/blue/a5.png");
        place_blue[3][5] = new ImageView("img/place/4/blue/a6.png");
        place_blue[3][6] = new ImageView("img/place/4/blue/a7.png");
        place_blue[3][7] = new ImageView("img/place/4/blue/a8.png");
        place_blue[3][8] = new ImageView("img/place/4/blue/a9.png");
        place_blue[3][9] = new ImageView("img/place/4/blue/a10.png");
        place_blue[3][10] = new ImageView("img/place/4/blue/a11.png");
        place_blue[3][11] = new ImageView("img/place/4/blue/a12.png");
        place_blue[3][12] = new ImageView("img/place/4/blue/a13.png");
        place_blue[3][13] = new ImageView("img/place/4/blue/a14.png");
        place_blue[3][14] = new ImageView("img/place/4/blue/a15.png");
        place_blue[3][15] = new ImageView("img/place/4/blue/a16.png");
        place_blue[3][16] = new ImageView("img/place/4/blue/a17.png");
        place_blue[3][17] = new ImageView("img/place/4/blue/a18.png");
        place_blue[3][18] = new ImageView("img/place/4/blue/a19.png");
        place_blue[3][19] = new ImageView("img/place/4/blue/a20.png");
        place_blue[3][20] = new ImageView("img/place/4/blue/a21.png");

        player = new PlayerList(name);
        dice = new DiceList(player);
        bord.begin(player);

        if (name[0] == "Durian") {
            chareter[0] = new ImageView("img/char/ทุเรียน2rv.png");
            chareter[1] = new ImageView("img/char/อีกา1rv.png");
        } else {
            chareter[0] = new ImageView("img/char/อีกา1rv.png");
            chareter[1] = new ImageView("img/char/ทุเรียน2rv.png");
        }

        /*for (int i = 0; i < 4; ++i) {
            place_red[i] = new ImageView[21];
            place_blue[i] = new ImageView[21];
            for (int j = 0; j < 21; ++j) {
                place_red[i][j] = new ImageView("img/place/" + (i + 1) + "/red/" + (j + 1) + ".png");
                place_blue[i][j] = new ImageView("img/place/" + (i + 1) + "/blue/" + (j + 1) + ".png");
            }
        }*/

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

        int turn = player.getTurn();

        bottomDice.setOnMouseClicked((event) -> {
            try {
                Util.imgSetPos(bottomDiceHover, 570, 340, 150, 150);
                root.getChildren().remove(bottomDice);
                root.getChildren().add(bottomDiceHover);

                int walk = dice.getStd(player.getPlayer(turn)).getPoints();

                charSetPos(chareter, walk);

                root.getChildren().remove(bottomDiceHover);
                root.getChildren().add(bottomDice);

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

        while (i != currentPos + walk) {

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
        player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
    }

    public static void main(String[] args) {
        launch(args);
    }

    ImageView chareter[] = new ImageView[2];
    ImageView[][] place_red = new ImageView[4][21];
    ImageView[][] place_blue = new ImageView[4][21];
/*(    
for i in range(0,4):
	for j in range(0,21):
		print "place_red["+str(i)+"]["+str(j)+"] = new ImageView(\"img/place/"+str(i+1)+"/red/a"+str(j+1)+".png\");"
		print "place_blue["+str(i)+"]["+str(j)+"] = new ImageView(\"img/place/"+str(i+1)+"/blue/a"+str(j+1)+".png\");"    
*/
    
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
}
