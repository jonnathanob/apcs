import java.util.Scanner;

public class DartPointSystem {
  // Colors for the console
  // black, red, green, yellow, blue, purple, cyan, white
  static String[] colors = { "\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m",
      "\u001B[37m" };

  static Scanner scanner = new Scanner(System.in);

  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) {
    // get number of players
    int numOfPlayer = getNumberOfPlayers();
    // get number of rounds (double :p)
    double numOfRounds = getNumOfRounds();

    // array that is length of the number of players
    int[] points = new int[numOfPlayer];
    float[] roundLengths = new float[(int) numOfRounds];

    /*
     * loop through the number of rounds and run the "round function".
     * Also prints out how long the round was and compares it to the round before it
     * if any
     */
    for (int i = 0; i < numOfRounds; i++) {
      System.out.println("-".repeat(41));
      round(numOfPlayer, points);
      roundLengths[i] = getRoundLength();
      String endOfString = "";
      if (i != 0) {
        if (roundLengths[i] > roundLengths[i - 1]) {
          endOfString = " (longer then the round before)";
        } else if (roundLengths[i] < roundLengths[i - 1]) {
          endOfString = " (shorter then the round before)";
        } else if (roundLengths[i] == roundLengths[i - 1]) {
          endOfString = " (same as the round before)";
        }
      }
      System.out.println(ANSI_RESET + "This round was " + roundLengths[i] + " seconds" + endOfString);
    }

    scanner.close();
  }

  /*
   * This function just runs a round
   * It loops through the number of players to get how many point they got (3
   * throws)
   * Then it prints out a scoreboard for the round
   */
  private static void round(int numOfPlayer, int[] points) {
    for (int i = 0; i < numOfPlayer; i++) {
      System.out.println(colors[i % colors.length] + "Player " + (i + 1));

      points[i] += getScore(1);
      points[i] += getScore(2);
      points[i] += getScore(3);
    }

    System.out.println(ANSI_RESET + "-".repeat(41));
    System.out.println("|\t\tScoreboard\t\t|");
    System.out.println(ANSI_RESET + "-".repeat(41));
    System.out.println("|\tPlayer\t\t|\tScore\t|");
    System.out.println("-".repeat(41));
    for (int i = 0; i < points.length; i++) {
      System.out.println(ANSI_RESET + output(i + 1, points[i]));
      System.out.println("-".repeat(41));
    }
  }

  // get the round length (float)
  static float getRoundLength() {
    System.out.print("How long was this round? (in seconds) ");

    float roundLength = scanner.nextFloat();

    return roundLength;
  }

  // just a simple function to lay out the scoreboard
  static String output(int player, int score) {
    return colors[player - 1] + "|\tPlayer " + player + " \t|\t " + (301 - score) + "\t|" + ANSI_RESET;
  }

  // ask for user input to get a score
  static int getScore(int throwCount) {
    System.out.print("How many points? (throw " + throwCount + "): ");

    int points = scanner.nextInt();

    return points;
  }

  // ask for the number of player
  static int getNumberOfPlayers() {
    System.out.print("How many players? ");

    int players = scanner.nextInt();

    return players;
  }

  // ask for the number of rounds
  static double getNumOfRounds() {
    System.out.print("How many rounds? ");

    int rounds = scanner.nextInt();

    return rounds;
  }
}
