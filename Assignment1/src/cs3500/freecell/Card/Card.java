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
}
