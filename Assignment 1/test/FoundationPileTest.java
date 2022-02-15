import org.junit.Test;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.FoundationPile;
import cs3500.freecell.model.Pile;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A test class for foundation.
 */
public class FoundationPileTest {
  Pile foundationPile = new FoundationPile();


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCanBeAddedDifferentSuit() {
    foundationPile.add(new Card(Value.ACE, Suit.SPADE));
    foundationPile.canBeAdded(new Card(Value.TWO, Suit.HEART));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCanBeAddedEmptyPile() {
    foundationPile.canBeAdded(new Card(Value.TEN, Suit.SPADE));
  }

  @Test
  public void canBeAdded() {
    assertTrue(foundationPile.canBeAdded(new Card(Value.ACE, Suit.SPADE)));
    foundationPile.add(new Card(Value.ACE, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.TWO, Suit.SPADE)));
    foundationPile.add(new Card(Value.TWO, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.THREE, Suit.SPADE)));
    foundationPile.add(new Card(Value.THREE, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.FOUR, Suit.SPADE)));
    foundationPile.add(new Card(Value.FOUR, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.FIVE, Suit.SPADE)));
    foundationPile.add(new Card(Value.FIVE, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.SIX, Suit.SPADE)));
    foundationPile.add(new Card(Value.SIX, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.SEVEN, Suit.SPADE)));
    foundationPile.add(new Card(Value.SEVEN, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.EIGHT, Suit.SPADE)));
    foundationPile.add(new Card(Value.EIGHT, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.NINE, Suit.SPADE)));
    foundationPile.add(new Card(Value.NINE, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.TEN, Suit.SPADE)));
    foundationPile.add(new Card(Value.TEN, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.JACK, Suit.SPADE)));
    foundationPile.add(new Card(Value.JACK, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.QUEEN, Suit.SPADE)));
    foundationPile.add(new Card(Value.QUEEN, Suit.SPADE));
    assertTrue(foundationPile.canBeAdded(new Card(Value.KING, Suit.SPADE)));

  }

  @Test
  public void validPile() {
    // Cascade can be added to Foundation
    // Open can be added to Foudnation
    assertTrue(foundationPile.validPile(PileType.CASCADE));
    assertTrue(foundationPile.validPile(PileType.OPEN));
    // Foundation cannot be add to Foundation
    assertFalse(foundationPile.validPile(PileType.FOUNDATION));
  }

}