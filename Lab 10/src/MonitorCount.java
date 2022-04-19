import java.util.ArrayList;
import java.util.List;

/**
 * A MonitorCount that monitor how many time the addPill was called.
 */
public class MonitorCount extends DecoratorPillCounter {
  private List<Integer> addPillCounter;

  /**
   * A constructor for Monitor Count.
   * @param counter a PillCounter
   */
  public MonitorCount(PillCounter counter) {
    super(counter);
    addPillCounter = new ArrayList<>();
  }

  @Override
  public void addPill(int count) {
    super.addPill(count);
    addPillCounter.add(1);
  }

  @Override
  public void reset() {
    super.reset();
  }


}
