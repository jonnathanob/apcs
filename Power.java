import java.util.Scanner;

/**
 * Computes x^n (x raised to the nth power). Although the value
 * of x can be positive or negative, the value of the integer n
 * should be non-negative.
 * 
 * Input: x, the double value to be raised to the nth power.
 * Input: n, the integer value to which x is to be raised.
 * Output: x^n -- the value of x raised to the nth power.
 */
public class Power {
  public static void main(String[] args) {
    // Read value for n
    Scanner in = new Scanner(System.in);
    double x = in.nextDouble();
    int n = in.nextInt();

    // your work here

    double power = x;

    for (int i = 0; i < n; i++) {
      power *= x;
    }

    System.out.println(power);
  }
}