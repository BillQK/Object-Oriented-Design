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
  private List<Card> deck;
  private List<Pile> listOfFoundationPiles;


  /**
   * A constructor for SimpleFreecellModel.
   */
  public SimpleFreecellModel() {

    this.listOfCascadePiles = new ArrayList<Pile>();
    this.listOfOpenPiles = new ArrayList<Pile>();
    listOfFoundationPiles = new ArrayList<Pile>();
    populatePiles(4, PileType.FOUNDATION); // limit to 4 piles.
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
    List<Card> LoC = new ArrayList<Card>();

    for (Suit suit : Suit.values()) {
      for (Value val : Value.values()) {
        LoC.add(new Card(val, suit));
      }
    }
    return LoC;
  }

  /**
   * check for duplicate in the deck
   *
   * @param deck a list of card
   * @return a boolean
   */
  private boolean validDeck(List<Card> deck) {
    for (int i = 0; i < deck.size(); i++) {
      if (deck.get(i).equals(null)) {
        return false;
      }
    }
    Set<Card> noDuplicate = new HashSet<Card>(deck);
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
    if (deck.size() != 52) {
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
      populatePiles(numCascadePiles, PileType.CASCADE);
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Invalid number of OpenPiles");
    } else {
      populatePiles(numOpenPiles, PileType.OPEN);
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }

    // Round-robin card dealt fashion
    for (int j = 0; j < deck.size(); j++) {
      Card card = this.deck.get(j);
      this.listOfCascadePiles.get(j % numCascadePiles).add(card);
    }
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) {
    if (this.deck.isEmpty()) {
      throw new IllegalStateException("Games has not started");
    }
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getNumCardsInFoundationPile(int index) {
    return listOfFoundationPiles.get(index).numberOfCards();
  }

  @Override
  public int getNumCascadePiles() {
    return listOfCascadePiles.size();
  }

  @Override
  public int getNumCardsInCascadePile(int index) {
    return this.listOfCascadePiles.get(index).numberOfCards();
  }

  @Override
  public int getNumCardsInOpenPile(int index) {
    return listOfOpenPiles.get(index).numberOfCards();
  }

  @Override
  public int getNumOpenPiles() {
    return listOfOpenPiles.size();
  }

  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex) throws IllegalArgumentException {
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

  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex) throws IllegalArgumentException {
    if (listOfCascadePiles.size() - 1 < pileIndex) {
      throw new IllegalArgumentException("Out of bound arguments: Pile Index"
              + (listOfCascadePiles.size() - 1) + "out of " + pileIndex);
    }
    if (listOfCascadePiles.get(pileIndex).numberOfCards() - 1 < cardIndex) {
      throw new IllegalArgumentException("Out of bound arguments: Card Index" +
              (listOfCascadePiles.get(pileIndex).numberOfCards() - 1) + cardIndex);
    } else {
      Card cardAtIndex;
      Pile pile = listOfCascadePiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(cardIndex);
      return cardAtIndex;
    }
  }

  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException {
    if (pileIndex > listOfOpenPiles.size() - 1) {
      throw new IllegalStateException("Out of Bound arguments: pileIndex");
    } else {
      Card cardAtIndex;
      Pile pile = listOfOpenPiles.get(pileIndex);
      cardAtIndex = pile.getCardAt(0);
      return cardAtIndex;
    }
  }
}
