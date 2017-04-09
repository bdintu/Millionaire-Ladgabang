package ml.place;

import java.util.ArrayList;
import ml.player.Player;

public class PlaceList {

    public static int amount_place = 28;

    private ArrayList<Place> place;
    private ArrayList<LandMark> lanmark;

    public PlaceList() {
        place = new ArrayList();
        lanmark = new ArrayList();
        createPlace();
    }

    public void createPlace() {
        place.add(new Place("start", false, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("วัดเกfdfกี", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("วัดเdfdกกี", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));

        lanmark.add(new LandMark(new int[]{1, 2}, 7e4));
    }

    public Place getPlace(int i) {
        return place.get(i);
    }

    public int size() {
        return amount_place;
    }
}
