package ml.obfuscatedgenerated.Animopoly;

public class Tile {
    private int price;
    private int fee;
    private String name;
    private int level = 1;
    private boolean owned = false;

    public Tile(int price, int fee, String name) {
        this.price = price;
        this.fee = fee;
        this.name = name;
    }

    public void increaseLevel() {
        level++;
        fee *= 2;
    }

    public int getPrice() {
        return price;
    }

    public int getFee() {
        return fee;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean state) {
        this.owned = state;
    }

    public String getName() {
        return name;
    }


}