package ml.obfuscatedgenerated.Animopoly;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;


//imports for JSON

public class Deck {
    private Queue<Card> deck;//create the deck

    public Deck() {
        try {
            // create a reader
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("card_details.json");
            assert is != null;
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

            // convert JSON array to list of cards
            deck = new Gson().fromJson(reader, new TypeToken<LinkedList<Card>>() {
            }.getType());

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        shuffleDeck();
    }

    public Card draw() {
        Card card = deck.remove();
        deck.add(card); //add it to the back of the deck
        return card;
    }

    //is there are point in shuffling the deck instead of just having it as an arraylist that we can randomise?
    //I guess it's more accurate to how actual m̵o̵n̵o̵p̵o̵l̵y̵ animopoly is played.
    public void shuffleDeck() {
        ArrayList<Card> cards = new ArrayList<Card>(deck);
        Collections.shuffle(cards);
        deck = new LinkedList<>(cards);
    }
}