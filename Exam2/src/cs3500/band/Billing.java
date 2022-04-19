package cs3500.band;

/**
 * A representation of a concert with multiple ensembles performing.
 */
public interface Billing {
  // add an ensemble with a name
  void addEnsemble(String name, Ensemble ensemble);

  // set percentage of revenue according to the name of the band
  void setPercentageOfRevenue(String nameOfBand);

  // set the amount earned by the Billing
  void setTotalMoneyEarned(double amountEarned);

  // return the amount of money given the name of the Band on the
  // designated percentage and the total amount earned
  double moneyGiveToBand(double percentage, String nameOfBand);
}
