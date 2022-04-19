package cs3500.turtle;

import java.util.List;

/**
 * This interface specifies the operations on a 2D turtle
 * <p>
 * A 2D turtle is characterized by a position (x,y) and a
 * heading (where it is looking).
 * <p>
 * It can be asked to draw the path it has moved using one of
 * the commands below. Another command can be used to obtain
 * this traced path as a set of lines
 */
public interface TurtleOperations {
  /**
   * Move the turtle by the specified distance along its
   * heading. Do not change heading
   *
   * @param distance
   */
  void move(double distance);

  /**
   * Move the turtle by the specified distance along its
   * heading. Do not change heading.
   * Draw a line from its initial position to its
   * final position.
   *
   * @param distance
   */
  void trace(double distance);

  /**
   * Turn the turtle's heading by the given angle.
   * A positive angle means counter-clockwise
   * turning. Do not change position
   *
   * @param angleDegrees
   */
  void turn(double angleDegrees);

  /**
   * Save the current turtle state (position + heading)
   */
  void save();

  /**
   * Retrieve and last saved turtle state (position + heading)
   */
  void retrieve();

  /**
   * Get the current position of the turtle
   *
   * @return
   */
  Position2D getPosition();

  /**
   * Get the current heading of the turtle
   *
   * @return the heading in terms of an angle in degrees from +X axis
   */
  float getHeading();


  /**
   * Get the lines traced by this turtle, caused by the
   * trace method above.
   *
   * @return a list of Position2D objects. Every pair
   * represents a line (0,1), (2,3), ...
   */
  List<Position2D> getLines();
}
