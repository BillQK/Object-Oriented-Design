package cs3500.freecell.Card;

/**
 * Represent 4 suit-value of cards clubs (♣), diamonds (♦),
 * hearts (♥), and spades (♠). Hearts and diamonds are colored
 * red, clubs and spades are colored black.
 */
public enum Suit {
  CLUB, DIAMOND, HEART, SPADE;


  @Override
  public String toString() {
    if (this == Suit.CLUB) {
      return "♣";
    } else if (this == Suit.DIAMOND) {
      return "♦";
    } else if (this == Suit.HEART) {
      return "♥";
    } else if (this == Suit.SPADE) {
      return "♠";
    } else {
      throw new IllegalArgumentException("Invalid Suit");
    }
  }


}
