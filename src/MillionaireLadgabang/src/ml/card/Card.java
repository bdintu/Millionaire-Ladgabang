package ml.card;

public abstract class Card {

    private String name;
    private String detail;
    private boolean now;

    public Card(String name, String detail, boolean now) {
        this.name = name;
        this.detail = detail;
        this.now = now;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public boolean isNow() {
        return now;
    }
}
