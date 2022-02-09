import org.junit.Test;

import static org.junit.Assert.*;

public class NaiveTemperatureMonitorTest {
  TemperatureMonitor tm = new NaiveTemperatureMonitor();

  Thermostat t1 = new SimpleThermostat("1", 13);
  Thermostat t2 = new SimpleThermostat("2", 26);
  Thermostat t3 = new SimpleThermostat("3", 14);
  Thermostat t4 = new SimpleThermostat("4", 25);
  Thermostat t5 = new SimpleThermostat("5", 32);
  Thermostat t6 = new SimpleThermostat("5", 20);
  Thermostat t7 = new SimpleThermostat("5", 12);




  @Test
  public void add() {
    tm.add(t1);
    tm.add(t2);
    tm.add(t3);
    tm.add(t4);
    tm.add(t5);
    tm.add(t6);
    tm.add(t7);
    assertEquals();
  }

  @Test
  public void remove() {
  }

  @Test
  public void getNumberOfThermostats() {
  }

  @Test
  public void tooMuchHeating() {
  }
}