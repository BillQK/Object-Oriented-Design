package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Representation of a simple FreeCell Model.
 */
public class SimpleFreecellModel implements FreecellModel<Card> {
  private final List<Pile> listOfCascadePiles;
  private final List<Pile> listOfOpenPiles;
  private final List<Pile> listOfFoundationPiles;
  private List<Card> deck;
  private boolean isGameStart;


  /**
   * A constructor for SimpleFreecellModel.
   */
  public SimpleFreecellModel() {
    this.deck = new ArrayList<>();
    this.listOfCascadePiles = new ArrayList<>();
    this.listOfOpenPiles = new ArrayList<>();
    this.listOfFoundationPiles = new ArrayList<>();
    populatePiles(4, PileType.FOUNDATION); // limit to 4 piles.
    this.isGameStart = false;
  }

  /**
   * a method that generate the piles in the list.
   *
   * @param num      number of piles
   * @param pileType which pile type you want to create
   */
  private void populatePiles(int num, PileType pileType) {
    while (num != 0) {
      if (pileType == PileType.CASCADE) {
        this.listOfCascadePiles.add(new CascadePile());
      } else if (pileType == PileType.OPEN) {
        this.listOfOpenPiles.add(new OpenPile());
      } else if (pileType == PileType.FOUNDATION) {
        this.listOfFoundationPiles.add(new FoundationPile());
      }
      num--;
    }
  }

  /**
   * a method to populate the deck.
   *
   * @return a list of card.
   */
  @Override
  public List<Card> getDeck() {
    List<Card> loc = new ArrayList<>();

    for (Suit suit : Suit.values()) {
      for (Value val : Value.values()) {
        loc.add(new Card(val, suit));
      }
    }
    return loc;
  }

  /**
   * check for duplicate and null in the deck.
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
   * Deal a new game of freecell with the given deck, with or without shuffling
   * it first. This method first verifies that the deck is valid. It deals the
   * deck among the cascade piles in roundrobin fashion. Thus if there are 4
   * cascade piles, the 1st pile will get cards 0, 4, 8, ..., the 2nd pile will
   * get cards 1, 5, 9, ..., the 3rd pile will get cards 2, 6, 10, ... and the
   * 4th pile will get cards 3, 7, 11, .... Depending on the number of cascade
   * piles, they may have a different number of cards.
   *
   * @param numCascadePiles number of cascade piles
   * @param numOpenPiles    number of open piles
   * @param deck            the deck to be dealt
   * @param shuffle         if true, shuffle the deck else deal the deck as-is
   * @throws IllegalArgumentException if the deck is invalid
   */
  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    if (isGameStart) {
      this.listOfOpenPiles.clear();
      this.listOfCascadePiles.clear();
      this.listOfFoundationPiles.clear();
      populatePiles(4, PileType.FOUNDATION);

    }
    if (deck.isEmpty()) {
      throw new IllegalArgumentException("Deck is invalid");
    }
    if (!validDeck(deck)) {
      throw new IllegalArgumentException("Deck is invalid");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }
    this.deck = deck;
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


