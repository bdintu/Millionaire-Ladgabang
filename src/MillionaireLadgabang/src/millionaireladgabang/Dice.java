package millionaireladgabang;

import java.util.Random;

public class Dice {
    
    private final int amount = 2;
    private final int dat = 6;
    
    private int[] value;
    private Random generator;

    public Dice(){
        value = new int[amount];
        generator = new Random();
    }
    
    public int[] getOddEven(){
        for(int i=0; i<amount; ++i){
            value[i] = generator.nextInt() * dat;
        }
        return value;
    }
}