package spreadsheet;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * A test class for better controller.
 */
public class BetterControllerTest {
  BetterController bulkAM;
  SpreadSheet s;

  @Test
  public void testBulkCommand() {
    s = new SparseSpreadSheet();
    Readable r = new StringReader("bulk-assign-value 10 a 3 c 5 ");
    Appendable ap = new StringBuilder();
    bulkAM = new BetterController(s, r, ap);
    try {
      bulkAM.control();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "");
    }

  }

}