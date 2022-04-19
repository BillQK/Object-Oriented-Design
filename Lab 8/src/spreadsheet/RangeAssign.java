package spreadsheet;


/**
 * A clsas for RangeAssign.
 */
public class RangeAssign extends SparseSpreadSheet implements ISpreadSheetWithMacros {
  private int col2;
  private int value;
  private double startValue;
  private int row;
  private int col;
  private int row2;

  /**
   * A constructor for RangeAssign.
   * @param row int
   * @param col int
   * @param row2 int
   * @param col2 int
   * @param startValue int
   * @param value int
   */
  public RangeAssign(int row, int col, int row2, int col2, double startValue, int value) {
    if (row < 0 || col < 0 || row2 < 0 || col2 < 0) {
      throw new IllegalArgumentException("Cannot be less than 0");
    }
    this.row = row;
    this.col = col;
    this.row2 = row2;
    this.col2 = col2;
    this.value = value;
    this.startValue = startValue;
  }

  @Override
  public void apply(SpreadSheet s) {
    int increment = 0;
    for (int i = row; i < row2; i++) {
      for (int j = col; j < col2; j++) {
        s.set(i, j, startValue + increment);
        increment += value;
      }
    }
  }
}
