package cs3500.band;

import java.util.List;

public interface Manager extends Musician {

  /**
   * Keeps track of bank accounts.
   *
   * @return an int - value of the bank
   */
  int getBankAccount();

  /**
   * Record bookings for the ensemble.
   * @param ensemble an Ensemble - an ensemble's gigs
   * @throws IllegalArgumentException if the ensemble is null.
   */
  void addBookings(Ensemble ensemble);

  /**
   * Keeps track of ensemble's gigs.
   * @return a list of Ensemble - ensemble's gigs
   */
  List<Ensemble> getBookings();
  /**
   * Accepting the payments on behalf of the group, takes in a name of the payment.
   *
   * @param nameOfPayment a String - name of the payment.
   * @param amount a int - amount of payment
   * @throws IllegalArgumentException if the amount is less than zero
   *
   */
  void acceptingPayment(String nameOfPayment, int amount);

  /**
   * Making the payments on behalf of the group, tkaes in a name of the payment.
   * @param nameOfPayment a String - name of the payment
   * @throws IllegalArgumentException if the name of the payment is not found.
   */
  void makingPayment(String nameOfPayment);

}
