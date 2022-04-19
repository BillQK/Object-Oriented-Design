package cs3500.citygo;

import java.util.List;

/**
 * Represents a fleet of scooters for rent in a particular urban area. Rental rules, pricing, etc
 * may vary by geographic area; they will be consistent for a single instance of a fleet.
 */
public interface Fleet {
  /**
   * Add one or more {@link Scooter} instances to the fleet
   * @param s one or more scooters to be added
   */
  void addScooter(Scooter... s);

  /**
   * Produce a list of scooters within a given radius, for example for an app to easily display
   * scooters near a user's location.
   * @param pos the center point location
   * @param distance the radius around the point within which to include scooters
   * @return list of scooters within the radius, in sorted order by distance, least to greatest
   */
  List<Scooter> getNearbyScooters(Coord pos, double distance);

  /**
   * Start a trip on a given scooter, for a given customer. Note that the scooter must be available,
   * and the customer is assumed to be unique, and cannot already be on an active trip.
   * @param s the scooter to be used on the trip
   * @param customer the customer taking the trip
   * @throws IllegalArgumentException if the scooter is not available, if the customer is already
   * on a trip, or either argument is null.
   */
  void startTrip(Scooter s, String customer);

  /**
   * End a trip for a given customer, at the given end point.
   * @param customer customer taking the trip
   * @param end location where the trip ends
   * @throws IllegalStateException if the customer is not on any active trip
   */
  void endTrip(String customer, Coord end);

  /**
   * Get the ride history for the given customer.
   * @param customer the customer
   * @return list of trips taken by the customer
   */
  List<Trip> getTrips(String customer);

  /**
   * Get a log of all trips for this fleet.
   * @return the log
   */
  String getTripLog();
}
