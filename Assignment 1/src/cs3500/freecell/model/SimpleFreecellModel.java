package cs3500.freecell.model;

import java.util.List;

import cs3500.freecell.Card.Card;

public class SimpleFreecellModel implements FreecellModel<Card> {

  public SimpleFreecellModel() {
  }

  @Override
  public List<Card> getDeck() {
    return null;
  }

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {

  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination, int destPileNumber) {

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
