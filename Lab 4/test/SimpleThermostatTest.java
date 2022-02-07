import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleThermostatTest {
  double DELTA = Integer.MIN_VALUE;
  Thermostat thermostat1 = new SimpleThermostat("1", 24.0);
  Thermostat thermostat2 = new SimpleThermostat("1", 24.005);
  Thermostat thermostat3 = thermostat2;

  Thermostat thermostat4 = new SimpleThermostat("1", 25.371);
  Thermostat thermostat5 = new SimpleThermostat("1", 25.374);
  Thermostat thermostat6 = thermostat4;


  @Test
  public void getID() {
    assertEquals(thermostat1.getID(), "1");
  }

  @Test
  public void getSetTemperature() {
    assertEquals(thermostat1.getSetTemperature(), 24.0 + 273.15, DELTA);
  }

  @Test
  public void increaseSetTemperature() {
    thermostat1.increaseSetTemperature();
    assertEquals(thermostat1.getSetTemperature(), 297.25, DELTA);
  }

  @Test
  public void decreaseSetTemperature() {
    thermostat2.decreaseSetTemperature();
    assertEquals(thermostat2.getSetTemperature(), 23.905 + 273.15, DELTA);
  }

  @Test
  public void testEquals() {
    assertTrue(thermostat4.equals(thermostat5));
  }

  @Test
  public void testHashCode() {
    assertTrue(thermostat3.hashCode() == thermostat2.hashCode());
    assertTrue(thermostat4.hashCode() != thermostat5.hashCode());
    assertTrue(thermostat4.hashCode() == thermostat6.hashCode());
  }
}