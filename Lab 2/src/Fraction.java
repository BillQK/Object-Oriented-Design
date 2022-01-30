/**
 * This is the interface represent the different operation that a Fraction model
 * must support to return various aspects of its state. This interface does not provide
 * any operation to mutate the state of the Fraction object. This interface does provide
 * operations of the object's behavior.
 */
public interface Fraction {
  /**
   * - A method that add two Fraction object: Fraction add(fraction other).
   *
   * @param other an instance of a Fraction object
   * @return the sum value of two Fraction object.
   */
  Fraction add(Fraction other);

  /**
   * - A method that add to the Fraction object given the numerator and the
   * denominator: Fraction add(int numerator, int denominator), should throw
   * IllegalArgumentException if the arguments is negative.
   *
   * @param numerator   Integer value of the numerator
   * @param denominator Integer value of the denominator
   * @return the sum value of client Fraction object and the parameters.
   * @throws IllegalArgumentException if the fraction provided is negative
   */
  Fraction add(int numerator, int denominator);

  /**
   * -  method that get decimals value of Fraction rounded to
   * the given number of places, given number of places:
   * double getDecimalValue(int places).
   *
   * @param places decimals places
   * @return decimals value of a fraction
   */
  double getDecimalValue(int places);
}
