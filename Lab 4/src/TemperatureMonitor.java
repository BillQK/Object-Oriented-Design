/**
 * This is an interface to represent a Temperature Monitor.
 */
public interface TemperatureMonitor {

  /**
   * a method that add a thermostat to the list of monitor.
   */
  void add(Thermostat t);

  /**
   * a method that remove a thermostat from the list of monitor.
   */
  void remove(Thermostat t);

  /**
   * a method that return the number of thermostat in the list of monitor.
   */
  int getNumberOfThermostats();

  /**
   * a method that return a true if more than one of thermostat is overheated
   * which is higher than 23 Celsius. Return false if less than one of thermostat
   * is higher than 23 Celsius.
   */
  boolean tooMuchHeating();
}
