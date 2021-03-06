package spreadsheet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A test class Bulk Assign Macro.
 */
public class BulkAssignMacroTest {
  ISpreadSheetWithMacros macro;
  SpreadSheet s;

  @Test
  public void testApply() {
    s = new SparseSpreadSheet();
    macro = new BulkAssignMacro(10.0, 1, 3, 4, 10);
    macro.apply(s);

    for (int row = 1; row < 3; row++) {
      for (int column = 4; column < 10; column++) {
        assertEquals(s.get(row, column), 10.0, 0.01);
      }
    }

  }
}