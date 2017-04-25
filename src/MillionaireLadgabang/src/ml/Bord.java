package ml;

import ml.player.PlayerList;

public class Bord {

    public Bord() {
    }

    public void begin(PlayerList player) {

        for (int i = 0; i < player.size(); ++i) {
            player.getPlayer(i).getMoney().setInitialMoney();
            player.getPlayer(i).setPos(0, player.getPlayer(i));
        }

    }

    public boolean haveContinueGame(PlayerList player) {

        if (player.getCurrentTurn() == player.getMaxTurn()) {
            return false;
        }

        int amount_loser = 0;
        for (int i = 0; i < player.size(); ++i) {
            if (player.getPlayer(i).isLose() || player.getPlayer(i).getMoney().getMoney() < 1e6 ) {
                ++amount_loser;
            }
        }
        if (player.size() - amount_loser == 1) {
            return false;
        }

        return true;
    }
}
