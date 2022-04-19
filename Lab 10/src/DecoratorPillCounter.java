/**
 * A decorator class for LoggingPillCounter that implements the Pill
 * Counter interface.
 */
public class DecoratorPillCounter implements PillCounter {
  private final PillCounter counter;

  /**
   * A constructor for DecoratorPillCounter.
   * @param counter a PillCounter
   */
  public DecoratorPillCounter(PillCounter counter) {
    if (counter == null) {
      throw new IllegalArgumentException("Counter is null");
    }
    this.counter = counter;
  }

  /**
   * Add the specific number of pills to this counter. This method
   * is general enough to work with machines with different pill-filling
   * capacities.
   *
   * @param count a int
   */
  @Override
  public void addPill(int count) {
    counter.addPill(count);

  }

  /**
   * Remove a pill from this counter. This method is called in case
   * a malfunction in the hardware is detected and it dispenses too
   * many pills. Only one pill may be removed at a time.
   */
  @Override
  public void removePill() {
    counter.removePill();
  }

  /**
   * Reset the counter to 0.
   */
  @Override
  public void reset() {
    counter.reset();
  }

  /**
   * Return how many pills have been counted so far.
   *
   * @return a int
   */
  @Override
  public int getPillCount() {
    return counter.getPillCount();
  }
}
