package spreadsheet;

/**
 * A interface of better spread sheet.
 */
public interface BetterSpreadSheet extends SpreadSheet {
  /**
   * method that takes a rectangular region in the spreadsheet (e.g. from (0,0) to (1,3)) and a
   * value, and sets all cells in that region to the specified value.
   *
   * @throws IllegalArgumentException if the cell position is negative.
   */
  void bulkAssign(Double value, int row1, int column1, int row2, int column2);

}
