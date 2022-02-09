package cs3500.freecell.model;

/**
 * Represent 4 suit-value of cards clubs (♣), diamonds (♦),
 * hearts (♥), and spades (♠). Hearts and diamonds are colored
 * red, clubs and spades are colored black.
 */
public enum Suit {
  CLUB('♣', Color.BLACK), DIAMOND('♦', Color.RED), SPADE('♠', Color.BLACK), HEART('♥', Color.RED);

  private final char graf;
  private final Color color;

  /**
   * A suit constructors.
   *
   * @param graf  a char value represent the suit
   * @param color a Color object represent the color of the suit
   */
  Suit(char graf, Color color) {
    this.graf = graf;
    this.color = color;
  }

  /**
   * a method that get the suit value.
   *
   * @return a char value of suit
   */
  public char getGraf() {
    return graf;
  }

  /**
   * a method that return a string value of a suit.
   *
   * @return a String
   */
  @Override
  public String toString() {
    return String.valueOf(graf);
  }

  /**
   * a method that determine if the given suit is the same suit.
   *
   * @param suit a suit
   * @return a boolean
   */
  public boolean isSameType(Suit suit) {
    return this.graf == suit.graf;
  }

  /**
   * a method that determine if the given Suit has a different color.
   *
   * @param suit a suit
   * @return a boolean
   */
  public boolean isDifferentColor(Suit suit) {
    return this.color != suit.color;
  }
}
