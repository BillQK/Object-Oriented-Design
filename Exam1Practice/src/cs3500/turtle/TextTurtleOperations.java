package cs3500.turtle;

/**
 * Amit wants to add a feature that allows turtle commands to be read from
 * user input or a file as text, and then executing them. The text commands would be
 * simple strings, like "move 3", "trace 5", "turn 75", "push" and "pop". However he
 * does not want to disturb the TurtleOperations interface or any of its implementations,
 * as they are already being used in his program.
 * Write a new interface that is backward compatible with TurtleOperations (i.e. its
 * implementation is guaranteed to offer all functionality of TurtleOperations) and
 */





/**
 *  adds a new method that accepts a single turtle command as a string. This method
 * supports only the above commands. Any exceptions thrown by this method, if
 * needed, should be explicitly declared.
 */
public interface TextTurtleOperations extends TurtleOperations {
  /**
   * Allows turtle commands to be read from
   * user input or a file as text, and then executing them. The text commands would be
   * simple strings, like "move 3", "trace 5", "turn 75", "push" and "pop".
   * @param cmd the commadn to execute, such as "move 10" or "turn 45"
   * @throws IllegalArgumentException if the command is not recognized
   */
  void execute(String cmd);
}
