package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

import cs3500.freecell.Card.Card;

public abstract class Pile {
  protected List<Card> LoC;
  protected String name;
  protected int row;

  public Pile(String name, int row) {
    this.LoC = new ArrayList<Card>();
    this.name = name;
    this.row = row;
  }

  public int numberOfCards() {
    return LoC.size();
  }

  public Card getCardAt(int index) {
    if (index < 0 || index >= LoC.size()){
      return null;
    }
    return LoC.get(index);
  }

  public void add(Card i) {
    LoC.add(i);
  }

  public Card getTopCard() {
    return LoC.get(LoC.size() - 1);
  }

  public abstract boolean canBeAdded(Card i);

  public abstract boolean canAddListCard();

  /**
   * Check to see the current Pile is compatible with the source pile
   * @param sourcePile
   * @return
   */
  public abstract boolean validPile(PileType sourcePile);

  public abstract List<Card> getMoveCards(int cardIndex);

  public void remove(Card card) {
    LoC.remove(card);
  }
  public boolean isEmpty() {
    return LoC.isEmpty();
  }

}
