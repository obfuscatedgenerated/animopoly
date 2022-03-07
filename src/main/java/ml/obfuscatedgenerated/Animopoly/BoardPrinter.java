package ml.obfuscatedgenerated.Animopoly;

import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class BoardPrinter {
    // board using apache commons text template literals
    private String boardTemplate = "+-----------------------------------------------------------------------------------------+\n" +
            "| Ztart   |Anteater |  Bee    |Crocodile|  Dog    |Elephant |Friendly |  Goat   |  Horse  |\n" +
            "|         |         |         |         |         |         |crocodile|         |         |\n" +
            "|§200/§400|         |         |         |         |         |         |         |         |\n" +
            "|    ${Z_token}    |    ${A_token}    |    ${B_token}    |    ${C_token}    |    ${D_token}    |    ${E_token}    |    ${F_token}    |    ${G_token}    |    ${H_token}    |\n" +
            "|---------+---------------------------------------------------------------------+---------|\n" +
            "|  Yak    |                                                                     | Iguana  |\n" +
            "|         |                                                                     |         |\n" +
            "|         |                    +---------------------------------------------+  |         |\n" +
            "|    ${Y_token}    |                    |           Prices of the Animals             |  |   ${I_token}    |\n" +
            "|---------|                    +---------------------------------------------+  |---------|\n" +
            "|  Xerus  |    /----------\\    | 1st 5 animals: Buy: §100, Rent: §10/20/50   |  |Jumping  |\n" +
            "|         |    |          |    |     (A,B,C,D,E)                             |  |Kangaroo |\n" +
            "|         |    |          |    | 2nd 5 animals: Buy: §200, Rent: §20/40/100  |  |         |\n" +
            "|    ${X_token}    |    |          |    |     (F,G,H,I,J)                             |  |    ${J_token}    |\n" +
            "|---------|    |  Cards   |    | 3rd 4 animals: Buy: §300, Rent: §30/60/150  |  |---------|\n" +
            "| Wiggley |    |          |    |     (K,L,N,O)                               |  |Kangaroo |\n" +
            "|  Worm   |    |          |    | 4th 5 animals: Buy: §400, Rent: §40/80/200  |  |         |\n" +
            "|         |    |          |    |     (P,Q,R,S,T)                             |  |         |\n" +
            "|    ${W_token}    |    \\----------/    | 5th 5 animals: Buy: §500, Rent: §50/100/250 |  |    ${K_token}    |\n" +
            "|---------|                    |     (U,V,W,X,Y)                             |  |---------|\n" +
            "|Very big |                    +---------------------------------------------+  | Le mure |\n" +
            "|Elephant |                                                                     |         |\n" +
            "|         |                                                                     |         |\n" +
            "|    ${V_token}    |                                                                     |    ${L_token}    |\n" +
            "|---------+---------------------------------------------------------------------+---------|\n" +
            "|   Un-   |  Tiger  |  Snake  | Rabbit  |Quacking | Penguin | Octopus |  Nut    | Miss a  |\n" +
            "|friendly |         |         |         |  Duck   |         |         |         |  Turn   |\n" +
            "|crocodile|         |         |         |         |         |         |         |   :(    |\n" +
            "|    ${U_token}    |    ${T_token}    |    ${S_token}    |    ${R_token}    |    ${Q_token}    |    ${P_token}    |    ${O_token}    |    ${N_token}    |    ${M_token}    |\n" +
            "+-----------------------------------------------------------------------------------------+";

    // init literal map
    private Map<String, String> valuesMap = new HashMap<String, String>();

    private char[] allUppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public BoardPrinter() {
        // define empty for all board spaces
        for (int i : IntStream.range(0, 26).toArray()) {
            valuesMap.put(allUppers[i]+"_token"," ");
        }
    }

    public String renderBoard() {
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        return sub.replace(boardTemplate);
    }

    public void setSpaceToken(Character space, Character token) {
        if (!List.of(allUppers).contains(space)) {
            throw new IllegalArgumentException("invalid space char. must be a single uppercase letter char corresponding to the space.");
        }
        valuesMap.replace(space+"_token",Character.toString(token));
    }

    public void unsetSpace(Character space) {
        if (!List.of(allUppers).contains(space)) {
            throw new IllegalArgumentException("invalid space char. must be a single uppercase letter char corresponding to the space.");
        }
        valuesMap.replace(space+"_token"," ");
    }
}
