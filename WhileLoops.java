import java.util.Scanner;

public class WhileLoops {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Guess a number: ");

    int number = s.nextInt();
    int tries = 0;

    while (number != 100 || tries < 3) {
      System.out.println("Wrong!! ");
      number = s.nextInt();
      tries++;
    }

    s.close();
  }
}
