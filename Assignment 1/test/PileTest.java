import org.junit.Before;
import org.junit.Test;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.CascadePile;
import cs3500.freecell.model.FoundationPile;
import cs3500.freecell.model.OpenPile;
import cs3500.freecell.model.Pile;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * A test for Pile abstract class.
 */
public class PileTest {
  Pile foundation = new FoundationPile();
  Pile cascade = new CascadePile();
  Pile open = new OpenPile();

  // Card initialized

  Card aceClub = new Card(Value.ACE, Suit.CLUB);
  Card twoClub = new Card(Value.TWO, Suit.CLUB);
  Card threeClub = new Card(Value.THREE, Suit.CLUB);
  Card fourClub = new Card(Value.FOUR, Suit.CLUB);
  Card fiveClub = new Card(Value.FIVE, Suit.CLUB);
  Card sixClub = new Card(Value.SIX, Suit.CLUB);
  Card sevenClub = new Card(Value.SEVEN, Suit.CLUB);
  Card eightClub = new Card(Value.EIGHT, Suit.CLUB);
  Card eightDiamond = new Card(Value.EIGHT, Suit.DIAMOND);
  Card nineClub = new Card(Value.NINE, Suit.CLUB);
  Card tenDiamond = new Card(Value.TEN, Suit.DIAMOND);
  Card jackClub = new Card(Value.JACK, Suit.CLUB);
  Card queenHeart = new Card(Value.QUEEN, Suit.HEART);
  Card kingClub = new Card(Value.KING, Suit.CLUB);


  @Before
  public void setUp() {
    foundation.add(aceClub);
    foundation.add(twoClub);
    foundation.add(threeClub);
    foundation.add(fourClub);
    foundation.add(fiveClub);
    foundation.add(sixClub);
    foundation.add(sevenClub);
    foundation.add(eightClub);

    open.add(sevenClub);

    cascade.add(kingClub);
    cascade.add(queenHeart);
    cascade.add(jackClub);
    cascade.add(tenDiamond);
    cascade.add(nineClub);

  }

  @Test
  public void testNumberOfCards() {
    Pile pile = new OpenPile();
    assertEquals(pile.numberOfCards(), 0);
    assertEquals(foundation.numberOfCards(), 8);
    assertEquals(open.numberOfCards(), 1);
    assertEquals(cascade.numberOfCards(), 5);
    foundation.add((nineClub));
    assertEquals(foundation.numberOfCards(), 9);
    cascade.add(eightDiamond);
    assertEquals(cascade.numberOfCards(), 6);
    open.add(twoClub);
    assertEquals(open.numberOfCards(), 2);

  }


  @Test
  public void testGetCardAt() {
    assertEquals(foundation.getCardAt(0), aceClub);
    assertEquals(foundation.getCardAt(1), twoClub);
    assertEquals(foundation.getCardAt(2), threeClub);
    assertEquals(foundation.getCardAt(3), fourClub);
    assertEquals(foundation.getCardAt(4), fiveClub);
    assertNull(foundation.getCardAt(100));

    assertEquals(open.getCardAt(0), sevenClub);
    assertNull(open.getCardAt(1));

    assertEquals(cascade.getCardAt(0), kingClub);
    assertEquals(cascade.getCardAt(1), queenHeart);
    assertEquals(cascade.getCardAt(2), jackClub);
    assertEquals(cascade.getCardAt(3), tenDiamond);
    assertNull(cascade.getCardAt(10));

  }

  @Test
  public void testAdd() {
    foundation.add(nineClub);
    assertEquals(foundation.numberOfCards(), 9);

    cascade.add(tenDiamond);
    assertEquals(cascade.numberOfCards(), 6);

    cascade.add(null);
    assertEquals(cascade.numberOfCards(), 6);

    open.add(twoClub);
    assertEquals(open.numberOfCards(), 2);
  }

  @Test(expected = IllegalStateException.class)
  public void testGetTopCardEmptyPile() {
    Pile emptyPile = new OpenPile();
    emptyPile.getTopCard();
  }

  @Test
  public void testGetTopCard() {
    assertEquals(foundation.getTopCard(), eightClub);
    assertEquals(cascade.getTopCard(), nineClub);
    assertEquals(open.getTopCard(), sevenClub);
  }


  @Test
  public void testRemove() {
    foundation.remove(sevenClub);
    assertEquals(foundation.numberOfCards(), 7);
    cascade.remove(kingClub);
    assertEquals(cascade.numberOfCards(), 4);
    open.remove(sevenClub);
    assertEquals(open.numberOfCards(), 0);
  }

  @Test
  public void testIsEmpty() {
    Pile emptyPile = new OpenPile();
    assertTrue(emptyPile.isEmpty());
    assertFalse(open.isEmpty());
    assertFalse(foundation.isEmpty());
    assertFalse(cascade.isEmpty());
  }
}