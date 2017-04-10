package ml.place;

import ml.player.Player;

public class LandMark {

    public static int amount_lanmark = 4;
    public static int amount_lanmark_member = 2;

    private int[] index_place;
    private int owner;
    private double price;

    public LandMark(int[] index_place, double price) {
        this.index_place = index_place;
        this.price = price;
        this.owner = -1;
    }

    public boolean checkOwner(PlaceList place, Player player) {
        for (int i = 0; i < amount_lanmark_member; ++i) {
            if (place.getPlace(i).getOwner() != player.getId()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkMaxLevel(PlaceList place, Player player) {
        for (int i = 0; i < amount_lanmark_member; ++i) {
            if (!place.getPlace(i).isMaxLevel()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBuyLandMark(Player player) {
        if (player.getMoney().checkMoney(price)) {
            return true;
        } else {
            return false;
        }
    }

    public void buyLanmark(Player player) {
        player.getMoney().addMoney(price);
        this.owner = player.getId();
    }
}
