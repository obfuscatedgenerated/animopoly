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

    public void setOwned(boolean state) {
        this.owned = state;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        String message = "";
        message += "+================================+\n";
        if (owned) {
            message += String.format("Name: %S\nFee: §%S", name, fee);
        } else {
            if (price != 0) {
                message += String.format("Name: %S\nPrice: §%S", name, price);
            } else {
                message += name;
            }
        }
        message += "\n+================================+";
        return message;
    }


    public String getName() {
        return name;
    }
}