package cs3500.band;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerImpl extends BasicMusician implements Manager {
  private int bankAccount;
  private final List<Ensemble> bookings;
  private final HashMap<String, Integer> payments;

  public ManagerImpl(String name, Instrument instrument, boolean canSing, int bankAccount ) {
    super(name, instrument, canSing);
    this.bankAccount = bankAccount;
    this.bookings = new ArrayList<>();
    this.payments = new HashMap<>();
  }

  /**
   * Keeps track of bank accounts.
   *
   * @return an int - value of the bank
   */
  @Override
  public int getBankAccount() {
    return this.bankAccount;
  }

  /**
   * Record bookings for the ensemble.
   * @param ensemble an Ensemble - an ensemble's gigs
   * @throws IllegalArgumentException if the ensemble is null.
   */
  @Override
  public void addBookings(Ensemble ensemble) {
    if (ensemble == null) {
      throw new IllegalArgumentException("Bookings cannot be null");
    }
    this.bookings.add(ensemble);
  }

  /**
   * Keeps track of ensemble's gigs.
   *
   * @return a list of Ensemble - ensemble's gigs
   */
  @Override
  public List<Ensemble> getBookings() {
    return new ArrayList<>(this.bookings);
  }

  /**
   * Accepting the payments on behalf of the group, takes in a name of the payment.
   *
   * @param nameOfPayment a String - name of the payment.
   * @param amount a int - amount of payment
   * @throws IllegalArgumentException if the amount is less than zero
   *
   */
  @Override
  public void acceptingPayment(String nameOfPayment, int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be less than zero");
    }
    this.payments.put(nameOfPayment,amount);
  }

  /**
   * Making the payments on behalf of the group, tkaes in a name of the payment.
   * @param nameOfPayment a String - name of the payment
   * @throws IllegalArgumentException if the name of the payment is not found.
   */
  @Override
  public void makingPayment(String nameOfPayment) {
    if (!this.payments.containsKey(nameOfPayment)) {
      throw new IllegalArgumentException("Payments does not found");
    }
    this.bankAccount -= this.payments.get(nameOfPayment);
    this.payments.remove(nameOfPayment);
  }
}
