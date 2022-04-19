package spreadsheet;

/**
 * A class for Average.
 */
public class Average extends SparseSpreadSheet implements ISpreadSheetWithMacros {
  private int row;
  private int col;
  private int row2;
  private int col2;
  private int row3;
  private int col3;

  /**
   * A constructor for Average.
   *
   * @param row  int
   * @param col  int
   * @param row2 int
   * @param col2 int
   * @param row3 int
   * @param col3 int
   */
  public Average(int row, int col, int row2, int col2, int row3, int col3) {
    if (row < 0 || col < 0 || row2 < 0 || col2 < 0 || row3 < 0 || col3 < 0) {
      throw new IllegalArgumentException("Cannot be less than zero");
    }
    this.row = row;
    this.col = col;
    this.row2 = row2;
    this.col2 = col2;
    this.row3 = row3;
    this.col3 = col3;
  }

  @Override
  public void apply(SpreadSheet s) {
    double value = 0;
    for (int i = row; i < row2; i++) {
      for (int j = col; j < col2; j++) {
        value += s.get(i, j);
      }
    }
    value /= ((row2 - row) * (col2 - col));
    s.set(row3, col3, value);
  }
}
