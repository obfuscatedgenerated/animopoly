package ml.obfuscatedgenerated.Animopoly;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int pos = 0;
    private char token;
    private ArrayList<Tile> ownedTiles = new ArrayList<Tile>();

    public Player(String name, int money, char token) {
        this.name = name;
        this.money = money;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public boolean owns(Tile tile) {
        return ownedTiles.contains(tile);
    }

    public void addTile(Tile tile) {
        ownedTiles.add(tile);
    }

    public void removeTile(Tile tile) {
        ownedTiles.remove(tile);
    }

    public void changeWallet(int value) {
        money += value;
    }

    public void setMoney(int value) {
        money = value;
    }

    public int getMoney() {
        return money;
    }

    public void move(int move) {
        if (this.pos + move < 26) {
            pos += move;
        } else {
            pos += (move - 26);
        }
    }

    public int getPos() {
        return pos;
    }

    public char getToken() {
        return token;
    }

    @Override
    public String toString() {
        String message;
        message = String.format("%s [%c]", name, token);
        return message;
    }
}