package ml.obfuscatedgenerated.Animopoly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board.init();
        System.out.println(Board.areDoubles(Board.dice()));
        Deck deck = new Deck();

        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Draw card. \n(2) Shuffle deck \n(3) bruh");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                Card card = deck.draw();
                System.out.println(card);
                System.out.println(card.value);
            case 2:
                deck.shuffleDeck();
            case 3:
                Tile tile = new Tile(1,1,"bruh");
                System.out.println(tile.getName());

        }

        scanner.close();
    }
}
