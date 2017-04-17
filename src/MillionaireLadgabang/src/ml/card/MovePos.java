package ml.card;

import ml.player.Player;

public class MovePos extends Card {

    private int pos;

    public MovePos(String name, String detail, boolean now, int pos) {
        super(name, detail, now);
        this.pos = pos;
    }

    public void effect(Player player) {
        player.movePos(pos, player);
    }
}
