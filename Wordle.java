import java.util.Scanner;

public class Wordle {
  public static void main(String[] args) {
    char[] SecretWord = { 'T', 'R', 'A', 'S', 'H' };
    Scanner s = new Scanner(System.in);

    System.out.println("Enter your first guess, one letter on each line");
    char[] guesses = { s.next().charAt(0), s.next().charAt(0), s.next().charAt(0), s.next().charAt(0),
        s.next().charAt(0) };

    System.out.println("Here is feedback on your guess:");

    /************
     * TO DO:
     * 1. Write some code that compares each letter in the guess
     * To each letter in the SecretWord
     * 2. For each letter in the guess, print out one of these messages:
     * - "This char is correct!"
     * - "This char is in the word, but not in the correct position"
     * - "This char is not in the word"
     * 3. Put this whole thing in a loop - allow 6 guesses
     */

    for (int i = 0; i < SecretWord.length; i++) {
      char guess = guesses[i];
      char c = SecretWord[i];

      if (String.valueOf(c).equals(String.valueOf(guess))) {
        System.out.println("\"" + guess + "\"" + " is correct!");
      } else if (String.valueOf(SecretWord).contains(String.valueOf(guess))) {
        System.out.println("\"" + guess + "\"" + " is in the word, but not in the correct position");
      } else {
        System.out.println("\"" + guess + "\"" + " is not in the word");
      }
    }
  }
}