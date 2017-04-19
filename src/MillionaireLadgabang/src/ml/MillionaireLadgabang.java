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

public class MillionaireLadgabang extends Application {

    ImageView bg_lobby = new ImageView("img/cover.png");
    ImageView start1 = new ImageView("img/start.gif");
   
    String[] name = new String[2];

    double HEIGHT = 650.0;
    double WIDTH = 1280.0;
    Pane root = new Pane();
    Stage stage = new Stage();

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

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_lobby.setFitHeight(HEIGHT);
        bg_lobby.setFitWidth(WIDTH);

        Button btn_start = makeButton(start1, 520, 420, 100, 200);

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
                name[0] = "durian";
                 name[1] = "E Ka";
                stage.setScene(new Scene(Game()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        cardcrow.setOnMouseClicked((event) -> {
            try {
                 name[0] = "E Ka";
                 name[1] = "durian";
                stage.setScene(new Scene(Game()));
            } catch (Exception ex) {
                Logger.getLogger(MillionaireLadgabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        /*Button btn_play = makeButton(bt_play1, bt_play2, 935, 130, 100, 240);
        Button btn_htp = makeButton(bt_htp1, bt_htp2, 965, 268, 105, 465);
        Button btn_CD = makeButton(bt_CD1, bt_CD2, 985, 430, 105, 265);
        Button btn_EXIT = makeButton(bt_EXIT1, bt_EXIT2, 1000, 595, 80, 180);*/
        root.getChildren().addAll(bg_mainmanu,carddurian,cardcrow);
        return root;
    }
    Parent Game() throws Exception {
    ImageView bg_game = new ImageView("img/bg_game.png");
    ImageView chareter = new ImageView("img/ทุเรียน2rv.png");
    ImageView chareter1 = new ImageView("img/อีกา1rv.png");
    ImageView  status = new ImageView("img/c2r.png");
    ImageView  status1 = new ImageView("img/d1b.png");
    ImageView  money = new ImageView("img/เงิน.png");
     ImageView  money1 = new ImageView("img/เงิน.png");
    ImageView bottom = new ImageView("img/btn_1.png");

    Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_game.setFitHeight(HEIGHT);
        bg_game.setFitWidth(WIDTH);
        chareter.setLayoutX(axisCharStartX);
        chareter.setLayoutY(axisCharStartY);
        chareter.setFitHeight(100);
        chareter.setFitWidth(100);
        chareter1.setLayoutX(550);
        chareter1.setLayoutY(500);
        chareter1.setFitHeight(100);
        chareter1.setFitWidth(100);
        status.setLayoutX(0);
        status.setLayoutY(0);
        status.setFitHeight(75);
        status.setFitWidth(350);
        status1.setLayoutX(950);
        status1.setLayoutY(575);
        status1.setFitHeight(75);
        status1.setFitWidth(350);
        money.setLayoutX(20);
        money.setLayoutY(35);
        money.setFitHeight(150);
        money.setFitWidth(250);
        money1.setLayoutX(980);
        money1.setLayoutY(425);
        money1.setFitHeight(150);
        money1.setFitWidth(250);
        bottom.setLayoutX(570);
        bottom.setLayoutY(340);
        bottom.setFitHeight(150);
        bottom.setFitWidth(150);
        root.getChildren().addAll(bg_game,chareter,chareter1,status,status1,money,money1,bottom);
        return root;
    }
    
    final int axisCharStartX = 615;
    final int axisCharStartY = 500;

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
