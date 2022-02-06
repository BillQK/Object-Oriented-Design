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
    return LoC.get(index);
  }

  public abstract void add(Card i);
}
