import java.util.Scanner;

/**
 * This is a calculator for quadratic function, linear function, annnnnnddddd
 * compound interest.
 * 
 * This is a whole lot of
 * Classes, methods, try catch.
 */

public class CalculatorProject {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean done = false;

    // while loop here forever until the types in false
    while (!done) {
      int option = askForEquation();
      if (option == 0) {
        new Quadratic().start();
      } else if (option == 1) {
        new Linear().start();
      } else if (option == 2) {
        new CompoundInterest().start();
      }

      System.out.println("Use a different equation? (true/false)");

      while (true) {
        try {
          done = !scanner.nextBoolean();
          break;
        } catch (Exception e) {
          scanner.next();
          System.out.println("Not a valid options try again");
        }
      }
    }
  }

  static int askForEquation() {
    boolean good = false;
    int option = 0;

    System.out.println("What equation would you like to do?");
    System.out.println("(0) quadratic");
    System.out.println("(1) linear");
    System.out.println("(2) compound interest");

    while (!good) {
      try {
        option = scanner.nextInt();
        if (option <= 2) {
          good = true;
        } else {
          throw new Exception("invalid number");
        }
      } catch (Exception e) {
        if (!e.getMessage().equals("invalid number")) {
          scanner.next();
        }
        System.out.println("Not a valid number try again");
      }
    }

    return option;
  }
}

/**
 * Why would classes?
 * Just to separate logic and organize it
 */

class Quadratic {
  private Scanner scanner = new Scanner(System.in);
  double a = Double.NaN;
  double b = Double.NaN;
  double c = Double.NaN;

  public void start() {
    defineVars();
    boolean done = false;

    while (!done) {
      var option = askForOptions();
      if (option == 0) {
        System.out.println("The y is: " + findY());
      } else if (option == 1) {
        double[] x = findX();
        System.out.println("The x(s) are: " + x[0] + ", " + x[1]);
      } else if (option == 2) {
        System.out.println(findVertex());
      }

      System.out.println("Continue? (true/false)");

      while (true) {
        try {
          done = !scanner.nextBoolean();
          break;
        } catch (Exception e) {
          scanner.next();
          System.out.println("Not a valid options try again");
        }
      }
    }
  }

  int askForOptions() {
    int option = 0;
    boolean good = false;

    System.out.println("What would you like to do?");
    System.out.println("(0) get a y point");
    System.out.println("(1) get a x point(s)");
    System.out.println("(2) get the vertex");

    while (!good) {
      try {
        option = scanner.nextInt();
        if (option <= 2) {
          good = true;
        } else {
          throw new Exception("invalid number");
        }
      } catch (Exception e) {
        if (!e.getMessage().equals("invalid number")) {
          scanner.next();
        }
        System.out.println("Not a valid number try again");
      }
    }

    return option;
  }

  public void defineVars() {
    a = Double.NaN;
    b = Double.NaN;
    c = Double.NaN;

    while (Double.isNaN(a)) {
      System.out.println("What is \"a\"?");
      try {
        a = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        a = Double.NaN;
      }
    }

    while (Double.isNaN(b)) {
      System.out.println("What is \"b\"?");
      try {
        b = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        b = Double.NaN;
      }
    }

    while (Double.isNaN(c)) {
      System.out.println("What is \"c\"?");
      try {
        c = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        c = Double.NaN;
      }
    }
  }

  double findY() {
    double x = Double.NaN;

    System.out.println("What is the x point?");

    while (Double.isNaN(x)) {
      try {
        x = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Invalid number");
      }
    }

    return findY(x);
  }

  double findY(double x) {
    return (a * (Math.pow(x, 2))) + (b * x) + c;
  }

  double findXVertex() {
    return -((double) b / (2 * a));
  }

  double findYVertex() {
    return findY(findXVertex());
  }

  double[] findVertex() {
    double[] vertex = new double[2];
    vertex[0] = findXVertex();
    vertex[1] = findYVertex();

    return vertex;
  }

  double[] findX() {
    // y = ax^2 + bx + c
    double y = Double.NaN;

    System.out.println("What is the y point?");

    while (Double.isNaN(y)) {
      try {
        y = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Invalid number");
      }
    }

    return findX(y);
  }

