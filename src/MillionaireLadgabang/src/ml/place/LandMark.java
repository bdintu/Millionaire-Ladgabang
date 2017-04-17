package ml.place;

import ml.player.Player;

public class Landmark {

    public static int amount_lanmark = 4;
    public static int amount_lanmark_member = 2;

    private int[] index_place;
    private int owner;
    private double price;

    public Landmark(int[] index_place, double price) {
        this.index_place = index_place;
        this.price = price;
        this.owner = -1;
    }

    public boolean isOwner(PlaceList place, Player player) {
        for (int i = 0; i < amount_lanmark_member; ++i) {
            if (place.getPlace(i).getOwner() != player.getId()) {
                return false;
            }
        }
        return true;
    }

    public boolean isMaxLevel(PlaceList place, Player player) {
        for (int i = 0; i < amount_lanmark_member; ++i) {
            if (place.getPlace(i).isNotMaxLevel()) {
                return false;
            }
        }
        return true;
    }

    public boolean canBuyLandMark(Player player) {
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

    public void changeToll(PlaceList place) {
        for (int i = 0; i < index_place.length; ++i) {
            place.getPlace(index_place[i]).setToll(3, price);
        }
    }

    public int[] getIndexPlace() {
        return index_place;
    }
}
