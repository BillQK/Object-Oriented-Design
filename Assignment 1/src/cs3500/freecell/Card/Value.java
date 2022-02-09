package cs3500.freecell.Card;

/**
 * Represent the value of card. 1 --> 13, Jack = 11, Queen = 12,
 * King = 13, Ace = 1.
 */
public enum Value {
  ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
  private final int value;

  Value(int value) {
    if (value < 1 || value > 13) {
      throw new IllegalArgumentException("Invalid value");
    }
    this.value = value;
  }

  /**
   * A method that return the string representation of the card value
   *
   * @return a String value
   */
  @Override
  public String toString() {
    if (this.value == 1) {
      return "A";
    } else if (this.value == 11) {
      return "J";
    } else if (this.value == 12) {
      return "Q";
    } else if (this.value == 13) {
      return "K";
    } else {
      return this.value + "";
    }
  }

  public int getValue() {
    return this.value;
  }

  public boolean isOneGreater(Value value) {
    return (value.getValue() - this.value) == 1;
  }

  public boolean isOneLower(Value value) {
    return (this.value - value.getValue()) == 1;
  }
}