  double[] findX(double y) {
    // y = ax^2 + bx + c
    double[] xs = new double[2];

    if (y == 0) {
      xs[0] = c;
      return xs;
    }
    double newC = c;

    if (y > 0) {
      newC -= y;
    } else {
      newC += y;
    }

    System.out.println((4 * b * newC));
    double discriminant = Math.pow(b, 2) - (4 * a * newC);
    System.out.println(discriminant);

    xs[0] = (-(b) + (Math.sqrt(discriminant))) / (2 * a);
    xs[1] = (-(b) - (Math.sqrt(discriminant))) / (2 * a);

    return xs;
  }
}

class Linear {
  private double m = Double.NaN;
  private double b = Double.NaN;
  private Scanner scanner = new Scanner(System.in);

  void start() {
    defineVars();

    boolean done = false;

    while (!done) {
      var option = askForOptions();
      if (option == 0) {
        System.out.println("The y are: " + findY());
      } else if (option == 1) {
        double x = findX();
        System.out.println("The x is: " + x);
      }

      System.out.println("Continue? (true/false)");

      while (true) {
        try {
          done = !scanner.nextBoolean();
          break;
        } catch (Exception e) {
          scanner.next();
          System.out.println("Not a valid options try again");
        }
      }
    }
  }

  int askForOptions() {
    int option = 0;
    boolean good = false;

    System.out.println("What would you like to do?");
    System.out.println("(0) get a y point");
    System.out.println("(1) get a x point");

    while (!good) {
      try {
        option = scanner.nextInt();
        if (option <= 1) {
          good = true;
        } else {
          throw new Exception("invalid number");
        }
      } catch (Exception e) {
        if (!e.getMessage().equals("invalid number")) {
          scanner.next();
        }
        System.out.println("Not a valid number try again");
      }
    }

    return option;
  }

  void defineVars() {
    m = Double.NaN;
    b = Double.NaN;

    while (Double.isNaN(m)) {
      System.out.println("What is \"m\"?");
      try {
        m = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        m = Double.NaN;
      }
    }

    while (Double.isNaN(b)) {
      System.out.println("What is \"b\"?");
      try {
        b = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        b = Double.NaN;
      }
    }
  }

  double findY() {
    double x = Double.NaN;

    System.out.println("What is the x point?");

    while (Double.isNaN(x)) {
      try {
        x = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Invalid number");
      }
    }

    return findY(x);
  }

  double findY(double x) {
    return (m * x) + b;
  }

  double findX() {
    // y = ax^2 + bx + c
    double y = Double.NaN;

    System.out.println("What is the y point?");

    while (Double.isNaN(y)) {
      try {
        y = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Invalid number");
      }
    }

    return findX(y);
  }

  double findX(double y) {
    double left = y;

    if (b > 0) {
      left -= b;
    } else {
      left += b;
    }

    return (double) left / m;
  }
}

class CompoundInterest {

  double p;
  double r;
  double n;
  double t;
  Scanner scanner = new Scanner(System.in);

  void start() {
    boolean done = false;

    while (!done) {
      defineVars();

      System.out.println("The compounded interest is: " + p * Math.pow(1 + ((r / 100) / n), n * t));

      System.out.println("Continue? (true/false)");

      while (true) {
        try {
          done = !scanner.nextBoolean();
          break;
        } catch (Exception e) {
          scanner.next();
          System.out.println("Not a valid options try again");
        }
      }
    }
  }

  void defineVars() {
    p = Double.NaN;
    r = Double.NaN;
    n = Double.NaN;
    t = Double.NaN;

    while (Double.isNaN(p)) {
      System.out.println("What is the initial principle balance?");
      try {
        p = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Not a number!");
      }
    }

    while (Double.isNaN(r)) {
      System.out.println("What is the interest rate?");
      try {
        r = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Not a number!");
      }
    }

    while (Double.isNaN(t)) {
      System.out.println("For how long? (in years)");
      try {
        t = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Not a number!");
      }
    }

    while (Double.isNaN(n)) {
      System.out.println("How many times is the interest compounded in a year?");
      try {
        n = scanner.nextDouble();
      } catch (Exception e) {
        scanner.next();
        System.out.println("Not a number!");
      }
    }
  }
}