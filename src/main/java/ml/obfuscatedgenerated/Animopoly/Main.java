package ml.obfuscatedgenerated.Animopoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Random;

import static java.lang.Character.toUpperCase;

public class Main {
    private static final int starterMoney = 1500;
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
            case 'S':
                Player switcher = players.get(new Random().nextInt(players.size() - 1));
                int temp = actor.getMoney();
                actor.setMoney(switcher.getMoney());
                switcher.setMoney(temp);
                System.out.println("You have switched with " + switcher);
            case 'V':
                for (Player player : players) {
                    if (player != actor) {
                        player.setMoney(0);
                    }
                }
                break;
            case 'L':
                actor.setMoney(0);
                break;
            default:
                throw new IllegalArgumentException(card.getType() + " is not a valid card type");
        }
    }

    public static void main(String[] args) {
        Board.init();

        BoardPrinter bp = new BoardPrinter();

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
        int currPlayer = 0;
        while (true) { // repeat until the game ends
            System.out.println(bp.renderBoard());
            Player p = players.get(currPlayer);
            if (!p.getCanMove()) {
                System.out.println("LOL! Not allowed to move :(");
                p.setCanMove(true);
                continue;
            }
            System.out.println("Player " + (currPlayer + 1) + " (" + p.getName() + ") rolling...");
            ArrayList<Integer> diceValue = Board.dice();
            System.out.println(diceValue.get(0) + ", " + diceValue.get(1));
            bp.unsetSpace("ZABCDEFGHIJKLMNOPQRSTUVWXY".charAt(p.getPos()));
            int move = Board.sumDice(diceValue);
            System.out.println("Total: " + move);
            if (Board.areDoubles(diceValue)) {
                System.out.println("DOUBLES! Drawing a card...");
                drawCard(p);
            }
            p.move(move);
            bp.setSpaceToken("ZABCDEFGHIJKLMNOPQRSTUVWXY".charAt(p.getPos()), p.getToken());
            if (p.getPos() == 13) { p.setCanMove(false); };
            Tile currentTile = Board.getTile(p.getPos());
            System.out.println(currentTile);
            if (currentTile.isOwned() && currentTile.getOwner() != p) {
                p.changeWallet(-currentTile.getFee());
                currentTile.getOwner().changeWallet(currentTile.getFee());
                System.out.println("You owe " + currentTile.getOwner() + " " + currentTile.getPrice() + ".");
            } else if (currentTile.getOwner() == p) {
                System.out.println("Would you like to upgrade this tile? [Y/N]");
                System.out.println("Cost: " + currentTile.getPrice());
                char input;
                while (true) {
                    try {
                        input = toUpperCase(scanner.nextLine().charAt(0));
                        if (input == 'Y' || input == 'N') {
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Invalid input.");
                    }
                }
                if (input == 'Y' && (p.getMoney() - currentTile.getPrice()) > 0) {
                    currentTile.increaseLevel();
                } else if (input == 'Y' && (p.getMoney() - currentTile.getPrice()) <= 0) {
                    System.out.println("You do not have enough money to upgrade this tile!");
                }
            } else {
                System.out.println("Would you like to purchase this tile? [Y/N]");
                char input;
                while (true) {
                    try {
                        input = toUpperCase(scanner.nextLine().charAt(0));
                        if (input == 'Y' || input == 'N') {
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Invalid input.");
                    }
                }
                if (input == 'Y' && (p.getMoney() - currentTile.getPrice()) > 0) {
                    currentTile.setOwned(true, p);
                } else if (input == 'Y' && (p.getMoney() - currentTile.getPrice()) <= 0) {
                    System.out.println("You do not have enough money to purchase this tile!");
                }
            }
            // count losing players, get non-losers
            int deadPlayers = 0;
            ArrayList<Player> notDead = new ArrayList<Player>();
            for (Player player : getPlayers()) {
                if (player.getMoney() <= 0) {
                    deadPlayers++;
                } else {
                    notDead.add(player);
                }
            }
            // if there are 1 less losing players than the player count, get the 1st and only non-loser
            if ((deadPlayers + 1) == playerCount) {
                Player winner = notDead.get(0);
                System.out.println(winner.getName() + " is the winner!");
                break;
            }
            // go to next player
            if (currPlayer == (playerCount - 1)) {
                currPlayer = 0;
            } else {
                currPlayer++;
            }
        }
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}