/**
 * A thermostat interface
 */
public interface Thermostat {
  /**
   * A method to retrieve its unique ID
   */
  String getID();

  /**
   * A method to get the temperature in degrees Kelvin that the thermostat is set to
   */
  double getSetTemperature();
  /**
   * A method that increases the set temperature for the thermostat
   * (by an implementation dependent amount)
   */
  void increaseSetTemperature();
  /**
   * a method that decreases the set temperature for the thermostat
   * (by an implementation-dependent amount)
   */
  void decreaseSetTemperature();
}