    // Round-robin card dealt fashion
    for (int j = 0; j < deck.size(); j++) {
      Card card = this.deck.get(j);
      this.listOfCascadePiles.get(j % numCascadePiles).add(card);
    }
    this.isGameStart = true;


  }

  /**
   * A method the given the PileType, return a list of that type.
   *
   * @param pile a PileType
   * @return a List of Pile
   * @throws IllegalArgumentException if the given PileType is invalid
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
   * A method that takes in PileType source, int pile-number, PileType dest, and destination
   * number to determine if the move is valid.
   *
   * @param source         a PileType
   * @param pileNumber     an int
   * @param destination    a PileType
   * @param destPileNumber an int
   * @throws IllegalArgumentException if the PileType from dest is not compatible with
   *                                  the PileType from the source
   * @throws IllegalArgumentException if pileNumber and destNumber are less than 0
   *                                  or greater than the pile size
   */
  private void isValidMovePileType(PileType source, int pileNumber,
                                   PileType destination, int destPileNumber) {
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
  public void move(PileType source, int pileNumber,
                   int cardIndex, PileType destination, int destPileNumber) {
    if (!isGameStart) {
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

    // Round robin card-dealt fashion
    if (destPile.canBeAdded(sourcePile.getTopCard())) {
      destPile.add(sourcePile.getTopCard());
      sourcePile.remove(sourcePile.getTopCard());
    } else {
      throw new IllegalArgumentException("Invalid moves");
    }

  }

  /**
   * Signal if the game is over or not.
   *
   * @return true if game is over, false otherwise
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
   * Get the number of cards in a given foundation pile.
   *
   * @param index the index of the foundation pile, starting at 0
   * @return the number of cards in the given foundation pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInFoundationPile(int index)
          throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (index < 0 || index >= listOfFoundationPiles.size()) {
      throw new IllegalArgumentException("Invalid index");
    }
    return listOfFoundationPiles.get(index).numberOfCards();
  }

  /**
   * Get the number of cascade piles in this game of free-cell.
   *
   * @return the number of cascade piles, as an integer, or -1 if the game has not started yet
   */
  @Override
  public int getNumCascadePiles() {
    if (!isGameStart) {
      return -1;
    } else {
      return listOfCascadePiles.size();
    }
  }

  /**
   * Get the number of cards in a given cascade pile.
   *
   * @param index the index of the cascade pile, starting at 0
   * @return the number of cards in the given cascade pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInCascadePile(int index)
          throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (index < 0 || index >= listOfCascadePiles.size()) {
      throw new IllegalArgumentException("Invalid index");
    }
    return this.listOfCascadePiles.get(index).numberOfCards();
  }

  /**
   * Get the number of cards in a given open pile.
   *
   * @param index the index of the open pile, starting at 0
   * @return the number of cards in the given open pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInOpenPile(int index)
          throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not Started!!");
    }
    if (index >= listOfOpenPiles.size() || index < 0) {
      throw new IllegalArgumentException("Invalid index");
    }
    return listOfOpenPiles.get(index).numberOfCards();
  }

  /**
   * Get the number of open piles in this game of freecell.
   *
   * @return the number of open piles, as an integer, or -1 if the game has not started yet
   */
  @Override
  public int getNumOpenPiles() {
    if (!isGameStart) {
      return -1;
    } else {
      return listOfOpenPiles.size();
    }
  }

  /**
   * Get the card at the provided index in the provided foundation pile.
   *
   * @param pileIndex the index of the foundation pile, starting at 0
   * @param cardIndex the index of the card in the above foundation pile, starting at 0
   * @return the card at the provided indices
   * @throws IllegalArgumentException if the pileIndex or cardIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex)
          throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (listOfFoundationPiles.size() <= pileIndex || pileIndex < 0) {
      throw new IllegalArgumentException("Out of bound arguments: pileIndex");
    }
    if (listOfFoundationPiles.get(pileIndex).numberOfCards() <= cardIndex || cardIndex < 0) {
      throw new IllegalArgumentException("Out of bound arguments: cardIndex");
    }
    Card cardAtIndex;
    Pile pile = listOfFoundationPiles.get(pileIndex);
    cardAtIndex = pile.getCardAt(cardIndex);
    return cardAtIndex;
  }

  /**
   * Get the card at the provided index in the provided cascade pile.
   *
   * @param pileIndex the index of the cascade pile, starting at 0
   * @param cardIndex the index of the card in the above cascade pile, starting at 0
   * @return the card at the provided indices
   * @throws IllegalArgumentException if the pileIndex or cardIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex)
          throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (listOfCascadePiles.size() <= pileIndex || pileIndex < 0) {
      throw new IllegalArgumentException("Out of bound arguments: Pile Index"
              + (listOfCascadePiles.size() - 1) + " out of " + pileIndex);
    }
    if (listOfCascadePiles.get(pileIndex).numberOfCards() <= cardIndex || cardIndex < 0) {
      throw new IllegalArgumentException("Out of bound arguments: Card Index"
              + (listOfCascadePiles.get(pileIndex).numberOfCards() - 1) + " out of " + cardIndex);
    } else {
      Card cardAtIndex;
      Pile pile = listOfCascadePiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(cardIndex);
      return cardAtIndex;
    }
  }

  /**
   * Get the card in the given open pile.
   *
   * @param pileIndex the index of the open pile, starting at 0
   * @return the card at the provided index, or null if there is no card there
   * @throws IllegalArgumentException if the pileIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    if (!isGameStart) {
      throw new IllegalStateException("Game not started!!");
    }
    if (pileIndex >= listOfOpenPiles.size() || pileIndex < 0) {
      throw new IllegalArgumentException("Out of Bound arguments: pileIndex");
    } else {
      Card cardAtIndex;
      Pile pile = listOfOpenPiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(0);
      return cardAtIndex;
    }
  }
}
