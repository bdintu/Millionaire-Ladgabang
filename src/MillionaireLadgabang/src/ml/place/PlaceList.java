package ml.place;

import java.util.ArrayList;
import ml.player.Player;

public class PlaceList {

    public static int amount_side = 4;
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
        
        place.add(new Place("ครัวบะช่อ", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("จุด 3 จุด", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("โคเคชิ", false, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("โคมริมน้ำ", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("Old Scool", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a6", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("งานทะเบียน", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("โกอิน ชาชัก", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("ลาวา", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("นมมหาลัย", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("นมหวาน", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a12", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a13", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("วีดปลูกศรัทธา", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("a15", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("หอดำ", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a16", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a17", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a18", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a19", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("วินเกกี 4", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        place.add(new Place("E-bar", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a22", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("Chic", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("Coma", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("Bridge Bar", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add(new Place("a27", true, new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));

        lanmark.add(new LandMark(new int[]{1, 2}, 7e4));
        lanmark.add(new LandMark(new int[]{8, 9}, 7e4));
        lanmark.add(new LandMark(new int[]{15, 16}, 7e4));
        lanmark.add(new LandMark(new int[]{21, 22}, 7e4));
    }

    public Place getPlace(int i) {
        return place.get(i);
    }
    
    public Place getPlace(Player player) {
        return place.get(player.getId());
    }

    public int size() {
        return amount_place;
    }
}
