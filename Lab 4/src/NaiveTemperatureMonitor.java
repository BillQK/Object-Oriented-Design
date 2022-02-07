import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a temperature monitor. It tracks several thermostats, and specifically
 * monitors how many of them have been set to too hot.
 */

public class NaiveTemperatureMonitor implements TemperatureMonitor {
  private final List<Thermostat> thermostatList;

  /**
   * A constructor for native temperature Monitor.
   */
  public NaiveTemperatureMonitor() {
    this.thermostatList = new ArrayList<Thermostat>();
  }

  /**
   * a method that add a thermostat into the monitor list.
   *
   * @param t A thermostat
   */
  public void add(Thermostat t) {
    thermostatList.add(t);
  }

  /**
   * a method that remove a thermostat from the monitor list.
   *
   * @param t a thermostat
   */
  public void remove(Thermostat t) {
    thermostatList.remove(t);
  }

  /**
   * a method that return the number of thermostat in the list.
   *
   * @return the int value that represent the number of thermostat in the list
   */
  public int getNumberOfThermostats() {
    return thermostatList.size();
  }

  /**
   * a method that return a true or false value if the one of the thermostat in the monitor list is
   * overheating, that is greater than 23 Celsius.
   * @return a boolean; if  more than one of thermostat is greater than 23 Celsius return true, else
   * return false.
   */
  public boolean tooMuchHeating() {
    int count = 0;
    for (Thermostat t : thermostatList) {
      if (t.getSetTemperature() > 23 + 273.15) {
        count += 1;
      }

    }
    return count > 1;
  }
}
