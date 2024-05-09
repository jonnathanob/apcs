public class abs {
  public static void main(String[] args) {
    System.out.println(absv(-10));
  }

  static int absv(int x) {
    if (x < 0)
      return x * -1;
    return x;
  }
}
