import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * This is a test class for naive temperature monitor class.
 */
public class NaiveTemperatureMonitorTest {
  TemperatureMonitor tm = new NaiveTemperatureMonitor();

  Thermostat t1 = new SimpleThermostat("1", 13);
  Thermostat t2 = new SimpleThermostat("2", 26);
  Thermostat t3 = new SimpleThermostat("3", 14);
  Thermostat t4 = new SimpleThermostat("4", 25);
  Thermostat t5 = new SimpleThermostat("5", 32);
  Thermostat t6 = new SimpleThermostat("5", 20);
  Thermostat t7 = new SimpleThermostat("5", 30);

  TemperatureMonitor tm2 = new NaiveTemperatureMonitor();

  @Before
  public void setUp() {
    tm2.add(t1);
    tm2.add(t2);
    tm2.add(t3);
    tm2.add(t4);
    tm2.add(t5);
    tm2.add(t6);
    tm2.add(t7);
  }

  @Test
  public void add() {
    tm.add(t1);
    assertEquals(tm.getNumberOfThermostats(), 1);
    tm.add(t2);
    assertEquals(tm.getNumberOfThermostats(), 2);
    tm.add(t3);
    assertEquals(tm.getNumberOfThermostats(), 3);
    tm.add(t4);
    assertEquals(tm.getNumberOfThermostats(),4);
    tm.add(t5);
    assertEquals(tm.getNumberOfThermostats(), 5);
    tm.add(t6);
    assertEquals(tm.getNumberOfThermostats(), 6);
    tm.add(t7);
    assertEquals(tm.getNumberOfThermostats(), 7);
  }

  @Test
  public void remove() {
    tm.add(t1);
    tm.add(t2);
    tm.add(t3);
    tm.add(t4);
    tm.add(t5);

    tm.remove(t5);
    assertEquals(tm.getNumberOfThermostats(),4);
    tm.remove(t4);
    assertEquals(tm.getNumberOfThermostats(), 3);
    tm.remove(t3);
    assertEquals(tm.getNumberOfThermostats(), 2);
  }

  @Test
  public void getNumberOfThermostats() {
    tm.add(t1);
    assertEquals(tm.getNumberOfThermostats(), 1);
    tm.add(t2);
    assertEquals(tm.getNumberOfThermostats(), 2);
    tm.add(t3);
    assertEquals(tm.getNumberOfThermostats(), 3);
    assertEquals(tm2.getNumberOfThermostats(), 7);
  }

  @Test
  public void tooMuchHeating() {
    assertTrue(tm2.tooMuchHeating());
    tm2.remove(t7);
    assertFalse(tm.tooMuchHeating());
  }
}