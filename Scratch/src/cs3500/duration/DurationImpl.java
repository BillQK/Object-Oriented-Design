package cs3500.duration;

/**
 * Represent a basic form of duration
 */
public class DurationImpl implements Duration {
  private final int hours;
  private final int minutes;
  private final int seconds;

  /**
   * Construct a Duration
   * @param hours the hours
   * @param minutes the minutes
   * @param seconds the seconds
   */
  public DurationImpl(int hours, int minutes, int seconds) {
    if (hours < 0 || minutes < 0 || seconds < 0) {
      throw new IllegalArgumentException("Duration specifiers can't be negative");
    }
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
  }



  @Override
  public Duration add(Duration b) {

    return null;
  }

  @Override
  public String asHms() {
    return null;
  }

  @Override
  public int compareTo(Duration o) {
    return 0;
  }
}
