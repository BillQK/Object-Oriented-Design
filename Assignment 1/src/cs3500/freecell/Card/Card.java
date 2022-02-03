package cs3500.freecell.Card;


import java.util.Objects;

/**
 * Represent a Cards with suits and value.
 */
public class Card {
  private final Value value;
  private final Suit suit;

  public Card(Value v, Suit s) {
    this.value = v;
    this.suit = s;
  }

  /**
   * Return a string representation of a card.
   *
   * @return a string represent the values of a card
   */
  @Override
  public String toString() {
    return value.toString() + suit.toString();
  }

  /**
   * A method that compare the parameters to the current object.
   * @param o a Card object, if not return false.
   * @return a boolean, true if the object is same in value and suit,
   * false if the object is not equal
   */
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

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.suit);
  }

}
