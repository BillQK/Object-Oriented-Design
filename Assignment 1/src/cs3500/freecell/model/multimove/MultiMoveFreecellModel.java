package cs3500.freecell.model.multimove;

import java.util.List;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.Pile;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.SimpleFreecellModel;

/**
 * A representation of a multi-move free-cell model that extends SimpleFree-cellModel,
 * it adds a new feature for moving many cards at a time.
 */
public class MultiMoveFreecellModel extends SimpleFreecellModel {

  public MultiMoveFreecellModel() {
    super();
  }

  /**
   * Move a card from the given source pile to the given destination pile, if
   * the move is valid.
   *
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source
   *                       pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if the move is not possible {@link
   *                                  PileType})
   * @throws IllegalStateException    if a move is attempted before the game has
   *                                  starts
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) {

    isValidMovePileType(source, pileNumber, destination, destPileNumber);
    // get source pile
    List<Pile> sourcePileType = getPile(source);
    // get dest pile
    List<Pile> destPileType = getPile(destination);

    // get source pile number
    Pile sourcePile = sourcePileType.get(pileNumber);
    // get dest pile number
    Pile destPile = destPileType.get(destPileNumber);

    if (cardIndex > sourcePile.numberOfCards() - 1 || cardIndex < 0) {
      throw new IllegalArgumentException("Invalid Card Index");
    }
    int emptyOpenPile = checkEmptyPile(PileType.OPEN);
    int emptyCascadePiles = checkEmptyPile(PileType.CASCADE);

    if (destPile.isEmpty() && destination == PileType.OPEN) {
      emptyOpenPile -= 1;
    }
    if (destPile.isEmpty() && destination == PileType.CASCADE) {
      emptyCascadePiles -= 1;
    }

    if (sourcePile.isEmpty()) {
      throw new IllegalArgumentException("Invalid source pile. No Cards Available");
    }
    if (cardIndex == sourcePile.numberOfCards() - 1) {
      super.move(source, pileNumber, cardIndex, destination, destPileNumber);
    } else {
      List<Card> cardList = sourcePile.getSubList(cardIndex);

      if (validBuild(cardList)
              && destPile.canBeAdded(cardList.get(0))
              && cardList.size() <= getValidSize(emptyOpenPile, emptyCascadePiles)
              && destination == PileType.CASCADE) {

        for (Card card : cardList) {
          destPile.add(card);
          sourcePile.remove(card);
        }
      } else {
        throw new IllegalArgumentException("Invalid Move");
      }
    }
  }


  private int checkEmptyPile(PileType pile) {
    List<Pile> piles = getPile(pile);
    int counter = 0;
    for (Pile p : piles) {
      if (p.isEmpty()) {
        counter = counter + 1;
      }
    }
    return counter;
  }

  private boolean validBuild(List<Card> loc) {
    for (int i = loc.size() - 1; i > 1; i--) {
      if (!loc.get(i).isValidBuild(loc.get(i - 1))) {
        return false;
      }
    }
    return true;
  }

  private int getValidSize(int emptyOpenPiles, int emptyCascadePiles) {
    return (emptyOpenPiles + 1) * (int) Math.pow(2, emptyCascadePiles);
  }
}
