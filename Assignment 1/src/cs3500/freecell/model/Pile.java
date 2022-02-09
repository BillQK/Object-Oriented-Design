package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

/**
 * An Abstract class for Pile.
 */
public abstract class Pile {
  protected List<Card> loc;

  /**
   * A constructor for Pile.
   */
  public Pile() {
    this.loc = new ArrayList<>();
  }

  /**
   * A method that gets the size of the Pile.
   *
   * @return an int
   */
  public int numberOfCards() {
    return loc.size();
  }

  /**
   * A method that return a null if index is greater than the size, and less than 0, else
   * return the Card of the given index.
   *
   * @param index an int
   * @return a Card at the given index
   */
  public Card getCardAt(int index) {
    if (index < 0 || index >= loc.size()) {
      return null;
    }
    return loc.get(index);
  }

  /**
   * a method that add the given card to the pile.
   *
   * @param i a Card
   */
  public void add(Card i) {
    loc.add(i);
  }

  /**
   * A method that return the Top card of the pile.
   *
   * @return a Card
   */
  public Card getTopCard() {
    return loc.get(loc.size() - 1);
  }

  /**
   * A method that determines the compatibility of given the card, if it can be added to the pile
   * return true, else return false.
   *
   * @param i a Card
   * @return a boolean
   */
  public abstract boolean canBeAdded(Card i);

  /**
   * Check to see the current Pile is compatible with the source pile.
   *
   * @param sourcePile a PileType
   * @return a boolean
   */
  public abstract boolean validPile(PileType sourcePile);

  /**
   * a method that remove a card from the Pile.
   *
   * @param card a Card
   */
  public void remove(Card card) {
    loc.remove(card);
  }

  /**
   * A method that check to see if the pile is empty or not.
   *
   * @return a boolean
   */
  public boolean isEmpty() {
    return loc.isEmpty();
  }

}
