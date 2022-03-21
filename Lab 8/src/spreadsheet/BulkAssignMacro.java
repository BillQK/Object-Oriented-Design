package spreadsheet;

public class BulkAssignMacro extends SparseSpreadSheet implements ISpreadSheetWithMacros {
  private final double value;
  private final int row1;
  private final int row2;
  private final int column1;
  private final int column2;

  public BulkAssignMacro(Double value, int row1, int row2, int column1, int column2) {
    if (row2 < 0 || column2 < 0 || row2 < row1 || column2 < column1) {
      throw new IllegalArgumentException("Invalid number");
    }
    this.value = value;
    this.row1 = row1;
    this.row2 = row2;
    this.column1 = column1;
    this.column2 = column2;
  }

  @Override
  public void apply(SpreadSheet s) {
    for (int i = row1; i < row2; i++) {
      for (int j = column1; j < column2; j++) {
        s.set(i, j, value);
      }
    }
  }
}
