package ml.obfuscatedgenerated.Animopoly;

import java.util.Random;
import java.util.ArrayList;

public class Board {
    private static final Random rng = new Random();;

    public static ArrayList<Integer> dice() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(rng.nextInt(6)+1);
        al.add(rng.nextInt(6)+1);
        return al;
    }

    public static boolean areDoubles(ArrayList<Integer> al) {
        return (al.get(0) == al.get(1));
    }

    public static int sumDice(ArrayList<Integer> al) {
        return al.get(0) + al.get(1);
    }
}
