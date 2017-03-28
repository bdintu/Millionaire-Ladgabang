package millionaireladgabang;

import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    public static int randomInt(int range){
        Random generator = new Random();
        return generator.nextInt() * range;
    }
    
    public static String hash(String plan_text) throws NoSuchAlgorithmException {
        
        String rmWhiteSpaces = plan_text.replaceAll("\\s","");
        String toLowerCase = rmWhiteSpaces.toLowerCase();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(toLowerCase.getBytes());
        byte byteData[] = md.digest();

        return new String(byteData);
    }
}