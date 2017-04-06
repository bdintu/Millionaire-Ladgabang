package ml.player;

public class Money {

    private final int start_money = (int) 3e6;
    private final int money_per_round = (int) 2e5;

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

    public int getMoney() {
        return amount;
    }
}
