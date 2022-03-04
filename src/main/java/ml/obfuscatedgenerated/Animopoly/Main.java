package ml.obfuscatedgenerated.Animopoly;

public class Main {
    public static void main(String[] args) {
        System.out.println(Board.areDoubles(Board.dice()));
        Deck deck = new Deck();
        System.out.println(deck.draw());
    }
}
