import org.junit.Test;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A Test for card class
 */
public class CardTest {

  /**
   * a deck of card initialization.
   */
  Card aceHeart = new Card(Value.ACE, Suit.HEART);
  Card aceSpade = new Card(Value.ACE, Suit.SPADE);
  Card aceClub = new Card(Value.ACE, Suit.CLUB);
  Card aceDiamond = new Card(Value.ACE, Suit.DIAMOND);

  Card twoHeart = new Card(Value.TWO, Suit.HEART);
  Card twoSpade = new Card(Value.TWO, Suit.SPADE);
  Card twoClub = new Card(Value.TWO, Suit.CLUB);
  Card twoDiamond = new Card(Value.TWO, Suit.DIAMOND);

  Card threeHeart = new Card(Value.THREE, Suit.HEART);
  Card threeSpade = new Card(Value.THREE, Suit.SPADE);
  Card threeClub = new Card(Value.THREE, Suit.CLUB);
  Card threeDiamond = new Card(Value.THREE, Suit.DIAMOND);

  Card fourHeart = new Card(Value.FOUR, Suit.HEART);
  Card fourSpade = new Card(Value.FOUR, Suit.SPADE);
  Card fourClub = new Card(Value.FOUR, Suit.CLUB);
  Card fourDiamond = new Card(Value.FOUR, Suit.DIAMOND);

  Card fiveHeart = new Card(Value.FIVE, Suit.HEART);
  Card fiveSpade = new Card(Value.FIVE, Suit.SPADE);
  Card fiveClub = new Card(Value.FIVE, Suit.CLUB);
  Card fiveDiamond = new Card(Value.FIVE, Suit.DIAMOND);

  Card sixHeart = new Card(Value.SIX, Suit.HEART);
  Card sixSpade = new Card(Value.SIX, Suit.SPADE);
  Card sixClub = new Card(Value.SIX, Suit.CLUB);
  Card sixDiamond = new Card(Value.SIX, Suit.DIAMOND);

  Card sevenHeart = new Card(Value.SEVEN, Suit.HEART);
  Card sevenSpade = new Card(Value.SEVEN, Suit.SPADE);
  Card sevenClub = new Card(Value.SEVEN, Suit.CLUB);
  Card sevenDiamond = new Card(Value.SEVEN, Suit.DIAMOND);

  Card eightHeart = new Card(Value.EIGHT, Suit.HEART);
  Card eightSpade = new Card(Value.EIGHT, Suit.SPADE);
  Card eightClub = new Card(Value.EIGHT, Suit.CLUB);
  Card eightDiamond = new Card(Value.EIGHT, Suit.DIAMOND);

  Card nineHeart = new Card(Value.NINE, Suit.HEART);
  Card nineSpade = new Card(Value.NINE, Suit.SPADE);
  Card nineClub = new Card(Value.NINE, Suit.CLUB);
  Card nineDiamond = new Card(Value.NINE, Suit.DIAMOND);

  Card tenHeart = new Card(Value.TEN, Suit.HEART);
  Card tenSpade = new Card(Value.TEN, Suit.SPADE);
  Card tenClub = new Card(Value.TEN, Suit.CLUB);
  Card tenDiamond = new Card(Value.TEN, Suit.DIAMOND);

  Card jackHeart = new Card(Value.JACK, Suit.HEART);
  Card jackSpade = new Card(Value.JACK, Suit.SPADE);
  Card jackClub = new Card(Value.JACK, Suit.CLUB);
  Card jackDiamond = new Card(Value.JACK, Suit.DIAMOND);

  Card queenHeart = new Card(Value.QUEEN, Suit.HEART);
  Card queenSpade = new Card(Value.QUEEN, Suit.SPADE);
  Card queenClub = new Card(Value.QUEEN, Suit.CLUB);
  Card queenDiamond = new Card(Value.QUEEN, Suit.DIAMOND);

  Card kingHeart = new Card(Value.KING, Suit.HEART);
  Card kingSpade = new Card(Value.KING, Suit.SPADE);
  Card kingClub = new Card(Value.KING, Suit.CLUB);
  Card kingDiamond = new Card(Value.KING, Suit.DIAMOND);
  Card kingHeart2 = new Card(Value.KING, Suit.HEART);
  Card queenHeart2 = new Card(Value.QUEEN, Suit.HEART);

  @Test(expected = IllegalArgumentException.class)
  public void testCreateCardWithNULL() {
    // Create card with null values
    Card nullSuitCard = new Card(Value.KING, null);
    Card nullValueCard = new Card(null, Suit.HEART);
    Card nullCard = new Card(null, null);
  }

  @Test
  public void testToString() {
    assertEquals(aceHeart.toString(), "A♥");
    assertEquals(twoHeart.toString(), "2♥");
    assertEquals(threeHeart.toString(), "3♥");
    assertEquals(jackHeart.toString(), "J♥");
    assertEquals(queenHeart.toString(), "Q♥");
    assertEquals(kingHeart.toString(), "K♥");

  }

  @Test
  public void testEquals() {
    assertTrue(kingHeart.equals(kingHeart2));
    assertTrue(queenHeart.equals(queenHeart2));
  }

  @Test
  public void testHashCode() {
    assertTrue(kingHeart.hashCode() == kingHeart2.hashCode());
    assertTrue(queenHeart.hashCode() == queenHeart2.hashCode());
  }

  @Test
  public void isValidToAddToFoundation() {
    assertTrue(aceHeart.isValidToAddToFoundation(twoHeart));
  }

  @Test(expected = IllegalArgumentException.class)
  public void isNotValidToAddToFoundation() {
    aceHeart.isValidToAddToFoundation(threeHeart);
    sevenClub.isValidToAddToFoundation(threeHeart);
    eightClub.isValidToAddToFoundation(threeHeart);
    nineClub.isValidToAddToFoundation(threeHeart);
    tenClub.isValidToAddToFoundation(threeHeart);

  }

  @Test(expected = IllegalArgumentException.class)
  public void isNotValidToAddToCascade() {
    threeHeart.isValidToAddToCascade(aceHeart);
    aceHeart.isValidToAddToCascade(twoHeart);
    kingHeart.isValidToAddToCascade(kingHeart);
    kingHeart.isValidToAddToCascade(queenHeart);
    jackHeart.isValidToAddToCascade(jackClub);
    queenHeart.isValidToAddToCascade(jackClub);
    twoHeart.isValidToAddToCascade(jackClub);
    fiveClub.isValidToAddToCascade(jackClub);
  }

  @Test
  public void isValidToAddToCascade() {
    assertTrue(kingHeart.isValidToAddToCascade(queenSpade));
    assertTrue(threeHeart.isValidToAddToCascade(twoSpade));
  }

  @Test
  public void isAnAce() {
    assertTrue(aceHeart.isAnAce());
    assertTrue(aceSpade.isAnAce());
    assertTrue(aceClub.isAnAce());
    assertTrue(aceDiamond.isAnAce());

    assertFalse(twoHeart.isAnAce());
    assertFalse(twoClub.isAnAce());
    assertFalse(twoDiamond.isAnAce());
    assertFalse(twoSpade.isAnAce());
  }
}