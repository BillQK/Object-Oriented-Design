package cs3500.freecell.model;


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
    return value + suit.toString();
  }

  /**
   * A method that compare the parameters to the current object.
   *
   * @param o a Card object, if not return false.
   * @return a boolean, true if the object is same in value and suit,
   *         false if the object is not equal
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
   * A method that hash the value and the suit.
   *
   * @return an int
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.suit);
  }


  /**
   * A method that determines that if the card is valid to add to the Foundation card.
   *
   * @param card a Card object
   * @return a boolean
   * @throws IllegalArgumentException if it can't add card to the foundation
   */
  public boolean isValidToAddToFoundation(Card card) {
    if (this.value.isOneGreater(card.value) && this.suit.isSameType(card.suit)) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added to the Foundation Pile");
    }


  }

  /**
   * a method that determines if the card is valid to add the Cascade pile.
   *
   * @param card a Card object
   * @return a boolean
   * @throws IllegalArgumentException if it can't add card to the cascade pile
   */
  public boolean isValidToAddToCascade(Card card) {
    if (this.value.isOneSmaller(card.value) && this.suit.isDifferentColor(card.suit)) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added to the Cascade Pile");
    }
  }

  /**
   * a method that determines if the card is an ace or not.
   *
   * @return a boolean
   */
  public boolean isAnAce() {
    return value == Value.ACE;
  }
}
