package cs3500.freecell.model;

import java.util.List;

/**
 * A representation of an Open Pile.
 */
public class OpenPile extends Pile {

  /**
   * A Constructor for OpenPile.
   */
  public OpenPile() {
    super();
  }

  /**
   * A method that determines if the given card is compatible with this.
   *
   * @param i a Card
   * @return a boolean
   */
  @Override
  public boolean canBeAdded(Card i) {
    if (loc.isEmpty()) {
      return true;
    } else {
      throw new IllegalArgumentException("Card cannot be added in the Open Pile, Pile is full");
    }
  }

  /**
   * A method that determines if the given PileType is compatible with Open PileType.
   *
   * @param sourcePile a PileType
   * @return a boolean
   */
  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.CASCADE || sourcePile == PileType.OPEN;
  }

  @Override
  public void removeAll(List<Card> cardList) {
    throw new IllegalArgumentException("Action cannot perform on Open Pile");
  }

  /**
   * a method that add a collection of cards to the card list.
   *
   * @param cardList a list of cards
   */
  @Override
  public void addAll(List<Card> cardList) {
    throw new IllegalArgumentException("Action cannot perform on Open Pile");
  }


}
