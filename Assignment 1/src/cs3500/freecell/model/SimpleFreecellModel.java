package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cs3500.freecell.Card.Card;
import cs3500.freecell.Card.Suit;
import cs3500.freecell.Card.Value;

/**
 * A Representation of a simple FreeCell Model.
 */
public class SimpleFreecellModel implements FreecellModel<Card> {
  private final List<Pile> listOfCascadePiles;
  private final List<Pile> listOfOpenPiles;
  private final List<Pile> listOfFoundationPiles;
  private List<Card> deck;
  private boolean gamestart;



  /**
   * A constructor for SimpleFreecellModel.
   */
  public SimpleFreecellModel() {
    this.deck = new ArrayList<>();
    this.listOfCascadePiles = new ArrayList<>();
    this.listOfOpenPiles = new ArrayList<>();
    this.listOfFoundationPiles = new ArrayList<>();
    populatePiles(4, PileType.FOUNDATION); // limit to 4 piles.
    this.gamestart = false;
  }

  /**
   * a method that generate the piles in the list
   *
   * @param num      number of piles
   * @param pileType which pile type you want to create
   */
  private void populatePiles(int num, PileType pileType) {
    int i = 0;
    while (num != 0) {
      if (pileType == PileType.CASCADE) {
        this.listOfCascadePiles.add(new CascadePile("C", i + 1));
      } else if (pileType == PileType.OPEN) {
        this.listOfOpenPiles.add(new OpenPile("O", i + 1));
      } else if (pileType == PileType.FOUNDATION) {
        this.listOfFoundationPiles.add(new FoundationPile("F", i + 1));
      }
      i++;
      num--;
    }
  }

  /**
   * a method to populate the deck
   *
   * @return a list of card.
   */
  @Override
  public List<Card> getDeck() {
    List<Card> LoC = new ArrayList<>();

    for (Suit suit : Suit.values()) {
      for (Value val : Value.values()) {
        LoC.add(new Card(val, suit));
      }
    }
    return LoC;
  }

  /**
   * check for duplicate and null in the deck
   *
   * @param deck a list of card
   * @return a boolean
   */
  private boolean validDeck(List<Card> deck) {
    for (Card card : deck) {
      if (card == null) {
        return false;
      }
    }
    Set<Card> noDuplicate = new HashSet<>(deck);
    return noDuplicate.size() == 52;
  }


  /**
   * @param deck            the deck to be dealt
   * @param numCascadePiles number of cascade piles
   * @param numOpenPiles    number of open piles
   * @param shuffle         if true, shuffle the deck else deal the deck as-is
   */

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    if (deck.isEmpty()) {
      throw new IllegalArgumentException("Deck is invalid");
    }
    if (!validDeck(deck)) {
      throw new IllegalArgumentException("Deck is invalid");
    } else {
      this.deck = deck;
    }
    if (numCascadePiles < 4) {
      throw new IllegalArgumentException("Invalid number of Cascade Piles");
    } else {
      this.populatePiles(numCascadePiles, PileType.CASCADE);
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Invalid number of OpenPiles");
    } else {
      this.populatePiles(numOpenPiles, PileType.OPEN);
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }

