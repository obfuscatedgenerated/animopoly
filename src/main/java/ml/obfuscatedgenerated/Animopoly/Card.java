package ml.obfuscatedgenerated.Animopoly;

public class Card {
    String title;
    String message;
    char type;
    int value;
    public Card(String title, String message, char type, int value){
        this.title = title;
        this.message = message;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        String string = "";
        string += "Title: " + title + "\n";
        string += "Message: " + message + "\n";
        return string;
    }
}
