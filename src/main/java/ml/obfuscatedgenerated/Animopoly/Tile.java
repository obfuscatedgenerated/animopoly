package ml.obfuscatedgenerated.Animopoly;

public class Tile {
    private int price;
    private int fee;
    private String name;
    private int level = 1;
    private boolean owned = false;
    private Player owner; //THIS IS QUITE BAD

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

    public void setOwned(boolean state, Player owner) {
        this.owned = state;
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        String message;
        if (owned) {
            message = String.format("Name: %S\nFee: %S", name, fee);
        } else {
            message = String.format("Name: %S\nPrice: %S", name, price);
        }
        return message;
    }


}