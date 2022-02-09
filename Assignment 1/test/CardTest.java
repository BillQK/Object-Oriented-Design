import org.junit.Test;

import cs3500.freecell.Card.Card;
import cs3500.freecell.Card.Suit;
import cs3500.freecell.Card.Value;

import static org.junit.Assert.*;

public class CardTest {

  Card aceHeart = new Card(Value.ACE, Suit.HEART);
  Card twoHeart = new Card(Value.TWO, Suit.HEART);
  Card threeHeart = new Card(Value.THREE, Suit.HEART);

  Card twoSpade = new Card(Value.TWO, Suit.SPADE);

  @Test
  public void testToString() {
  }

  @Test
  public void testEquals() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void isValidToAddToFoundation() {
    assertTrue(aceHeart.isValidToAddToFoundation(twoHeart));
    assertFalse(aceHeart.isValidToAddToFoundation(threeHeart));
  }

  @Test
  public void isValidToAddToCascade() {
    assertTrue(threeHeart.isValidToAddToCascade(twoSpade));
  }

  @Test
  public void isAnAce() {
  }
}