package ml.obfuscatedgenerated.Animopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static final int starterMoney = 500;
    private static ArrayList<Player> players = new ArrayList<Player>();

    private static final Deck deck = new Deck();

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void drawCard(Player actor) {
        Card card = deck.draw();
        System.out.println(card);
        switch (card.getType()) {
            case 'M':
                actor.move(card.getValue());
                break;
            case 'W':
                actor.changeWallet(card.getValue());
                break;
            case 'V':
                //PLACEHOLDER THAT JUST REMOVES EVERYONE'S MONEY
                //ASSUMING ARRAY OF ALL PLAYERS EXISTS
                for (Player player : players) {
                    player.setMoney(0);
                }
                break;
            case 'L':
                actor.setMoney(0);
                break;
        }
    }

    public static void main(String[] args) {
        Board.init();

        Scanner scanner = new Scanner(System.in);

        int playerCount = 0;
        while (true) { // keep asking until the input is valid
            System.out.println("How many players will be in this game? (Enter 2-4)");
            try {
                playerCount = Integer.parseInt(scanner.nextLine());
                if (playerCount < 2 || playerCount > 4) {
                    System.out.println("That player count is not allowed.\n");
                    continue; // ask again
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input is not a number.\n");
                continue; // ask again
            }
        }

        // temporary arraylists just to prevent reusing names/tokens without having to iter over players
        ArrayList<String> takenNames = new ArrayList<String>();
        ArrayList<Character> takenTokens = new ArrayList<Character>();

        for (int i : IntStream.range(0, playerCount).toArray()) { // iter over the players
            String holdName = "";
            Character holdToken = 0;
            while (true) { // keep asking until the input is valid
                System.out.println("Player " + (i + 1) + ", enter your name (between 1-10 characters):");
                holdName = scanner.nextLine();
                if (holdName.length() < 1 || holdName.length() > 10) {
                    System.out.println("Name length is invalid.\n");
                    continue; // ask again
                }
                if (takenNames.contains(holdName)) {
                    System.out.println("Name already in use.\n");
                    continue; // ask again
                }
                takenNames.add(holdName);
                break;
            }
            while (true) { // keep asking until the input is valid
                System.out.println("Player " + (i + 1) + ", enter your token (single character):");
                String preholdToken = scanner.nextLine();
                if (preholdToken.length() != 1) {
                    System.out.println("Token length is invalid.\n");
                    continue; // ask again
                }
                holdToken = preholdToken.charAt(0); // grab the first character as a char
                if (takenTokens.contains(holdToken)) {
                    System.out.println("Token already in use.\n");
                    continue; // ask again
                }
                takenTokens.add(holdToken);
                break;
            }
            players.add(new Player(holdName, starterMoney, holdToken)); // add the player to the arraylist
        }
        scanner.close();
    }
}
