package ml.obfuscatedgenerated.Animopoly;

public class Tile {
    private int price;
    private int fee;
    private String name;
    private int level;
    private boolean owned;

    public Tile(int price, int fee, String name){
        this.price = price;
        this.fee = fee;
        this.name = name;
        this.level = 1;
    }
    public void increaseLevel(){
        level++;
        fee *= 2;
    }

    public void setOwned(boolean state){
        this.owned = state;
    }

    public String getName(){
        return name;
    }


}