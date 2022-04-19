import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.turtle.Position2D;
import cs3500.turtle.TurtleManager;
import cs3500.turtle.TurtleOperations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class TurtleManagerTest {

  @Test
  public void testOne() {
    TurtleOperations t = new TurtleManager();

    t.turn(60);
    t.trace(19);
    t.turn(-120);
    t.trace(19);
    t.turn(-120);
    t.trace(19);
    List<Position2D> tlines = t.getLines();

    TurtleOperations t2 = new TurtleManager();

    t2.trace(19);
    t2.turn(120);
    t2.trace(19);
    t2.turn(120);
    t2.trace(19);

    List<Position2D> t2lines = t2.getLines();

    assertEquals(tlines.size(), t2lines.size());

    // this test is testing for after a sequence of mutation, do we have the correct state.
    // account for the mutation that result the same correct state.
    // find the line in tline1 that are in tline2
    for (int i = 0; i < tlines.size(); i += 2) {
      int j = 0;
      // find the line breaks
      while (j < t2lines.size()) {
        if (tlines.get(i).equals(t2lines.get(j))
                && tlines.get(i + 1).equals(t2lines.get(j + 1))) {
          break;
        } else if (tlines.get(i).equals(t2lines.get(j + 1))
                && tlines.get(i + 1).equals(t2lines.get(j))) {
          break;
        } else {
          j += 2;
        }

      }
      // true if the lines are the same
      assertTrue(j < t2lines.size());
    }
  }

  // Q.2 : write one test and explain different case to applies using that test

  @Test
  public void testDrawSomething() {
    TurtleOperations t = new TurtleManager();

    Position2D p1 = t.getPosition();
    t.save();
    t.turn(45);
    t.trace(10);
    t.retrieve();

    t.save();
    t.turn(135);
    t.trace(10);
    t.retrieve();

    t.save();
    t.turn(-90);
    t.trace(10);
    t.retrieve();

    List<Position2D> actualLines = t.getLines();
    List<Position2D> expectedLines = new ArrayList<Position2D>();

    expectedLines.add(new Position2D(0, 0));
    expectedLines.add(new Position2D(10.0 * Math.cos(Math.toRadians(45.0)),
            10.0 * Math.sin(Math.toRadians(45.0)))
    );

    expectedLines.add(new Position2D(0, 0));
    expectedLines.add(new Position2D(-10.0 * Math.cos(Math.toRadians(135.0)),
            10.0 * Math.sin(Math.toRadians(135.0)))
    );

    expectedLines.add(new Position2D(0, 0));
    expectedLines.add(new Position2D(10.0 * Math.cos(Math.toRadians(-90)),
            10.0 * Math.sin(Math.toRadians(-90)))
    );

    assertEquals(expectedLines.size(), actualLines.size());

    for (int i = 0; i < expectedLines.size(); i++) {
      assertEquals(expectedLines.get(i), actualLines.get(i));
    }
  }

  @Test
  public void testThree() {
    TurtleOperations t = new TurtleManager();

    t.move(-10);
    t.trace(-10);

    TurtleOperations t2 = new TurtleManager();

    t2.move(10);
    t2.trace(10);

    assertEquals(t.getPosition(), new Position2D(-20.0 * Math.cos(Math.toRadians(0)),
            -20.0 * Math.sin(Math.toRadians(0))));
    assertEquals(t2.getPosition(), new Position2D(20.0 * Math.cos(Math.toRadians(0)),
            20.0 * Math.sin(Math.toRadians(0))));

    assertEquals(t.getLines().size(), 2);
    assertEquals(t2.getLines().size(), 2);
  }


}
