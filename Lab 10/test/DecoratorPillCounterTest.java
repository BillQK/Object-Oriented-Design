import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A test class for the decorator.
 */
public class DecoratorPillCounterTest {
  PillCounter pillCounter = new LoggingPillCounter();
  DecoratorPillCounter delegatePillCounter = new DecoratorPillCounter(pillCounter);

  @Test
  public void testAddPill() {
    delegatePillCounter.addPill(1);
    assertEquals(delegatePillCounter.getPillCount(), 1);
  }

  @Test
  public void testRemovePill() {
    delegatePillCounter.removePill();
    assertEquals(delegatePillCounter.getPillCount(), 0);
  }

  @Test
  public void testReset() {
    delegatePillCounter.addPill(10);
    delegatePillCounter.reset();
    assertEquals(delegatePillCounter.getPillCount(), 0);
  }

  @Test
  public void testGetPillCount() {
    delegatePillCounter.addPill(100);
    assertEquals(delegatePillCounter.getPillCount(), 100);
  }
}