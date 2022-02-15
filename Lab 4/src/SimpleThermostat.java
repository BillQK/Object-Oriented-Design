import java.util.Objects;

/**
 * Represent a simple thermostat.
 */
public class SimpleThermostat implements Thermostat {
  private final String ID;
  private final double increment;
  private final double Kelvin;
  private double degree;

  /**
   * A constructor for simple thermostat.
   *
   * @param id     a String
   * @param degree a double
   * @throws IllegalArgumentException if the argument for degree is higher or equal to 50, throw an
   *                                  error, also if the arguments for id is empty,
   *                                  throw an exception.
   */
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
   * A method that get the ID.
   *
   * @return a string representation of an ID
   */
  @Override
  public String getID() {
    return this.ID;
  }

  /**
   * A method that get the temperature in degree Kelvin that the thermostat is set to.
   *
   * @return a double that represent the temperature in the Kelvin
   */
  @Override
  public double getSetTemperature() {
    return this.degree + this.Kelvin;
  }

  /**
   * a method that increases the set temperature for the thermostat
   * (by an implementation dependent amount).
   */
  @Override
  public void increaseSetTemperature() {
    this.degree += this.increment;
  }

  /**
   * a method that decreases the set temperature for the thermostat
   * (by an implementation-dependent amount).
   */
  @Override
  public void decreaseSetTemperature() {
    this.degree -= this.increment;
  }

  /**
   * This is an override method of equals, the equality
   * in equals' method is rounding temperature values to two decimal places.
   *
   * @param o an Object
   * @return a boolean value
   */
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
              && ((Math.round(this.degree * 100) / 100.0)
              == (Math.round(thermostat.degree * 100) / 100.0));
    }
  }

  /**
   * a method that hash the id and the degree.
   *
   * @return a int value
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.ID, Math.round(this.degree * 100) / 100);
  }

  //  /**
  //   * This is an override method of equals, the equality in this equals'
  //   * method is if the differences between two degree is less than 0.01, then it is equal
  //   * @return a boolean
  //   */
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
  //
  //  /**
  //   * a method that hash the ID and the degree value
  //   * @return
  //   */
  //  @Override
  //  public int hashCode() {
  //    return Objects.hash(this.ID, this.degree);
  //  }
}
