package ml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

public class Util {

    private static Random generator;

    public static int randomInt(int start, int range) {
        generator = new Random();
        return generator.nextInt(range) + start;
    }

    private static MessageDigest md;

    public static String hash(String plan_text) throws NoSuchAlgorithmException {

        String rmWhiteSpaces = plan_text.replaceAll("\\s", "");
        String toLowerCase = rmWhiteSpaces.toLowerCase();

        md = MessageDigest.getInstance("SHA-256");
        md.update(toLowerCase.getBytes());
        byte byteData[] = md.digest();

        return new String(byteData);
    }

    public static ArrayList readFile(String fileName) throws IOException {
        ArrayList list = new ArrayList();
        File fin = new File(new File(".").getCanonicalPath() + File.separator + fileName);
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        br.close();

        return list;
    }

    public static void imgSetPos(ImageView img, int lX, int lY, int fX, int fY) {
        img.setLayoutX(lX);
        img.setLayoutY(lY);
        img.setFitHeight(fX);
        img.setFitWidth(fY);
    }

    public static Button makeButton(ImageView image1, double positionX, double positionY, double sizeX, double sizeY) {

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
}
