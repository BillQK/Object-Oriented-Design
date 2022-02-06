package cs3500.freecell.model;

import cs3500.freecell.Card.Card;
import cs3500.freecell.Card.Suit;

public class FoundationPile extends Pile {
  public FoundationPile(String name, int row) {
    super(name, row);

  }

  @Override
  public void add(Card i) {
    LoC.add(i);
  }

  public boolean isFull() {
    return LoC.size() == 13;
  }

}
