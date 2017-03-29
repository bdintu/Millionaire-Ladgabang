package millionaireladgabang;

import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    
    private static Random generator;
    public static int randomInt(int range){
        generator = new Random();
        return generator.nextInt(range);
    }
    
    private static MessageDigest md;
    public static String hash(String plan_text) throws NoSuchAlgorithmException {
        
        String rmWhiteSpaces = plan_text.replaceAll("\\s","");
        String toLowerCase = rmWhiteSpaces.toLowerCase();

        md = MessageDigest.getInstance("SHA-256");
        md.update(toLowerCase.getBytes());
        byte byteData[] = md.digest();

        return new String(byteData);
    }
}