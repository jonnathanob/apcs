import java.util.Scanner;

public class Digits {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Type a number: ");
    int num = s.nextInt();

    while (num != 0) {
      System.out.println(num % 10);
      num /= 10;
    }

    s.close();
  }
}
