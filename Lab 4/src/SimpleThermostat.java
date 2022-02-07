import java.util.Objects;

/**
 * Represent a simple thermostat
 */
public class SimpleThermostat implements Thermostat {
  private final String ID;
  private final double increment;
  private final double Kelvin;
  private double degree;


  public SimpleThermostat(String id, double degree) {
    if (id.isEmpty()) {
      throw new IllegalArgumentException("Id cannot be blank");
    }
    if (degree > 50) {
      throw new IllegalArgumentException("Temperature cannot be greater than 50 degrees celsius");
    }
    this.ID = id;
    this.degree = degree;
    this.increment = 0.1;
    this.Kelvin = 273.15;
  }

  /**
   * A method that get the ID
   *
   * @return a string representation of an ID
   */
  @Override
  public String getID() {
    return this.ID;
  }

  /**
   * A method that get the temperature in degree Kelvin that the thermostat is set to
   *
   * @return a double that represent the temperature in the Kelvin
   */
  @Override
  public double getSetTemperature() {
    return this.degree + this.Kelvin;
  }

  /**
   * a method that increases the set temperature for the thermostat
   * (by an implementation dependent amount);
   */
  @Override
  public void increaseSetTemperature() {
    this.degree += this.increment;
  }

  /**
   * a method that decreases the set temperature for the thermostat
   * (by an implementation-dependent amount)
   */
  @Override
  public void decreaseSetTemperature() {
    this.degree -= this.increment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (getClass() != o.getClass()) {
      return false;
    } else {
      SimpleThermostat thermostat = (SimpleThermostat) o;
      return Objects.equals(this.ID, thermostat.getID())
              && ((Math.round(this.degree * 100) / 100.0) ==
              (Math.round(thermostat.degree * 100) / 100.0));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ID, this.degree);
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null) {
//      return false;
//    }
//    if (getClass() != o.getClass()) {
//      return false;
//    } else {
//      SimpleThermostat thermostat = (SimpleThermostat) o;
//      return  (Math.abs(this.degree - thermostat.degree)) < 0.01 &&
//              Objects.equals(this.ID, thermostat.ID);
//    }
//  }

//  /**
//   * a method that has the ID and the degree value
//   * @return
//   */
//  @Override
//  public int hashCode() {
//    return Objects.hash(this.ID, this.degree);
//  }
}
