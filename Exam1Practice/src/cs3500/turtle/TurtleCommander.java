package cs3500.turtle;

import java.util.List;

/**represents a turtle that tkaes text commands and executes them.
 *
 */
public interface TurtleCommander {
  void execute(String cmd);

  List<String> getSupportedCommand();

}
