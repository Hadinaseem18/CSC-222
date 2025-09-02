package projects;

import java.util.Random;
import java.util.Scanner;
import projects.ShotType;

/**
 * in this program we are making a points table for one on one basketball game between 2 people
 * 
 * 
 *
 * @author muhammadnaseem
 * @version Mar 24, 2025
 *
 */
public class BasketballGame {

    private static final int totalQuarters = 4;
    private static final int secondsPerQuarter = 720;
    private static final int shotInterval = 30;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method where all the methods are called and there is one print statement
     *
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("Simulating a one on one basketball game");

        String player1 = inputPlayerInfo();
        String player2 = inputPlayerInfo();

        play(player1, player2);
    }

    /**
     * Getting a names of the players
     *
     * @return none
     */
    public static String inputPlayerInfo() {
        while (true) {
            System.out.print("Input name of player: ");
            String name = scanner.nextLine().trim();
            if (name.matches("[a-zA-Z]+")) {
                return name;
            }
            System.out.println("Invalid name. Please enter letters only.");
        }
    }

    private static void play(String player1, String player2) {
        int score1 = 0;
        int score2 = 0;

        for (int quarter = 1; quarter <= totalQuarters; quarter++) {
            System.out.println(
                "\n-------------------------Quarter " + quarter + "-----------------------------");
            for (int time = 0; time < secondsPerQuarter; time += shotInterval) {
                ShotType shot1 = playShot();
                ShotType shot2 = playShot();

                score1 += shotPoints(shot1);
                score2 += shotPoints(shot2);

                displayShot(player1, shot1, player2, shot2);
            }
        }
        displayWinner(player1, score1, player2, score2);
    }

    private static ShotType playShot() {
        return ShotType.values()[random.nextInt(ShotType.values().length)];
    }

    private static int shotPoints(ShotType shot) {
        if (shot == ShotType.AIRBALL)
            return 0;
        if (shot == ShotType.FREETHROW)
            return 1;
        if (shot == ShotType.TWOPOINTER)
            return 2;
        if (shot == ShotType.THREEPOINTER)
            return 3;
        return 0;
    }

    private static void displayShot(String player1, ShotType shot1, String player2,
        ShotType shot2) {
        System.out.printf("%s takes a shot: %s\n", player1, shot1.type);
        System.out.printf("%s takes a shot: %s\n", player2, shot2.type);
    }

    private static void displayWinner(String player1, int score1, String player2, int score2) {

        if (score1 > score2) {
            System.out.println(player1 + " wins with a score of " + score1);
        } else if (score2 > score1) {
            System.out.println(player2 + " wins with a score of " + score2);
        } else {
            System.out.println("It's a tie!");
        }
    }
}
