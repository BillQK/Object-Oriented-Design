import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A test class for immutable list.
 */
public class ImmutableListADTImplTest {

  CommonListADT<Integer> immutableListADT = new ImmutableListADTImpl.ImmutableListBuilder<Integer>()
          .add(2).add(34).add(43).add(23).build();


  @Test
  public void testGet() {
    assertEquals(immutableListADT.getSize(), 4);
    assertEquals(immutableListADT.get(0), 2, 0);
    assertEquals(immutableListADT.get(1), 34, 0);
    assertEquals(immutableListADT.get(2), 43, 0);
    assertEquals(immutableListADT.get(3), 23, 0);
  }

  @Test
  public void testMap() {
    CommonListADT<Integer> s = immutableListADT.map(o -> o + 1);
    assertEquals(s.get(0), 3, 0);
    assertEquals(s.get(1), 35, 0);
    assertEquals(s.get(2), 44, 0);
    assertEquals(s.get(3), 24, 0);
  }
}
