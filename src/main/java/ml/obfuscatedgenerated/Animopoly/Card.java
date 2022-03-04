package ml.obfuscatedgenerated.Animopoly;

public class Card {
    private String title = null;
    private String message = null;
    private int value = 0;

    public Card(String title, String message, int value) {
        this.title = title;
        this.message = message;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
