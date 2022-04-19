/**
 * A LazyAddPill class the allow batch-adding.
 */
public class LazyAddPill extends DecoratorPillCounter {
  private int addedPills;

  /**
   * A constructor for the LazyAddPill.
   * @param counter a PillCounter
   */
  public LazyAddPill(PillCounter counter) {
    super(counter);
  }

  @Override
  public void addPill(int count) {
    addedPills += count;
  }

  @Override
  public void reset() {
    super.addPill(addedPills);
    super.reset();
    addedPills = 0;
  }

  @Override
  public int getPillCount() {
    super.addPill(addedPills);
    return super.getPillCount();
  }


}
