package cs3500.citygo;

import java.util.Objects;

/**
 * Represents a single geographical point on the earth's surface, having a latitude and longitude.
 * Positive latitude is north of the equator; negative latitude is south of the equator.
 * Positive longitude is east of the prime meridian; negative longitude is west of the prime
 * meridian (a north-south line that runs through a point in England).
 */
public class Coord {
  private static final double EARTH_RADIUS = 3961; // radius of the earth in miles
  private final double lat, lng;  // latitude, longitude in degrees

  /**
   * Initialize a geographical point with valid latitude and longitude in degrees.
   *
   * @param lat latitude, between -90 and 90 degrees
   * @param lng longitude, between -180 and 180 degrees
   */
  public Coord(double lat, double lng) {
    if (lat > 90 || lat < -90 || lng > 180 || lng < -180) {
      throw new IllegalArgumentException("Invalid coordinates");
    }
    this.lat = lat;
    this.lng = lng;
  }

  public double getLat() {
    return lat;
  }

  public double getLng() {
    return lng;
  }

  /**
   * Compute distance in miles from this point to the given point, using the
   *
   * @param other the other point
   * @return the distance in miles
   * @see <a href="http://www.movable-type.co.uk/scripts/latlong.html">haversine formula</a>.
   */
  public double distance(Coord other) {
    double thisLatR = Math.toRadians(this.lat);
    double otherLatR = Math.toRadians(other.lat);
    double dLng = Math.toRadians(other.lng - this.lng);
    double dLat = Math.toRadians(other.lat - this.lat);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(thisLatR) * Math.cos(otherLatR) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
    return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)) * EARTH_RADIUS;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Coord && ((Coord) o).distance(this) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Math.round(lat * 100) / 100, Math.round(lng * 100 / 100));
  }

  public int compareTo(Coord location, Coord point) {
    return Double.compare(this.distance(point), location.distance(point));
  }
}
