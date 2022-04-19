import org.junit.Test;

import java.util.List;

import cs3500.citygo.BasicFleet;
import cs3500.citygo.BoundBoxFleet;
import cs3500.citygo.BoundBoxFleetImpl;
import cs3500.citygo.Coord;
import cs3500.citygo.Fleet;
import cs3500.citygo.Scooter;
import cs3500.citygo.Trip;

import static org.junit.Assert.assertEquals;

public class FleetTest {
  @Test
  public void testSomething() {
    Coord hurtig = new Coord(42.339661, -71.086463);
    Coord wva = new Coord(42.337108, -71.093278);
    Scooter s1 = new Scooter("1", hurtig);
    Scooter s2 = new Scooter("2", wva);
    Fleet f = new BasicFleet();
    f.addScooter(s1, s2);

    String c = "Clark";
    f.startTrip(s1, c);
    Coord fenway = new Coord(42.346550, -71.097114);
    f.endTrip(c, fenway);
    assertEquals(0, s1.getLocation().distance(new Coord(42.346550, -71.097114)), 0.05);



    f.startTrip(s1, c);
    f.getTrips(c);
    f.endTrip(c, wva);
    assertEquals(f.getTripLog(), "Trip started for customer Clark on scooter 1\n" +
            "Trip ended for customer Clark, distance 0.7231974002501367\n" +
            "Trip started for customer Clark on scooter 1\n" +
            "Trip ended for customer Clark, distance 0.3904262396845401\n");

  }

  @Test
  public void testNearbyScooter() {
    Coord hurtig = new Coord(42.339661, -71.086463);
    Coord wva = new Coord(42.337108, -71.093278);
    Scooter s1 = new Scooter("1", hurtig);
    Scooter s2 = new Scooter("2", wva);
    Fleet f = new BasicFleet();
    f.addScooter(s1, s2);

    List<Scooter> s = f.getNearbyScooters(wva, 275.6);
    assertEquals(s.get(0), s2);
    assertEquals(s.get(1), s1);
  }

  @Test
  public void testBoundBox() {
    Fleet f = new BasicFleet();
    BoundBoxFleet boundBoxFleet = new BoundBoxFleetImpl(f);

    Coord hurtig = new Coord(42.339661, -71.086463);
    Coord wva = new Coord(42.337108, -71.093278);
    Coord pos = new Coord(0, 0);
    boundBoxFleet.boundingBox(hurtig, wva);
    Scooter s1 = new Scooter("1", hurtig);
    Scooter s2 = new Scooter("2", wva);
    Scooter s3 = new Scooter("3", pos);
    boundBoxFleet.addScooter(s1, s2, s3);

    List<Scooter> s = boundBoxFleet.getNearbyScooters(pos, 1000);
    assertEquals(s.size(), 1);

  }
}
