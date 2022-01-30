package cs3500.freecell.Card;


/**
 * Represent a Cards with suits and value
 */
public class Card {
  private final Value value;
  private final Suit suit;

  public Card(Value v, Suit s) {
    this.value = v;
    this.suit = s;
  }

  /**
   * Return a string representation of the
   *
   * @return
   */
  @Override
  public String toString() {
    return value.toString() + suit.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Card) {
      Card other = (Card) o;
      return this.value == other.value
              && this.suit == other.suit;
    }
    else {
      return false;
    }
  }
}
