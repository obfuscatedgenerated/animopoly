package ml.obfuscatedgenerated.Animopoly;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//imports for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deck {
    private Queue<Card> deck = new LinkedList<>(); //create the deck

    public Deck(){
        try{
            String fileName = "card_details.txt";
            BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + fileName)));
            String str;

            List<String> list = new ArrayList<String>();
            while((str = in.readLine()) != null){
                list.add(str);
            }
            in.close();

            for(int i = 0; i < list.size(); i++){
                ArrayList<String> currentDetails = new ArrayList<>(Arrays.asList(list.get(i).split("/")));
                String title = currentDetails.get(0);
                String message = currentDetails.get(1);
                int value = Integer.valueOf(currentDetails.get(2));
                deck.add(new Card(title, message, value));
            }

        }catch(IOException e){
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    public Card draw(){
        Card card = deck.remove();
        deck.add(card); //add it to the back of the deck
        return card;
    }
}