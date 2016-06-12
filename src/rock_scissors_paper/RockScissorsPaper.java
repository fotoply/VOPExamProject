package rock_scissors_paper;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
    public final static String[] HAND_TYPES = new String[]{"Sten", "Saks", "Papir"};
    private String playersHand;
    private String computersHand;

    public static void main(String[] args) {
        RockScissorsPaper rockScissorsPaper = new RockScissorsPaper();
        boolean finished = false;
        while (!finished) {
            System.out.println(" Vælg [0]Sten, [1]Saks eller [2]Papir");
            Scanner input = new Scanner(System.in);
            String playerInput = input.next();
            if(isAHandType(playerInput)) {
                rockScissorsPaper.play(getHandType(playerInput));
            } else {
                finished = true;
            }
            if (!finished) {
                System.out.printf("Valgte tegn: %n[Dig]  %s%n[Comp] %s%n", rockScissorsPaper.getPlayersHand(), rockScissorsPaper.getComputersHand());
                System.out.println(rockScissorsPaper.getWinner());
            } else {
                System.out.println("Spillet afslutes");
            }
        }
    }

    private static boolean isAHandType(String playerInput) {
        try {
            if (Integer.parseInt(playerInput) >= 0 && Integer.parseInt(playerInput) <= 2) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String getHandType(String input) {
        if(isAHandType(input)) {
            return HAND_TYPES[Integer.parseInt(input)];
        } else {
            throw new IllegalArgumentException("Hand type does not exist");
        }
    }

    /**
     * Gets the winner of the previous game that was executed using the <i>play</i> method.
     * @return A string describing who the winner is
     */
    public String getWinner() {
        if (willBeat(playersHand, computersHand)) {
            return "Du vinder!";
        } else if (willBeat(computersHand, playersHand)) {
            return "Computeren vinder!";
        } else {
            return "Uafgjort!";
        }
    }

    private boolean willBeat(String hand, String handToBeat) {
        if (hand.equalsIgnoreCase(handToBeat)) {
            return false;
        }

        if (hand.equalsIgnoreCase("Sten") && handToBeat.equalsIgnoreCase("Saks")) {
            return true;
        } else if (hand.equalsIgnoreCase("Saks") && handToBeat.equalsIgnoreCase("Papir")) {
            return true;
        } else if (hand.equalsIgnoreCase("Papir") && handToBeat.equalsIgnoreCase("Sten")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Plays 1 game of Rock-Paper-Scissors. Computer randomly chooses a hand.
     * @param playersHand The hand the player has chosen to play
     */
    public void play(String playersHand) {
        this.playersHand = playersHand;
        Random rnd = new Random();
        this.computersHand = HAND_TYPES[rnd.nextInt(HAND_TYPES.length)];
    }

    /**
     * Gets the hand-sign the computer chose.
     * @return
     */
    public String getComputersHand() {
        return computersHand;
    }

    /**
     * Gets the hand-sign the player chose.
     * @return
     */
    public String getPlayersHand() {
        return playersHand;
    }
}
