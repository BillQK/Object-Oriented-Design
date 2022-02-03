package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cs3500.freecell.Card.Card;
import cs3500.freecell.Card.Suit;
import cs3500.freecell.Card.Value;

public class SimpleFreecellModel implements FreecellModel<Card> {
  private List<Card> deck;
  private List<Pile> listOfCascadePiles;
  private List<Pile> listOfOpenPiles;
  private List<Pile> listOfFoundationPiles;


  public SimpleFreecellModel() {
    this.deck = getDeck();
    this.listOfCascadePiles = new ArrayList<>();
    this.listOfOpenPiles = new ArrayList<>();
    this.listOfFoundationPiles = new ArrayList<>(); // limit to 4 piles.

  }

  @Override
  public List<Card> getDeck() {
    List<Card> LoC = new ArrayList<Card>();

    for (Suit suit: Suit.values()) {
      for (Value val: Value.values()){
        LoC.add(new Card(val,suit));
      }
    }
    return LoC;
  }

  private boolean validDeck(List<Card> deck) {
    for ()
  }

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    if (deck.size() != 52) {
      throw new IllegalArgumentException("Deck is invalid");
    }
    if (numCascadePiles < 4 ){
      throw new IllegalArgumentException("Invalid number of Cascade Piles");
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Invalid number of OpenPiles");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }

    listOfCascadePiles = new ArrayList<>();
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) {
    if ()
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getNumCardsInFoundationPile(int index) {
    return 0;
  }

  @Override
  public int getNumCascadePiles() {
    return 0;
  }

  @Override
  public int getNumCardsInCascadePile(int index) {
    return 0;
  }

  @Override
  public int getNumCardsInOpenPile(int index) {
    return 0;
  }

  @Override
  public int getNumOpenPiles() {
    return 0;
  }

  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex) {
    return null;
  }

  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex) {
    return null;
  }

  @Override
  public Card getOpenCardAt(int pileIndex) {
    return null;
  }
}
