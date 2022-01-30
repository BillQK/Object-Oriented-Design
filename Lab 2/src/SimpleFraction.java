/**
 * This is the class represent the different operation of a SimpleFraction.
 */
public class SimpleFraction implements Fraction {
  private final int numerator;
  private final int denominator;

  /**
   * This is a constructor of SimpleFraction.
   *
   * @param numerator   an Integer represent the numerator of a Fraction
   * @param denominator an Integer represent the denominator of a Fraction
   * @throws IllegalArgumentException if the arguments are negative
   */
  public SimpleFraction(int numerator, int denominator) {
    if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)
            || denominator == 0) {
      throw new IllegalArgumentException("Cannot be Negative");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * a method that add two Fraction Object.
   *
   * @param other an instance of a Fraction object
   * @return a Fraction the have the sum value
   */
  @Override
  public Fraction add(Fraction other) {
    return other.add(this.numerator, this.denominator);
  }

  /**
   * a method that add to the Fraction object given the numerator and the
   * denominator, throws IllegalArgumentException if the arguments is negative.
   *
   * @param numerator   Integer value of the numerator
   * @param denominator Integer value of the denominator
   * @return a sum value of Fraction
   * @throws IllegalArgumentException if the arguments is negative
   */
  @Override
  public Fraction add(int numerator, int denominator) throws IllegalArgumentException {
    if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)
            || denominator == 0) {
      throw new IllegalArgumentException("Invalid Arguments ");
    } else {
      int commonDenominator = this.denominator * denominator;
      int sumNumerator = this.numerator * denominator + numerator * this.denominator;
      return new SimpleFraction(sumNumerator, commonDenominator);
    }
  }

  /**
   * A method that return the Fraction to a given decimals places.
   *
   * @param places decimals places
   * @return return a double to a given decimals places
   */
  @Override
  public double getDecimalValue(int places) {
    double scale = Math.pow(10, places);
    double value = (double) this.numerator / this.denominator;
    return Math.round(value * scale) / scale;
  }

  /**
   * A method that return a Fraction to a n/d style.
   *
   * @return a String that represent a Fraction in n/d style
   */
  @Override
  public String toString() {
    if (this.numerator < 0 && this.denominator < 0) {
      return (this.numerator * -1) + "/" + (this.denominator * -1);
    } else {
      return this.numerator + "/" + this.denominator;
    }

  }

}
