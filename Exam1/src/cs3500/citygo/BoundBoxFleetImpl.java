package cs3500.citygo;

import java.util.List;

public class BoundBoxFleetImpl implements BoundBoxFleet {
  private Coord northwest, southeast;
  private Fleet delegate;

  public BoundBoxFleetImpl(Fleet delegate) {
    this.delegate = delegate;
  }

  /**
   * Allow the user of a Fleet to set the northwest corner and the southeast corner of a geographical
   * rectangle, outside of which no scooter can be added, and no trip can be ended.
   *
   * @param latitude
   * @param longtitude
   */
  @Override
  public void boundingBox(Coord latitude, Coord longtitude) {
    northwest = latitude;
    southeast = longtitude;
  }

  /**
   * Add one or more {@link Scooter} instances to the fleet
   *
   * @param s one or more scooters to be added
   */
  @Override
  public void addScooter(Scooter... s) {
    for (Scooter c : s) {
      if (c.getLocation().getLat() <= northwest.getLat()
              && c.getLocation().getLat() <= southeast.getLat()
              && c.getLocation().getLng() <= northwest.getLng()
              && c.getLocation().getLng() <= southeast.getLng()) {
        delegate.addScooter(s);
      }
    }

  }

  /**
   * Produce a list of scooters within a given radius, for example for an app to easily display
   * scooters near a user's location.
   *
   * @param pos      the center point location
   * @param distance the radius around the point within which to include scooters
   * @return list of scooters within the radius, in sorted order by distance, least to greatest
   */
  @Override
  public List<Scooter> getNearbyScooters(Coord pos, double distance) {
    return delegate.getNearbyScooters(pos, distance);
  }

  /**
   * Start a trip on a given scooter, for a given customer. Note that the scooter must be available,
   * and the customer is assumed to be unique, and cannot already be on an active trip.
   *
   * @param s        the scooter to be used on the trip
   * @param customer the customer taking the trip
   * @throws IllegalArgumentException if the scooter is not available, if the customer is already
   *                                  on a trip, or either argument is null.
   */
  @Override
  public void startTrip(Scooter s, String customer) {
    if (s.getLocation().getLat() <= northwest.getLat()
            && s.getLocation().getLat() <= southeast.getLat()
            && s.getLocation().getLng() <= northwest.getLng()
            && s.getLocation().getLng() <= southeast.getLng()) {
      delegate.startTrip(s, customer);
    }
  }

  /**
   * End a trip for a given customer, at the given end point.
   *
   * @param customer customer taking the trip
   * @param end      location where the trip ends
   * @throws IllegalStateException if the customer is not on any active trip
   */
  @Override
  public void endTrip(String customer, Coord end) {
    if (end.getLat() <= northwest.getLat()
            && end.getLat() <= southeast.getLat()
            && end.getLng() >= northwest.getLng()
            && end.getLng() >= southeast.getLng()) {
      delegate.endTrip(customer, end);
    }
  }

  /**
   * Get the ride history for the given customer.
   *
   * @param customer the customer
   * @return list of trips taken by the customer
   */
  @Override
  public List<Trip> getTrips(String customer) {
    return delegate.getTrips(customer);
  }

  /**
   * Get a log of all trips for this fleet.
   *
   * @return the log
   */
  @Override
  public String getTripLog() {
    return delegate.getTripLog();
  }
}
