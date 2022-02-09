import org.junit.Test;

import cs3500.freecell.model.Suit;

import static org.junit.Assert.*;

public class SuitTest {
  Suit heart = Suit.HEART;
  Suit spade = Suit.SPADE;
  Suit diamond = Suit.DIAMOND;
  Suit club = Suit.CLUB;

  /**
   * Represent 4 suit-value of cards clubs (♣), diamonds (♦),
   * hearts (♥), and spades (♠). Hearts and diamonds are colored
   * red, clubs and spades are colored black.
   */
  @Test
  public void getGraf() {
    assertEquals(heart.getGraf(), '♥');
    assertEquals(spade.getGraf(), '♠');
    assertEquals(diamond.getGraf(), '♦');
    assertEquals(club.getGraf(), '♣');
  }

  @Test
  public void testToString() {
    assertEquals(heart.toString(), "♥");
    assertEquals(spade.toString(), "♠");
    assertEquals(diamond.toString(), "♦");
    assertEquals(club.toString(), "♣");
  }

  @Test
  public void isSameType() {
    assertTrue(heart.isSameType(heart));
    assertTrue(spade.isSameType(spade));
    assertTrue(diamond.isSameType(diamond));
    assertTrue(club.isSameType(club));

    assertFalse(heart.isSameType(club));
    assertFalse(heart.isSameType(spade));
    assertFalse(spade.isSameType(diamond));
    assertFalse(diamond.isSameType(heart));
  }

  @Test
  public void isDifferentColor() {
    assertFalse(heart.isDifferentColor(diamond));
    assertFalse(spade.isDifferentColor(spade));
    assertFalse(diamond.isDifferentColor(heart));
    assertFalse(club.isDifferentColor(club));

    assertTrue(heart.isDifferentColor(club));
    assertTrue(heart.isDifferentColor(spade));
    assertTrue(spade.isDifferentColor(diamond));
    assertTrue(diamond.isDifferentColor(club));
  }


}