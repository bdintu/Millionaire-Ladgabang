package millionaireladgabang;

public class DiceTest {

    public static void main(String[] argv) {
        
        Dice dice = new Dice();
        dice.randomDice();
        
        System.out.println(dice.getDice());
    }
}