    // Round-robin card dealt fashion
    for (int j = 0; j < deck.size(); j++) {
      Card card = this.deck.get(j);
      this.listOfCascadePiles.get(j % numCascadePiles).add(card);
    }
    this.gamestart = true;
  }

  /**
   * @param pile
   * @return
   */
  private List<Pile> getPile(PileType pile) {
    if (pile == PileType.CASCADE) {
      return this.listOfCascadePiles;
    } else if (pile == PileType.FOUNDATION) {
      return this.listOfFoundationPiles;
    } else if (pile == PileType.OPEN) {
      return this.listOfOpenPiles;
    } else {
      throw new IllegalArgumentException("Invalid PileType");
    }
  }

  /**
   * @param source
   * @param pileNumber
   * @param destination
   * @param destPileNumber
   */
  private void isValidMovePileType(PileType source, int pileNumber, PileType destination, int destPileNumber) {
    // get source pile
    List<Pile> sourcePileType = getPile(source);
    // get dest pile
    List<Pile> destPileType = getPile(destination);

    //check the arguments
    if (pileNumber < 0 || pileNumber >= sourcePileType.size()) {
      throw new IllegalArgumentException("Invalid source pile number!");
    } else if (destPileNumber < 0 || destPileNumber >= destPileType.size()) {
      throw new IllegalArgumentException("Invalid destination pile number");
    } else {
      // get dest pile number
      Pile destPile = destPileType.get(destPileNumber);

      // check the pile-type move
      if (!destPile.validPile(source)) {
        throw new IllegalArgumentException("Cannot move card(s) from sourcePile to destPile");
      }
    }
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) {
    if (!gamestart) {
      throw new IllegalStateException("Games has not started");
    }
    if (isGameOver()) {
      throw new IllegalArgumentException("Game is over!!!");
    }

    isValidMovePileType(source, pileNumber, destination, destPileNumber);

    // get source pile
    List<Pile> sourcePileType = getPile(source);
    // get dest pile
    List<Pile> destPileType = getPile(destination);

    // get source pile number
    Pile sourcePile = sourcePileType.get(pileNumber);
    // get dest pile number
    Pile destPile = destPileType.get(destPileNumber);

    if (sourcePile.isEmpty()) {
      throw new IllegalArgumentException("Invalid source pile. No Cards Available");
    }
    // move many cards
    if (moveMoreThanOneCards(sourcePile, cardIndex) && destPile.canAddListCard()) {

    } else {
      if (destPile.canBeAdded(sourcePile.getTopCard())) {
        destPile.add(sourcePile.getTopCard());
        sourcePile.remove(sourcePile.getTopCard());
      } else {
        throw new IllegalArgumentException("Invalid moves");
      }
    }


  }

  private boolean moveMoreThanOneCards(Pile sourcePile, int cardIndex) {
    return ((sourcePile.numberOfCards() - 1) - cardIndex) > 1;
  }


  /**
   * @return
   */
  @Override
  public boolean isGameOver() {
    int result = 0;
    for (Pile listOfFoundationPile : this.listOfFoundationPiles) {
      result = result + listOfFoundationPile.numberOfCards();
    }
    return result == 52;
  }

  /**
   * @param index the index of the foundation pile, starting at 0
   * @return
   */
  @Override
  public int getNumCardsInFoundationPile(int index) throws IllegalArgumentException, IllegalStateException {
    if (!gamestart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (index < 0 || index >= listOfFoundationPiles.size()) {
      throw new IllegalArgumentException("Invalid index");
    }
    return listOfFoundationPiles.get(index).numberOfCards();
  }

  /**
   * @return
   */
  @Override
  public int getNumCascadePiles() {
    if (!gamestart) {
      return -1;
    } else {
      return listOfCascadePiles.size();
    }
  }

  /**
   * @param index the index of the cascade pile, starting at 0
   * @return
   */
  @Override
  public int getNumCardsInCascadePile(int index) throws IllegalArgumentException, IllegalStateException {
    if (!gamestart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (index < 0 || index >= listOfCascadePiles.size()) {
      throw new IllegalArgumentException("Invalid index");
    }
    if (this.listOfCascadePiles.get(index).isEmpty()) {
      throw new IllegalStateException("Game not started!!");
    }
    return this.listOfCascadePiles.get(index).numberOfCards();
  }

  /**
   * @param index the index of the open pile, starting at 0
   * @return
   */
  @Override
  public int getNumCardsInOpenPile(int index) throws IllegalArgumentException, IllegalStateException {
    if (!gamestart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (index >= listOfFoundationPiles.size()) {
      throw new IllegalArgumentException("Invalid index");
    } else if (index < 0) {
      throw new IllegalArgumentException("Invalid index");
    }
    return listOfOpenPiles.get(index).numberOfCards();
  }

  /**
   * @return
   */
  @Override
  public int getNumOpenPiles() {
    if (!gamestart) {
      return -1;
    } else {
      return listOfOpenPiles.size();
    }
  }

  /**
   * @param pileIndex the index of the foundation pile, starting at 0
   * @param cardIndex the index of the card in the above foundation pile, starting at 0
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex) throws IllegalArgumentException, IllegalStateException {
    if (!gamestart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (listOfFoundationPiles.size() - 1 < pileIndex) {
      throw new IllegalArgumentException("Out of bound arguments: pileIndex");
    }
    if (listOfFoundationPiles.get(pileIndex).numberOfCards() - 1 < cardIndex) {
      throw new IllegalArgumentException("Out of bound arguments: cardIndex");
    }
    Card cardAtIndex;
    Pile pile = listOfFoundationPiles.get(pileIndex);
    cardAtIndex = pile.getCardAt(cardIndex);
    return cardAtIndex;
  }

  /**
   * @param pileIndex the index of the cascade pile, starting at 0
   * @param cardIndex the index of the card in the above cascade pile, starting at 0
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex) throws IllegalArgumentException, IllegalStateException {
    if (!gamestart) {
      throw new IllegalStateException("Game not started");
    }
    if (listOfCascadePiles.size() - 1 < pileIndex) {
      throw new IllegalArgumentException("Out of bound arguments: Pile Index" + (listOfCascadePiles.size() - 1) + "out of " + pileIndex);
    }
    if (listOfCascadePiles.get(pileIndex).numberOfCards() - 1 < cardIndex) {
      throw new IllegalArgumentException("Out of bound arguments: Card Index" + (listOfCascadePiles.get(pileIndex).numberOfCards() - 1) + cardIndex);
    } else {
      Card cardAtIndex;
      Pile pile = listOfCascadePiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(cardIndex);
      return cardAtIndex;
    }
  }

  /**
   * @param pileIndex the index of the open pile, starting at 0
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    if (pileIndex > listOfOpenPiles.size() - 1 || pileIndex < 0) {
      throw new IllegalArgumentException("Out of Bound arguments: pileIndex");
    }
    if (!gamestart) {
      throw new IllegalStateException("Game not started");
    } else {
      Card cardAtIndex;
      Pile pile = listOfOpenPiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(0);
      return cardAtIndex;
    }
  }
}
