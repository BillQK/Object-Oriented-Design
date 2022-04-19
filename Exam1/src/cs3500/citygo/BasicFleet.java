package cs3500.citygo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Represents a fleet of rentable electric scooters in an urban area. Scooters and customer trips
 * are managed through a single instance for all customers using the service in this area.
 */
public class BasicFleet implements Fleet {
  private final Map<String, Scooter> scooters;
  private final List<Trip> trips;
  private final StringBuilder log;

  public BasicFleet() {
    scooters = new HashMap<>();
    trips = new ArrayList<>();
    log = new StringBuilder();
  }

  @Override
  public void addScooter(Scooter... scoots) {
    if (scoots == null || scoots.length == 0 || Arrays.stream(scoots).anyMatch(Objects::isNull)) {
      throw new IllegalArgumentException("Scooter should not be empty or null");
    }
    for (Scooter s : scoots) {
      scooters.put(s.getId(), s);
    }
  }

  @Override
  public List<Scooter> getNearbyScooters(Coord pos, double distance) {
    List<Scooter> scootersList = new ArrayList<>();
    if (pos == null || distance < 0) {
      throw new IllegalArgumentException("need valid position and distance");
    }
    for (Map.Entry<String, Scooter> s : scooters.entrySet()) {
      Scooter scooter = s.getValue();
      if (scooter.getLocation().distance(pos) <= distance) {
        scootersList.add(scooter);
      }
    }

   // scootersList.sort((o1 , o2) -> Double.compare(o1.getLocation().compareTo(pos), o2.getLocation().compareTo(pos)));
    scootersList.sort((o1, o2) -> o1.getLocation().compareTo(o2.getLocation(), pos));
    return scootersList;
  }

  @Override
  public void startTrip(Scooter s, String customer) {
    if (s == null || customer == null) {
      throw new IllegalArgumentException("Please supply valid scooter and customer");
    }
    if (!scooters.containsKey(s.getId())) {
      throw new IllegalArgumentException("Requested scooter is not in this fleet.");
    }
    if (s.getStatus() != Scooter.Status.AVAILABLE) {
      throw new IllegalArgumentException("Scooter is not available");
    }
    for (Trip t : trips) {
      if (t.getCustomer().equals(customer) && t.isActive()) {
        throw new IllegalArgumentException("Customer is already on an active trip");
      }
    }
    trips.add(new Trip(s, customer));
    log.append("Trip started for customer " + customer + " on scooter " + s.getId() + "\n");
  }

  @Override
  public void endTrip(String customer, Coord end) {
    if (end == null) {
      throw new IllegalArgumentException("Cannot end trip at a null location");
    }
    if (customer == null) {
      throw new IllegalArgumentException("Please specify a valid customer");
    }
    boolean foundTrip = false;
    for (Trip t : trips) {
      if (t.getCustomer().equals(customer) && t.isActive()) {
        t.endTrip(end);
        log.append("Trip ended for customer " + customer + ", distance " + t.getDistance() + "\n");
        foundTrip = true;
      }
    }
    if (!foundTrip) {
      throw new IllegalStateException("No active trip found for given customer");
    }
  }

  @Override
  public List<Trip> getTrips(String customer) {
    List<Trip> s;
    s = trips.stream().filter(t -> t.getCustomer().equals(customer))
            .collect(Collectors.toList());

    List<Trip> a = new ArrayList<>();

    for (Trip t : s) {
      a.add(t);
    }
    return a;

  }

  @Override
  public String getTripLog() {
    return log.toString();
  }
}
