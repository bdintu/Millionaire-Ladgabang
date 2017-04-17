package ml.card;

import ml.player.Player;

public class SetPos extends Card {

    private int pos;

    public SetPos(String name, String detail, boolean now, int pos) {
        super(name, detail, now);
        this.pos = pos;
    }

    public void effect(Player player) {
        player.setPos(pos, player);
    }
}
