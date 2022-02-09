package cs3500.freecell.Card;


import java.util.Objects;

/**
 * Represent a Cards with suits and value.
 */
public class Card {
  private final Value value;
  private final Suit suit;

  /**
   * A constructor for Card.
   *
   * @param v a value
   * @param s a suit
   * @throws IllegalArgumentException if one of the argument is null, throws an exception
   */
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
    if (this == null) {
      return "";
    } else {
      return value + suit.toString();
    }
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

  /**
   * @return
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.suit);
  }


  /**
   * @param card
   * @return
   * @throws
   */
  public boolean isValidToAddToFoundation(Card card) {
    if (this.value.isOneGreater(card.value) && this.suit.isSameType(card.suit)) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added to the Foundation Pile");
    }


  }

  /**
   * @param card
   * @return
   */
  public boolean isValidToAddToCascade(Card card) {
    if (this.value.isOneLower(card.value) && this.suit.isDifferentColor(card.suit)) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added to the Cascade Pile");
    }
  }

  /**
   * @return
   */
  public boolean isAnAce() {
    return value == Value.ACE;
  }
}
