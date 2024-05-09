import java.util.Scanner;

public class PrimitiveMath {
  public static void main(String[] args) {
    changeCalc();
  }

  private static void changeCalc() {
    Scanner s = new Scanner(System.in);

    System.out.println("How much change do you want?");

    float totalChange = s.nextFloat();

    int totalChangeInCents = (int) (totalChange * 100);
    int dollars = totalChangeInCents / 100;
    int changeRemaining = totalChangeInCents % 100;

    int quarters = changeRemaining / 25;
    changeRemaining %= 25;

    int dimes = changeRemaining / 10;
    changeRemaining %= 10;

    int nickels = changeRemaining / 5;
    changeRemaining %= 5;

    System.out.println("Total Change: " + totalChange);
    System.out.println("Total Cents: " + totalChangeInCents);
    System.out.println("Dollars: " + dollars);
    System.out.println("Quarters: " + quarters);
    System.out.println("Dimes: " + dimes);
    System.out.println("Nickels: " + nickels);
    System.out.println("Remaining Cents: " + changeRemaining);

    s.close();
  }
}
