import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a testing class for SimpleFraction, including testing the class behaviors and
 * restrictions.
 */
public class SimpleFractionTest {
  private static final double DELTA = 1e-15;
  private Fraction a;
  private Fraction b;
  private Fraction c;
  private Fraction d;

  @Before
  public void setUp() {
    a = new SimpleFraction(3, 4);
    b = new SimpleFraction(10, 25);
    c = new SimpleFraction(5, 4);
    d = new SimpleFraction(1, 3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    new SimpleFraction(-1, -1);
    new SimpleFraction(-1, 3);
    new SimpleFraction(4, -4);
    new SimpleFraction(-3, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add() {
    // Catch Exception
    a.add(-1, -3);
    b.add(-21, -3);
    c.add(-2, 4);
    d.add(1, -3);
    // Testing Behavior
    Fraction l = new SimpleFraction(3, 4);
    assertEquals(c.add(a).toString(), "8/4");
    assertEquals(b.add(l).toString(), "6/4");
    assertEquals(d.add(c).toString(), "19/12");

  }

  @Test
  public void testAdd() {
    assertEquals(a.add(3, 4).toString(), "24/16");
    assertEquals(b.add(3, 25).toString(), "325/625");
    assertEquals(c.add(3, 1).toString(), "17/4");
    assertEquals(d.add(2, 6).toString(), "12/18");
  }

  @Test
  public void getDecimalValue() {
    assertEquals(a.getDecimalValue(3), 0.750, DELTA);
    assertEquals(b.getDecimalValue(10), 0.4000000000, DELTA);
    assertEquals(c.getDecimalValue(0), 1, DELTA);
    assertEquals(d.getDecimalValue(5), 0.33333, DELTA);
  }

  @Test
  public void testToString() {
    assertEquals(a.toString(), "3/4");
    assertEquals(b.toString(), "10/25");
    assertEquals(c.toString(), "5/4");
    assertEquals(d.toString(), "1/3");

  }

}