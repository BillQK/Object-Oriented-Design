import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A test class for mutable class.
 */
public class MutableListADTImplTest {
  MutableListADTImpl<String> stringMutableListADT = new MutableListADTImpl<>();

  @Test
  public void test() {
    stringMutableListADT.add(0, "hello");
    stringMutableListADT.add(1, "world");
    stringMutableListADT.add(2, "my");
    stringMutableListADT.add(3, "name");
    stringMutableListADT.addBack("Bill");

    assertEquals(stringMutableListADT.getSize(), 5);

    ImmutableListADT<String> s = stringMutableListADT.getImmutableList();

    MutableListADT<String> mutableListADT = s.getMutableList();

    mutableListADT.addBack("Loz");

    assertEquals(s.getSize(), 5);
    assertEquals(stringMutableListADT.getSize(), 5);
    assertEquals(mutableListADT.getSize(), 6);
  }

}