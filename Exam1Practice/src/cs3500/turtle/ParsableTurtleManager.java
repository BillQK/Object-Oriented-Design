package cs3500.turtle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParsableTurtleManager implements TextTurtleOperations {
  private final TurtleOperations delegate;

  public ParsableTurtleManager(TurtleOperations delegate) {
    this.delegate = delegate;
  }

  /**
   * Allows turtle commands to be read from
   * user input or a file as text, and then executing them. The text commands would be
   * simple strings, like "move 3", "trace 5", "turn 75", "push" and "pop".
   *
   * @param cmd the commadn to execute, such as "move 10" or "turn 45"
   * @throws IllegalArgumentException if the command is not recognized
   */
  @Override
  public void execute(String cmd) {
    Scanner scan = new Scanner(cmd);
    try {
      String action = scan.next();
      switch (action) {
        case "move":
          delegate.move(scan.nextDouble());
          break;
        case "trace":
          delegate.trace(scan.nextDouble());
          break;
        case "turn":
          delegate.turn(scan.nextDouble());
          break;
        case "push":
          delegate.save();
          break;
        case "pop":
          delegate.retrieve();
          break;
        default:
          throw new IllegalStateException("Unknown command: " + action);
      }
    } catch (NoSuchElementException err) {
      throw new IllegalStateException("Invalid command : " + cmd);
    }

  }

  /**
   * Move the turtle by the specified distance along its
   * heading. Do not change heading
   *
   * @param distance
   */
  @Override
  public void move(double distance) {
    delegate.move(distance);
  }

  /**
   * Move the turtle by the specified distance along its
   * heading. Do not change heading.
   * Draw a line from its initial position to its
   * final position.
   *
   * @param distance
   */
  @Override
  public void trace(double distance) {
    delegate.trace(distance);
  }

  /**
   * Turn the turtle's heading by the given angle.
   * A positive angle means counter-clockwise
   * turning. Do not change position
   *
   * @param angleDegrees
   */
  @Override
  public void turn(double angleDegrees) {
    delegate.turn(angleDegrees);
  }

  /**
   * Save the current turtle state (position + heading)
   */
  @Override
  public void save() {
    delegate.save();
  }

  /**
   * Retrieve and last saved turtle state (position + heading)
   */
  @Override
  public void retrieve() {
    delegate.retrieve();
  }

  /**
   * Get the current position of the turtle
   *
   * @return
   */
  @Override
  public Position2D getPosition() {
    return delegate.getPosition();
  }

  /**
   * Get the current heading of the turtle
   *
   * @return the heading in terms of an angle in degrees from +X axis
   */
  @Override
  public float getHeading() {
    return delegate.getHeading();
  }

  /**
   * Get the lines traced by this turtle, caused by the
   * trace method above.
   *
   * @return a list of Position2D objects. Every pair
   * represents a line (0,1), (2,3), ...
   */
  @Override
  public List<Position2D> getLines() {
    return delegate.getLines();
  }
}
