package ml.player;

public class Money {

    public static int start_money = (int) 3e6;
    public static int money_per_round = (int) 2e5;

    private int amount;

    public Money() {
        amount = 0;
    }

    public void startMoney() {
        this.amount = start_money;
    }

    public void addMoneyPerRound() {
        this.amount += money_per_round;
    }

    public void addMoney(int amount) {
        if (isMoneyEmpty()) {
            this.amount += amount;
        }
    }

    public boolean isMoneyEmpty() {
        return amount > 0;
    }

    public int getAmount() {
        return amount;
    }
}
