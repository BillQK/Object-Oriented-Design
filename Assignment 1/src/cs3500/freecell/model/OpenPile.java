package cs3500.freecell.model;

import cs3500.freecell.Card.Card;

public class OpenPile extends Pile{

  public OpenPile(String name, int row) {
    super(name, row);
  }

  @Override
  public void add(Card i) {
    LoC.add(i);
  }


}
