package millionaireladgabang;

import java.util.Random;

public class Dice {
    
    private final int amount = 2;
    private final int dat = 6;
    
    private int[] value;
    private Random generator;
    private int sum;

    public Dice(){
        value = new int[amount];
        generator = new Random();
    }
    
    public int getDice(){
        return sum;
    }
    
    public void generatorDice(){
        sum = 0;
        for(int i=0; i<amount; ++i){
            value[i] = generator.nextInt() * dat;
            sum += value[i];
        }
    }
    
    public boolean checkEven(){
        int even = 0;
        for(int i=0; i<amount; ++i){
            if( value[i]%2==0 ){
                even++;
            }
        }
        return even==amount;
    }
    
    public boolean checkOdd(){
        int odd = 0;
        for(int i=0; i<amount; ++i){
            if( value[i]%2==1 ){
                odd++;
            }
        }
        return odd==amount;
    }
    
    public boolean checkDouble(){
        int check = 1;
        int num = value[0];
        for(int i=1; i<amount; ++i){
            if( value[i]==num ){
                check++;
            }
        }
        return check==amount;
    }    
}