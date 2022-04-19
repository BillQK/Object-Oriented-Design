package spreadsheet;

import java.util.Scanner;

/**
 * A class for better controller.
 */
public class BetterController extends SpreadSheetController {

  /**
   * Create a controller to work with the specified sheet (model),
   * readable (to take inputs) and appendable (to transmit output).
   *
   * @param sheet      the sheet to work with (the model)
   * @param readable   the Readable object for inputs
   * @param appendable the Appendable objects to transmit any output
   */
  public BetterController(SpreadSheet sheet, Readable readable, Appendable appendable) {
    super(sheet, readable, appendable);
  }

  @Override
  protected void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator());
    writeMessage("bulk-assign-value value row-num1 col-num1 row-num2 column2");
    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }

  @Override
  protected void processCommand(String userInstruction, Scanner sc, SpreadSheet sheet) {
    int row;
    int col;
    double value;

    switch (userInstruction) {
      case "assign-value": //assign a value to a cell
        try {
          row = getRowNum(sc.next()); //get in the row string
          col = sc.nextInt(); //get in the column number, starting with 1
          value = sc.nextDouble();
          System.out.println("Setting cell (" + row + "," + (col - 1));
          sheet.set(row, col - 1, value); //use the spreadsheet
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      case "print-value": //print a value from the cell
        try {
          row = getRowNum(sc.next()); //get the row string
          col = sc.nextInt(); //get the column number, starting with 1
          writeMessage("Value: " + sheet.get(row, col - 1) + System.lineSeparator());
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      case "bulk-assign-value": // assign a value of multiple cell
        try {
          value = sc.nextDouble();
          row = getRowNum(sc.next()); // get in the row String
          col = sc.nextInt();
          int row2 = getRowNum(sc.next());
          int col2 = sc.nextInt();
          BulkAssignMacro s = new BulkAssignMacro(value, row, col, row2, col2);
          s.apply(sheet);
          System.out.println("Setting cells (" + row + ", " + (col - 1) + ") to " +
                  "(" + row2 + ", " + (col2 - 1) + ") ");
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      case "average":
        try {
          row = getRowNum(sc.next());
          col = sc.nextInt();
          int row2 = getRowNum(sc.next());
          int col2 = sc.nextInt();
          int row3 = getRowNum(sc.next());
          int col3 = sc.nextInt();
          Average a = new Average(row, col, row2, col2, row3, col3);
          a.apply(sheet);
          System.out.println("Value: " + sheet.get(row3, col3));
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      case "range-assign-value":
        try {
          row = getRowNum(sc.next());
          col = sc.nextInt();
          int row2 = getRowNum(sc.next());
          int col2 = sc.nextInt();
          int incrementValue = sc.nextInt();
          value = sc.nextInt();
          RangeAssign r = new RangeAssign(row, col, row2, col2, value, incrementValue);
          r.apply(sheet);
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      case "menu": //print the menu of supported instructions
        welcomeMessage();
        break;
      default: //error due to unrecognized instruction
        writeMessage("Undefined instruction: " + userInstruction + System.lineSeparator());
    }
  }
}
