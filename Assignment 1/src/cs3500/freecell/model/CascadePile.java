package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

import cs3500.freecell.Card.Card;

public class CascadePile extends Pile {

  public CascadePile(String name, int row) {
    super(name,row);
  }

  @Override
  public boolean canBeAdded(Card i) {
    if(LoC.isEmpty()){
      return true;
    }else {
      return getTopCard().isValidToAddToCascade(i);
    }
  }

  @Override
  public boolean canAddListCard() {
    return false;
  }

  @Override
  public boolean validPile(PileType sourcePile) {
    return sourcePile == PileType.OPEN || sourcePile == PileType.CASCADE;
  }

  @Override
  public List<Card> getMoveCards(int cardIndex) {
    List<Card> cardList = new ArrayList<>();
    for(int i = cardIndex; i < LoC.size(); i++){
      cardList.add(LoC.get(i));
    }
    return cardList;
  }


}
