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
        File dir = new File(".");
        File fin = new File(dir.getCanonicalPath() + File.separator + fileName);
        FileInputStream fis = new FileInputStream(fin);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        br.close();
        
        return list;
    }
}
