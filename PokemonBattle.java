import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
  public static void main(String[] args) {
    System.out.println("Asking for the first pokemon...");
    Pokemon pokemon1 = Pokemon.askForPokemon();
    pokemon1.printStats();
    System.out.println("Asking for the second pokemon...");
    Pokemon pokemon2 = Pokemon.askForPokemon();
    pokemon2.printStats();

    battle(pokemon1, pokemon2);
  }

  /**
   * Starts a battle between 2 pokemons
   * 
   * @param pokemon1 The pokemon who starts the fight
   * @param pokemon2 The pokemon who the fight is against
   */

  static void battle(Pokemon pokemon1, Pokemon pokemon2) {
    System.out.println("FIGHT!!!!");
    Scanner s = new Scanner(System.in);

    int hp1 = pokemon1.getHP();
    int hp2 = pokemon2.getHP();

    Pokemon attacker = pokemon1;
    Pokemon defensive = pokemon2;

    while (hp1 > 0 && hp2 > 0) {
      System.out.println(attacker.name + " turn!");
      int damage = attacker.getDamage(defensive.getDefense());
      // System.out.println(damage);
      System.out.println(attacker.name + " delt " + damage + " HP!");
      attacker = attacker.name.equals(pokemon1.name) ? pokemon2 : pokemon1;
      defensive = defensive.name.equals(pokemon1.name) ? pokemon2 : pokemon1;

      if (attacker.name.equals(pokemon1.name)) {
        hp1 -= damage;
      } else {
        hp2 -= damage;
      }

      if (hp1 <= 0) {
        System.out.println(defensive.name + " won!");
      } else if (hp2 <= 0) {
        System.out.println(attacker.name + " won!");
      } else {
        System.out.println(attacker.name + " now has " + (attacker.name.equals(pokemon1.name) ? hp1 : hp2) + "HP");
        System.out.println("(press space enter to continue)");
        s.nextLine();
      }
    }

    s.close();
  }
}

final class Pokemon {
  int baseHP;
  int baseAttack;
  int baseDefense;
  int level;
  String type;
  String name;

  Pokemon(String name, String type, int baseHP, int baseAttack,
      int baseDefense, int level) {
    this.type = type;
    this.baseHP = baseHP;
    this.baseAttack = baseAttack;
    this.baseDefense = baseDefense;
    this.level = level;
    this.name = name;
  }

  /**
   * Ask for pokemon information
   * 
   * @return Pokemon class
   */
  static public Pokemon askForPokemon() {
    String name = Helper.readString("Name of the Pokémon? ");
    String type = Helper.readString("What is the type? ");
    int baseHP = Helper.readInt("What is the Base HP? ");
    int baseAttack = Helper.readInt("What is the base attack? ");
    int baseDefense = Helper.readInt("What is the base defense? ");
    int level = Helper.readInt("What is the level? ");

    return new Pokemon(name, type, baseHP, baseAttack, baseDefense, level);
  }

  /**
   * Get attack damage
   * 
   * @param defense The defense stat of the defender
   * @return Attack damage
   */
  int getDamage(int defense) {
    double modifier = randomMultiplier();

    return (int) Math.floor(modifier * ((2 * level + 10) / 250 + (calculateStat(baseAttack) / defense) + 2));
  }

  private double randomMultiplier() {
    Random rand = new Random();

    return rand.nextDouble() * 0.15 + 0.85;
  }

  /**
   * Print out the pokemon stats in a table
   */
  void printStats() {
    String leftAlignFormat = "| %-13s | %-12s | %-7d | %-6d | %-12s | %-13d |%n";

    System.out.format("+---------------+--------------+---------+--------+--------------+---------------+%n");
    System.out.format("|     Name      |     Type     |  Level  |   HP   |    Attack    |    Defense    |%n");
    System.out.format("+---------------+--------------+---------+--------+--------------+---------------+%n");
    System.out.format(leftAlignFormat, name, type, level, getHP(), getAttack(), getDefense());
    System.out.format("+---------------+--------------+---------+--------+--------------+---------------+%n");
  }

  /**
   * HP of the pokemon
   * 
   * @return
   */
  int getHP() {
    return calculateHP();
  }

  /**
   * Attack stat of the pokemon
   * 
   * @return
   */
  int getAttack() {
    return calculateStat(baseAttack);
  }

  /**
   * Defense stat of the pokemon
   * 
   * @return
   */
  int getDefense() {
    return calculateStat(baseDefense);
  }

  private int calculateHP() {
    return (int) Math.floor(10 + level + (0.02 * baseHP * (level - 1)));
  }

  private int calculateStat(int stat) {
    return (int) Math.floor(5 + (0.02 * stat * (level - 1)));
  }
}

class Helper {
  static private Scanner s = new Scanner(System.in);

  static int readInt(String prompt) {
    int i = 0;

    while (i == 0) {
      try {
        System.out.print(prompt);
        i = s.nextInt();
      } catch (Exception e) {
        s.nextLine();
        System.out.println("Not a valid number!");
      }
    }

    return i;
  }

  static String readString(String prompt) {
    String i = "";

    while (i.isEmpty()) {
      try {
        System.out.print(prompt);
        i = s.next();
      } catch (Exception e) {
        s.nextLine();
        System.out.println("Not valid text!");
      }
    }

    return i;
  }
}