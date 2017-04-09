package ml;

import ml.player.PlayerList;

public class Bord {

    public Bord(){
        
    }

    public void begin(PlayerList player){
        for (int i = 0; i < player.size(); ++i) {
            player.getPlayer(i).getMoney().setInitialMoney();
            player.getPlayer(i).setPos(0);
        }
    }
    
    public boolean isEndGame(PlayerList player){
        for (int i = 0; i < player.size(); ++i) {
            if ( player.getPlayer(i).isLose() ){
                return true;
            }
        }
        return false;
    }
}