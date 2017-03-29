package millionaireladgabang.Dice;

public class Tester {

    public static void main(String[] argv) {

        // Standate Dice
        Standate dice_std = new Standate();
        System.out.print("Standate Random : ");
        System.out.println(dice_std.getStandate());
        
        // Hight/Low Dice
        HightLow dice_hightlow = new HightLow();
        System.out.print("Standate Random : ");
        System.out.println(dice_hightlow.isHighLow(true));

    }
}