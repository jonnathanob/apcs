import java.util.Scanner;

public class AreaRect {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter length of rectangle: ");
    float length = scanner.nextFloat();

    System.out.println("Enter width of rectangle: ");
    float width = scanner.nextFloat();

    System.out.println("The area the rectangle is " + length * width);

    scanner.close();
  }
}
