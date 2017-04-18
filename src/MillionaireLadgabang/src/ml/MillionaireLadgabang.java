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
   
    double HEIGHT = 650.0;
    double WIDTH = 1200.0;
    Pane root = new Pane();
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        primaryStage.setScene(new Scene(lobbyGame()));
        stage.setResizable(false);
        primaryStage.setTitle("เกมเศรษฐี");
        primaryStage.getIcons().add(new Image("img/cover.png"));
        primaryStage.show();
    }
    Parent lobbyGame() throws Exception {

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        bg_lobby.setFitHeight(HEIGHT);
        bg_lobby.setFitWidth(WIDTH);

        Button btn_start = makeButton(start1, 520,420, 100, 200);
        
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

        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        bg_mainmenu.setFitHeight(HEIGHT);
        bg_mainmenu.setFitWidth(WIDTH);
        
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
