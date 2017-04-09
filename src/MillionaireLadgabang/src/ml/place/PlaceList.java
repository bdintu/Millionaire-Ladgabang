package ml.place;

import java.util.ArrayList;
import ml.player.Player;

public class PlaceList {
    
    
    private ArrayList<Place> place;
    private ArrayList<LandMark> lanmark;
    
    public PlaceList(){
        place = new ArrayList();
        lanmark = new ArrayList();
        createPlace();
    }
    
    public void createPlace(){
        place.add( new Place("start", new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add( new Place("วัดเกfdfกี", new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        place.add( new Place("วัดเdfdกกี", new double[]{2e3, 3e3, 5e3}, new double[]{2e3, 3e3, 5e3}));
        
        lanmark.add(new LandMark(new int[]{1,2}, 7e4));
    }
    
    public Place getPlace(int i) {
        return place.get(i);
    }
    
    public int size(){
        return amount_place;
    }
}