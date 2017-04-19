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
import ml.card.CardList;
import ml.dice.DiceList;
import ml.place.PlaceList;
import ml.player.PlayerList;
import java.util.concurrent.TimeUnit;

public class MillionaireLadgabang extends Application {

    String[] name = new String[2];
    PlayerList player;

    Bord bord = new Bord();

    // สร้างการ์ดมาก่อนน
    CardList card = new CardList();

    // สร้างสถานที่ตามมาา
    PlaceList place = new PlaceList();

    // สร้างลูกเต๋า
    DiceList dice;

    // สร้างมินิเกมส์เป่ายิ่งฉุบ
    Paoyingshub paoyingshub = new Paoyingshub();

    final int HEIGHT = 720;
    final int WIDTH = 1280;
    Pane root = new Pane();
    Stage stage = new Stage();

    ImageView chareter[] = new ImageView[2];

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        primaryStage.setScene(new Scene(lobbyGame()));
        stage.setResizable(false);
        primaryStage.setTitle("เกมเศรษ ลาดบัง");
        primaryStage.getIcons().add(new Image("img/cover.png"));
        primaryStage.show();
    }

    Parent lobbyGame() throws Exception {

        ImageView bg_lobby = new ImageView("img/cover.png");
        ImageView start1 = new ImageView("img/start.gif");

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_lobby.setFitHeight(HEIGHT);
        bg_lobby.setFitWidth(WIDTH);

        Button btn_start = makeButton(start1, 520, 480, 100, 200);

        btn_start.setOnMouseClicked((event) -> {
            try {
                stage.setScene(new Scene(mainmenu()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.getChildren().addAll(bg_lobby, btn_start);

        return root;
    }

    Parent mainmenu() throws Exception {
        ImageView bg_mainmanu = new ImageView("img/bg_mainmanu.gif");
        ImageView carddurian = new ImageView("img/charcard_du.png");
        ImageView cardcrow = new ImageView("img/charcard_crow.png");
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
                stage.setScene(new Scene(Game()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cardcrow.setOnMouseClicked((event) -> {
            try {
                name[0] = "E Ka";
                name[1] = "Durian";
                stage.setScene(new Scene(Game()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().addAll(bg_mainmanu, carddurian, cardcrow);
        return root;
    }

    final int AXIS_CHAR_START_X = 570;
    final int AXIS_CHAR_START_Y = 540;

    final int AXIS_CHAR_LEFT_X = 0;
    final int AXIS_CHAR_LEFT_Y = 200;

    final int AXIS_CHAR_TOP_X = 570;
    final int AXIS_CHAR_TOP_Y = 0;

    final int DIAGONAL_LEFT_X = (AXIS_CHAR_START_X - AXIS_CHAR_LEFT_X) / 7;
    final int DIAGONAL_LEFT_Y = (AXIS_CHAR_START_Y - AXIS_CHAR_LEFT_Y) / 7;

    final int DIAGONAL_RIGHT_X = (AXIS_CHAR_TOP_X - AXIS_CHAR_LEFT_X) / 7;
    final int DIAGONAL_RIGHT_Y = (AXIS_CHAR_LEFT_Y - AXIS_CHAR_TOP_Y) / 7;

    int posX[] = new int[2];
    int posY[] = new int[2];

    Parent Game() throws Exception {

        player = new PlayerList(name);
        dice = new DiceList(player);
        bord.begin(player);

        ImageView bg_game = new ImageView("img/bg_game.png");

        if (name[0] == "Durian") {
            chareter[0] = new ImageView("img/ทุเรียน2rv.png");
            chareter[1] = new ImageView("img/อีกา1rv.png");
        } else {
            chareter[0] = new ImageView("img/อีกา1rv.png");
            chareter[1] = new ImageView("img/ทุเรียน2rv.png");
        }

        ImageView status = new ImageView("img/c2r.png");
        ImageView status1 = new ImageView("img/d1b.png");
        ImageView money = new ImageView("img/เงิน.png");
        ImageView money1 = new ImageView("img/เงิน.png");
        ImageView bottomDice = new ImageView("img/btn_1.png");
        ImageView bottomDiceHover = new ImageView("img/btn_2.png");

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_game.setFitHeight(HEIGHT);
        bg_game.setFitWidth(WIDTH);

        posX[0] = AXIS_CHAR_START_X;
        posY[0] = AXIS_CHAR_START_Y;
        posX[1] = posX[0] + 40;
        posY[1] = posY[0] + 10;

        imgSetPos(chareter[0], posX[0], posY[0], 100, 100);
        imgSetPos(chareter[1], posX[1], posY[1] + 10, 100, 100);
        imgSetPos(status, 0, 0, 75, 350);
        imgSetPos(status1, 950, 645, 75, 350);
        imgSetPos(money, 20, 35, 150, 250);
        imgSetPos(money1, 980, 505, 150, 250);
        imgSetPos(bottomDice, 570, 340, 150, 150);
        root.getChildren().addAll(bg_game, chareter[0], chareter[1], status, status1, money, money1, bottomDice);

        int turn = player.getTurn();

        bottomDice.setOnMouseClicked((event) -> {
            try {
                imgSetPos(bottomDiceHover, 570, 340, 150, 150);
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

        return root;
    }

    void charSetPos(ImageView[] img, int walk) throws InterruptedException {
        int turn = player.getTurn();
        int pos = player.getPlayer(turn).getPos();
        int tmpPos = pos;
        while (pos < tmpPos + walk) {
            if (pos >= 0 && pos < 7) {
                posX[turn] -= DIAGONAL_LEFT_X;
                posY[turn] -= DIAGONAL_LEFT_Y;
            } else if (pos >= 7 && pos < 14) {
                posX[turn] += DIAGONAL_RIGHT_X;
                posY[turn] -= DIAGONAL_RIGHT_Y;
            } else if (pos >= 14 && pos < 21) {
                posX[turn] += DIAGONAL_LEFT_X;
                posY[turn] += DIAGONAL_LEFT_Y;
            } else if (pos >= 21 && pos < 28) {
                posX[turn] -= DIAGONAL_RIGHT_X;
                posY[turn] += DIAGONAL_RIGHT_Y;
            }
            if (pos == 28) {
                pos = 0;
            } else {
                ++pos;
            }

            imgSetPos(chareter[turn], posX[turn], posY[turn], 100, 100);
            System.out.println(pos + " -> " + (tmpPos + walk) + ", pos: " + posX[turn] + ", " + posY[turn]);

            //TimeUnit.SECONDS.sleep(1);
        }
        // อันนี้ให้ระบบรู้ว่า ย้ายไปช่องนี้ละ หลังเดินเสร็จ
        player.getPlayer(turn).movePos(walk, player.getPlayer(turn));
    }

    void imgSetPos(ImageView img, int lX, int lY, int fX, int fY) {
        img.setLayoutX(lX);
        img.setLayoutY(lY);
        img.setFitHeight(fX);
        img.setFitWidth(fY);
    }

    Button makeButton(ImageView image1, double positionX, double positionY, double sizeX, double sizeY) {

        image1.setFitHeight(sizeX);
        image1.setFitWidth(sizeY);

        Button button = new Button();
        button.setGraphic(image1);
        button.setLayoutX(positionX);
        button.setLayoutY(positionY);

        button.setBackground(Background.EMPTY);

        button.setOnMouseEntered((MouseEvent e) -> {
            button.setGraphic(image1);
        });

        button.setOnMouseExited((MouseEvent e) -> {
            button.setGraphic(image1);
        });
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
