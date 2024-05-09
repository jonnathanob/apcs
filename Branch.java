import java.util.Scanner;

public class Branch {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Guess a number");
    int a = s.nextInt();
    int b = s.nextInt();
    int c = s.nextInt();

    if (a < b && a < c) {
      System.out.println(a);
    }
  }
}
