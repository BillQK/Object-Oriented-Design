import org.junit.Test;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.CascadePile;
import cs3500.freecell.model.Pile;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * a test class cascade pile.
 */
public class CascadePileTest {
  /**
   * Initialize the Pile.
   */
  Pile cascadePile = new CascadePile();


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCanBeAdded() {
    cascadePile.add(new Card(Value.ACE, Suit.SPADE));
    assertTrue(cascadePile.canBeAdded(new Card(Value.TWO, Suit.HEART)));
  }

  @Test
  public void testCanBeAdded() {
    cascadePile.add(new Card(Value.THREE, Suit.SPADE));
    assertTrue(cascadePile.canBeAdded(new Card(Value.TWO, Suit.HEART)));
  }

  @Test
  public void testValidPile() {
    // Cascade can be added to Cascade
    // Open can be added to Cascade
    assertTrue(cascadePile.validPile(PileType.CASCADE));
    assertTrue(cascadePile.validPile(PileType.OPEN));
    // Foundation cannot be add to Cascade
    assertFalse(cascadePile.validPile(PileType.FOUNDATION));
  }


}