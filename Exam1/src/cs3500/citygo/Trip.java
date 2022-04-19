package cs3500.citygo;

import java.util.Objects;

/**
 * Represents a single trip between two points by a customer on a scooter.
 */
public class Trip {
  private final Coord start;
  private Coord end;
  private final Scooter s;
  private final String c;

  /**
   * Initialize and start the trip, with the given scooter and customer. Customer argument is
   * assumed to uniquely identify the customer. The scooter must be available.
   * @param s scooter to be used
   * @param c customer taking the trip
   */
  public Trip(Scooter s, String c) {
    if(s.getStatus() != Scooter.Status.AVAILABLE) {
      throw new IllegalArgumentException("Scooter is not available");
    }
    s.setStatus(Scooter.Status.IN_USE);
    this.start = s.getLocation();
    this.s = s;
    this.c = c;
    this.end = null;
  }

  public Trip (Trip t) {
    this.start = t.start;
    this.s = t.s;
    this.c = t.c;
    this.end = t.end;
  }

  /**
   * Get the length of the trip in miles. Trip must be completed.
   * @return distance in miles
   * @throws IllegalStateException if the trip is in progress
   */
  public double getDistance() {
    if(isActive()) {
      throw new IllegalStateException("Can't get distance while trip is in progress");
    }
    return start.distance(end);
  }

  /**
   * End a currently active trip.
   * @param end the endpoint of the trip
   * @throws IllegalStateException if the trip is not active
   */
  public void endTrip(Coord end) {
    if(!isActive()) {
      throw new IllegalStateException("Cannot end trip that is not active");
    }
    if (end == null) {
      throw new IllegalArgumentException("Trip end cannot be null");
    }
    s.setStatus(Scooter.Status.AVAILABLE);
    s.setChargeLevel(Integer.max(0, (int)Math.round(s.getChargeLevel()
        - Scooter.MILES_PER_CHARGE_UNIT * s.getLocation().distance(end))));
    s.move(end);
    this.end = end;
  }

  public boolean isActive() {
    return s.getStatus() == Scooter.Status.IN_USE;
  }

  public String getCustomer() {
    return this.c;
  }

  /**
   * Get this trip's scooter.
   * @return a copy of the scooter
   */
  public Scooter getScooter() {
    return new Scooter(this.s);
  }

  @Override
  public boolean equals(Object o) {
    if(o instanceof Trip) {
      Trip t = (Trip) o;
      return t.start.equals(this.start) && t.end.equals(this.end)
          && t.getScooter().equals(this.getScooter())
          && t.getCustomer().equals(this.getCustomer());
    }
    return false;
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.start, this.end, this.getScooter(), this.getCustomer());
  }
}
