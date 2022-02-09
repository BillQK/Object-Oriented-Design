package cs3500.freecell.model;

import java.util.List;

import cs3500.freecell.Card.Card;

public class FoundationPile extends Pile {
  public FoundationPile(String name, int row) {
    super(name, row);

  }



  @Override
  public boolean canBeAdded(Card i) {
    if (LoC.isEmpty() && i.isAnAce()) {
      return true;
    }
    else if (!LoC.isEmpty() && getTopCard().isValidToAddToFoundation(i)) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public boolean canAddListCard() {
    return false;
  }

  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.CASCADE || sourcePile == PileType.OPEN;
  }

  @Override
  public List<Card> getMoveCards(int cardIndex) {
    throw new IllegalStateException("Foundation Pile can't add a list of card");
  }

  public boolean isFull() {
    return LoC.size() == 13;
  }

}
