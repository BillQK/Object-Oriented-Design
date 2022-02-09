package cs3500.freecell.model;

import java.util.List;

import cs3500.freecell.Card.Card;

public class OpenPile extends Pile{

  public OpenPile(String name, int row) {
    super(name, row);
  }

  @Override
  public boolean canBeAdded(Card i) {
    if(LoC.isEmpty()) {
      return true;
    }
    else {
      throw new RuntimeException("Open pile is not empty");
    }
  }

  @Override
  public boolean canAddListCard() {
    return false;
  }

  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.CASCADE;
  }

  @Override
  public List<Card> getMoveCards(int cardIndex) {
    throw new IllegalStateException("OpenPile cannot add a list of cards");
  }


}
