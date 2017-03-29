package millionaireladgabang.Dice;

public class Double extends Dice {
   
    public boolean isDouble(){
        int check = 1;
        int num = points_dice[0];
        for(int i=1; i<amount_dice; ++i){
            if( points_dice[i]==num ){
                check++;
            }
        }
        return check==amount_dice;
    }
}
