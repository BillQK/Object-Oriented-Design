package cs3500.freecell.Card;


import java.util.Objects;

/**
 * Represent a Cards with suits and value.
 */
public class Card implements Comparable<Card> {
  private final Value value;
  private final Suit suit;

  public Card(Value v, Suit s) throws IllegalArgumentException {
    if (v == null || s == null) {
      throw new IllegalArgumentException("Invalid Card");
    }
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
   *
   * @param o a Card object, if not return false.
   * @return a boolean, true if the object is same in value and suit,
   * false if the object is not equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (getClass() != o.getClass()) {
      return false;
    } else {
      Card card = (Card) o;
      return Objects.equals(this.value, card.value) && Objects.equals(this.suit, card.suit);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.suit);
  }


  @Override
  public int compareTo(Card o) {
    if (this.value.compareTo(o.value) == 0 && this.suit == o.suit) {
      return 0;
    } else if ((this.value.compareTo(o.value) > 0) && this.suit == o.suit) {
      return 1;
    } else if ((this.value.compareTo(o.value) < 0 && this.suit == o.suit)) {
      return -1;
    } else {
      throw new IllegalArgumentException("Suit are not equal, cannot compare");
    }
  }
}
