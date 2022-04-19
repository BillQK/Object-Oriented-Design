package cs3500.citygo;

import java.util.List;

/**
 * A new feature of the box bound fleet.
 */
public interface BoundBoxFleet extends Fleet{
  /**
   * Allow the user of a Fleet to set the northwest corner and the southeast corner of a geographical
   * rectangle, outside of which no scooter can be added, and no trip can be ended.
   * @throw
   */
  void setBoundingBox(Coord latitude, Coord longtitude);

  List<Coord> getBounds();

  boolean checkInBounds(Coord p);
}
