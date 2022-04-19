package cs3500.turtle;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MoveableTurtleCommander extends TurtleManagerCommander {

  @Override
  public void execute(String cmd) {
    // check for moveto, execute it using super
    if (cmd.startsWith("moveto")) {
      try {
        Scanner scan = new Scanner(cmd);
        scan.next();
        double destX  = scan.nextDouble();
        double destY = scan.nextDouble();
        // trignomertry / arithmetic
        super.execute("turn Z");
        super.execute("move X");
        // ,,,
      } catch (NoSuchElementException e) {
        throw new IllegalArgumentException("Invalid moveto: " + cmd);
      }

    } else {
      super.execute(cmd);
    }
  }

  @Override
  public List<String> getSupportedCommand() {
    List<String> cmds = super.getSupportedCommand();
    cmds.add("moveto");
    return cmds;
  }

}
