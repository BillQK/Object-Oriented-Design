package cs3500.freecell.model;


import java.util.List;

/**
 * a representation of a cascade pile.
 */
public class CascadePile extends Pile {

  /**
   * a constructor of CascadePile that takes in a String and int row.
   */
  public CascadePile() {
    super();
  }

  /**
   * A method that determines if the given card is valid to be added to the Pile.
   *
   * @param i a Card
   * @return a boolean
   */
  @Override
  public boolean canBeAdded(Card i) {
    if (loc.isEmpty() || getTopCard().isValidToAddToCascade(i)) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added to the Cascade Pile");
    }
  }

  /**
   * a method that determines if the given Pile is compatible with this.
   *
   * @param sourcePile a PileType
   * @return a boolean
   */
  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.OPEN || sourcePile == PileType.CASCADE;
  }

  @Override
  public void removeAll(List<Card> cardList) {
    loc.removeAll(cardList);
  }

  /**
   * a method that add a collection of cards to the card list.
   *
   * @param cardList a list of cards
   */
  @Override
  public void addAll(List<Card> cardList) {
    loc.addAll(cardList);
  }


}
