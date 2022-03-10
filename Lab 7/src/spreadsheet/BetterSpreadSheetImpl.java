package spreadsheet;

/**
 * A representation of Better Spread Sheet.
 */
public class BetterSpreadSheetImpl extends SparseSpreadSheet implements BetterSpreadSheet {
  /**
   * method that takes a rectangular region in the spreadsheet (e.g. from (0,0) to (1,3)) and a
   * value, and sets all cells in that region to the specified value.
   *
   * @param value   Double
   * @param row1    int
   * @param column1 int
   * @param row2    int
   * @param column2 int
   * @throws IllegalArgumentException if the cell position is negative.
   */
  @Override
  public void bulkAssign(Double value, int row1, int column1, int row2, int column2) {
    if (row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0) {
      throw new IllegalArgumentException("Invalid number");
    }
    for (int i = row1; i < row2; i++) {
      for (int j = column1; j < column2; j++) {
        super.set(row1, column1, value);
      }
    }
  }
}
