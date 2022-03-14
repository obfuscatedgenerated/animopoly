package ml.obfuscatedgenerated.Animopoly;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class Board {
    private static final Random rng = new Random();
    private static ArrayList<Tile> tiles = new ArrayList<Tile>();

    public static void init() {
        // create a reader
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("Animals.txt");
        assert is != null;
        Reader reader = new InputStreamReader(is);
        try (BufferedReader breader = new BufferedReader(reader)) {
            int index = 1;
            while (breader.ready()) {
                String line = breader.readLine();
                int price = (int) (100 * Math.ceil(0.2 * index));
                tiles.add(new Tile(price, price / 10, line));
                index++;
            }
            breader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> dice() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(rng.nextInt(6) + 1);
        al.add(rng.nextInt(6) + 1);
        return al;
    }

    public static boolean areDoubles(ArrayList<Integer> al) {
        return (al.get(0) == al.get(1));
    }

    public static int sumDice(ArrayList<Integer> al) {
        return al.get(0) + al.get(1);
    }

    public static Tile getTile(int index) {
        return tiles.get(index);
    }
}
