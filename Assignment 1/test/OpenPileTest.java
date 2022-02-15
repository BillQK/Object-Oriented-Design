import org.junit.Test;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.OpenPile;
import cs3500.freecell.model.Pile;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A test class for Open Pile.
 */
public class OpenPileTest {
  Pile openPile = new OpenPile();

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCanBeAddedNotEmpty() {
    openPile.add(new Card(Value.ACE, Suit.SPADE));
    openPile.canBeAdded(new Card(Value.TWO, Suit.HEART));
  }

  @Test
  public void canBeAdded() {
    assertTrue(openPile.canBeAdded(new Card(Value.ACE, Suit.HEART)));
    assertTrue(openPile.canBeAdded(new Card(Value.TEN, Suit.CLUB)));
    openPile.add(new Card(Value.ACE, Suit.SPADE));
  }

  @Test
  public void validPile() {
    // Cascade can be added to Open
    // Open can be added to Open
    assertTrue(openPile.validPile(PileType.CASCADE));
    assertTrue(openPile.validPile(PileType.OPEN));
    // Foundation cannot be add to Open
    assertFalse(openPile.validPile(PileType.FOUNDATION));
  }
}