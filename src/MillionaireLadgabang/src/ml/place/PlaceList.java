package ml.place;

import java.util.ArrayList;
import ml.player.Player;

public class PlaceList {

    public static int amount_place = 28;

    private ArrayList<Place> place;
    private ArrayList<Landmark> lanmark;

    public PlaceList() {
        place = new ArrayList();
        lanmark = new ArrayList();
        createPlace();
    }

    public void clear() {
        for (int i = 0; i < amount_place; ++i) {
            place.get(i).clear();
        }
    }

    public void createPlace() {
        place.add(new Place("start", false, new double[]{}, new double[]{}));

        place.add(new Place("ครัวบะช่อ", true, new double[]{-200e3, -300e3, -460e3, -800e3}, new double[]{-200e3, -300e3, -460e3, -600e3}));
        place.add(new Place("จุด 3 จุด", true, new double[]{-270e3, -370e3, -500e3, -1000e3}, new double[]{-270e3, -370e3, -500e3, -700e3}));
        place.add(new Place("มินิเกมส์", false, new double[]{}, new double[]{}));
        place.add(new Place("โคเคชิ", true, new double[]{-400e3, -500e3, -650e3, -1200e3}, new double[]{-400e3, -500e3, -650e3, -800e3}));
        place.add(new Place("โคมริมน้ำ", true, new double[]{-370e3, -570e3, -700e3, -1400e3}, new double[]{-370e3, -570e3, -700e3, -800e3}));
        place.add(new Place("Old Scool", true, new double[]{-460e3, -560e3, -700e3, -1400e3}, new double[]{-460e3, -560e3, -700e3, -820e3}));

        place.add(new Place("งานทะเบียน", false, new double[]{}, new double[]{}));

        place.add(new Place("โกอิน ชาชัก", true, new double[]{-420e3, -550e3, -700e3, -1400e3}, new double[]{-420e3, -550e3, -700e3, -830e3}));
        place.add(new Place("ลาวา", true, new double[]{-470e3, -600e3, -7500e3, -1400e3}, new double[]{-470e3, -600e3, -750e3, -850e3}));
        place.add(new Place("นมมหาลัย", true, new double[]{-550e3, -670e3, -800e3, -1600e3}, new double[]{-550e3, -670e3, -800e3, -900e3}));
        place.add(new Place("การ์ด", false, new double[]{}, new double[]{}));
        place.add(new Place("นมหวาน", true, new double[]{-600e3, -720e3, -850e3, -1600e3}, new double[]{-600e3, -720e3, -850e3, -950e3}));
        place.add(new Place("Butter Beer", true, new double[]{-680e3, -800e3, -950e3, -1800e3}, new double[]{-680e3, -800e3, -950e3, -1050e3}));

        place.add(new Place("วัดปลูกศรัทธา", false, new double[]{}, new double[]{}));

        place.add(new Place("อาทโฮมเพลส", true, new double[]{-710e3, -850e3, -970e3, -1800e3}, new double[]{-710e3, -850e3, -970e3, -1070e3}));
        place.add(new Place("หอดำ", true, new double[]{-770e3, -920e3, -1200e3, -2400e3}, new double[]{-770e3, -920e3, -1200e3, -1500e3}));
        place.add(new Place("U-Place", true, new double[]{-830e3, -1000e3, -1500e3, -3000e3}, new double[]{-830e3, -1000e3, -1500e3, -1800e3}));
        place.add(new Place("หอจรัญ", true, new double[]{-960e3, -1500e3, -2300e3, -4600e3}, new double[]{-960e3, -1500e3, -2300e3, -2700e3}));
        place.add(new Place("ดีนาเพลส", true, new double[]{-1000e3, -2200e3, -3000e3, -6000e3}, new double[]{-1000e3, -2200e3, -3000e3, -3500e3}));
        place.add(new Place("RNP Place", true, new double[]{-960e3, -2200e3, -3000e3, -6000e3}, new double[]{-960e3, -2200e3, -3000e3, -3500e3}));

        place.add(new Place("วินเกกี 4", false, new double[]{}, new double[]{}));

        place.add(new Place("E-bar", true, new double[]{-1100e3, -2400e3, -3200e3, -6400e3}, new double[]{-1100e3, -2400e3, -3200e3, -4000e3}));
        place.add(new Place("Boom Beer Bar", true, new double[]{-1100e3, -2400e3, -3200e3, -6400e3}, new double[]{-1100e3, -2400e3, -3200e3, -4000e3}));
        place.add(new Place("Chic", true, new double[]{-1200e3, -2800e3, -4000e3, -8000e3}, new double[]{-1200e3, -2800e3, -4000e3, -5000e3}));
        place.add(new Place("การ์ด", false, new double[]{}, new double[]{}));
        place.add(new Place("Coma", true, new double[]{-1300e3, -3200e3, -4600e3, -9200e3}, new double[]{-1300e3, -3200e3, -4600e3, -5500e3}));
        place.add(new Place("Bridge Bar", true, new double[]{-1400e3, -5000e3, -5000e3, -10000e3}, new double[]{-1400e3, -3800e3, -5000e3, -6000e3}));

        /*lanmark.add(new Landmark(new int[]{1, 2}, 7e4));
        lanmark.add(new Landmark(new int[]{8, 9}, 7e4));
        lanmark.add(new Landmark(new int[]{15, 16}, 7e4));
        lanmark.add(new Landmark(new int[]{21, 22}, 7e4));*/
    }

    public Place getPlace(int i) {
        return place.get(i);
    }

    public Landmark getLanmark(int i) {
        return lanmark.get(i);
    }

    public boolean isLanmark(int pos) {
        for (int i = 0; i < lanmark.size(); ++i) {
            for (int j = 0; j < lanmark.get(i).getIndexPlace().length; ++j) {
                if (pos == lanmark.get(i).getIndexPlace()[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getIndexLanmark(int pos) {
        for (int i = 0; i < lanmark.size(); ++i) {
            for (int j = 0; j < lanmark.get(i).getIndexPlace().length; ++j) {
                if (pos == lanmark.get(i).getIndexPlace()[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return amount_place;
    }
}
