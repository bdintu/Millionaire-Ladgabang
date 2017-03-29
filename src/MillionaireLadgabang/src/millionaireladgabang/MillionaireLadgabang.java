package millionaireladgabang;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MillionaireLadgabang extends Application {
    
    public static int wide = 1280;
    public static int high = 720;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Millionaire Ladgabang");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, wide, high);

        primaryStage.setTitle("Millionaire Ladgabang");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //launch(args);
    }
}
