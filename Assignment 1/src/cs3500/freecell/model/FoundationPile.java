package cs3500.freecell.model;

/**
 * a representation of a Foundation Pile.
 */
public class FoundationPile extends Pile {
  /**
   * A Constructor for Foundation Pile.
   */
  public FoundationPile() {
    super();

  }

  /**
   * a method that determines if the given card is compatible with this.
   *
   * @param i a Card
   * @return a boolean
   */
  @Override
  public boolean canBeAdded(Card i) {
    if (loc.isEmpty() && i.isAnAce()) {
      return true;
    } else if (loc.isEmpty() && !i.isAnAce()) {
      throw new IllegalArgumentException("Can only add an ace to an empty Foundation Pile");
    } else {
      return (!loc.isEmpty() && getTopCard().isValidToAddToFoundation(i));
    }
  }

  /**
   * a method that determines if the given PileType is compatible with this.
   *
   * @param sourcePile a PileType
   * @return a boolean
   */
  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.CASCADE || sourcePile == PileType.OPEN;
  }


}
