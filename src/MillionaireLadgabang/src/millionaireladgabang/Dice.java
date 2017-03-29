package millionaireladgabang;

public class Dice {
    
    public static int amount_dice = 2;
    public static int amount_side = 6;
    
    private int[] value;
    private int sum;

    public Dice(){
        value = new int[amount_dice];
    }
    
    public int getDice(){
        return sum;
    }
    
    public void randomDice(){
        sum = 0;
        for(int i=0; i<amount_dice; ++i){
            value[i] = Util.randomInt(amount_side);
            sum += value[i];
        }
    }
    
    public boolean isEven(){
        int even = 0;
        for(int i=0; i<amount_dice; ++i){
            if( value[i]%2==0 ){
                even++;
            }
        }
        return even==amount_dice;
    }
    
    public boolean isOdd(){
        int odd = 0;
        for(int i=0; i<amount_dice; ++i){
            if( value[i]%2==1 ){
                odd++;
            }
        }
        return odd==amount_dice;
    }
    
    public boolean isDouble(){
        int check = 1;
        int num = value[0];
        for(int i=1; i<amount_dice; ++i){
            if( value[i]==num ){
                check++;
            }
        }
        return check==amount_dice;
    }    
}