import org.junit.Test;

import cs3500.freecell.model.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueTest {
  Value ace = Value.ACE;
  Value two = Value.TWO;
  Value three = Value.THREE;
  Value four = Value.FOUR;
  Value five = Value.FIVE;
  Value six = Value.SIX;
  Value seven = Value.SEVEN;
  Value eight = Value.EIGHT;
  Value nine = Value.NINE;
  Value ten = Value.TEN;
  Value jack = Value.JACK;
  Value queen = Value.QUEEN;
  Value king = Value.KING;

  @Test
  public void testToString() {
    assertEquals(ace.toString(), "A");
    assertEquals(two.toString(), "2");
    assertEquals(three.toString(), "3");
    assertEquals(four.toString(), "4");
    assertEquals(five.toString(), "5");
    assertEquals(six.toString(), "6");
    assertEquals(seven.toString(), "7");
    assertEquals(eight.toString(), "8");
    assertEquals(nine.toString(), "9");
    assertEquals(ten.toString(), "10");
    assertEquals(jack.toString(), "J");
    assertEquals(queen.toString(), "Q");
    assertEquals(king.toString(), "K");

  }

  @Test
  public void getValue() {
    assertEquals(ace.getValue(), 1);
    assertEquals(two.getValue(), 2);
    assertEquals(three.getValue(), 3);
    assertEquals(four.getValue(), 4);
    assertEquals(five.getValue(), 5);
    assertEquals(six.getValue(), 6);
    assertEquals(seven.getValue(), 7);
    assertEquals(eight.getValue(), 8);
    assertEquals(nine.getValue(), 9);
    assertEquals(ten.getValue(), 10);
    assertEquals(jack.getValue(), 11);
    assertEquals(queen.getValue(), 12);
    assertEquals(king.getValue(), 13);
  }

  @Test
  public void isOneGreater() {
    assertFalse(king.isOneGreater(queen));
    assertFalse(queen.isOneGreater(jack));
    assertFalse(jack.isOneGreater(ten));
    assertFalse(ten.isOneGreater(nine));
    assertFalse(nine.isOneGreater(eight));
    assertFalse(eight.isOneGreater(seven));
    assertFalse(seven.isOneGreater(six));
    assertFalse(six.isOneGreater(five));
    assertFalse(five.isOneGreater(four));
    assertFalse(four.isOneGreater(three));
    assertFalse(three.isOneGreater(two));
    assertFalse(two.isOneGreater(ace));

    assertTrue(ace.isOneGreater(two));
    assertTrue(two.isOneGreater(three));
    assertTrue(three.isOneGreater(four));
    assertTrue(four.isOneGreater(five));
    assertTrue(five.isOneGreater(six));
    assertTrue(six.isOneGreater(seven));
    assertTrue(seven.isOneGreater(eight));
    assertTrue(eight.isOneGreater(nine));
    assertTrue(nine.isOneGreater(ten));
    assertTrue(ten.isOneGreater(jack));
    assertTrue(jack.isOneGreater(queen));
    assertTrue(queen.isOneGreater(king));

    assertFalse(ace.isOneGreater(ace));

  }

  @Test
  public void isOneLower() {
    assertTrue(two.isOneSmaller(ace));
    assertTrue(king.isOneSmaller(queen));
  }
}