package spreadsheet;

import org.junit.Test;

import java.io.StringReader;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A test class for spreadsheet controller.
 */
public class SpreadSheetControllerTest {

  @Test
  public void testGo() {
    SparseSpreadSheet s = new SparseSpreadSheet();
    Readable r = new StringReader("");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Welcome to the spreadsheet program!\n" +
              "Supported user instructions are: \n" +
              "assign-value row-num col-num value (set a cell to a value)\n" +
              "print-value row-num col-num (print the value at a given cell)\n" +
              "menu (Print supported instruction list)\n" +
              "q or quit (quit the program)"));
    }
  }

  @Test
  public void testGoQuit() {
    SpreadSheet s = new BetterSpreadSheetImpl();
    Readable r = new StringReader("q");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Thank you for using this program! "));
    }
  }

  @Test
  public void testGoMenu() {
    SparseSpreadSheet s = new SparseSpreadSheet();
    Readable r = new StringReader("menu");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Supported user instructions are: \n" +
              "assign-value row-num col-num value (set a cell to a value)\n" +
              "print-value row-num col-num (print the value at a given cell)\n" +
              "menu (Print supported instruction list)\n" +
              "q or quit (quit the program) "));
    }
  }

  @Test
  public void testGoAssignValue() {
    SparseSpreadSheet s = new SparseSpreadSheet();
    Readable r = new StringReader("assign-value A 10 100");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Setting cell (0,9) "));
    }
  }

  @Test
  public void testGoGetValue() {
    SparseSpreadSheet s = new SparseSpreadSheet();
    Readable r = new StringReader("assign-value A 10 100 print-value A 10");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Value: 100.0"));
    }
  }

  @Test
  public void testBulkAssign() {
    SpreadSheet s = new BetterSpreadSheetImpl();
    Readable r = new StringReader("bulk-assign A 10 B 20 100");
    Appendable ap = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(s, r, ap);
    try {
      controller.execute();
    } catch (NoSuchElementException e) {
      assertTrue(ap.toString().contains("Assign Value: 100.0 from Cell (0,9) to(1,19) "));
      assertEquals(s.getHeight(), 1);
      assertEquals(s.getWidth(), 11);
    }
  }


}