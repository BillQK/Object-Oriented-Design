package spreadsheet;

/**
 * A interface for Spread sheet with macros.
 */
public interface ISpreadSheetWithMacros extends SpreadSheet {
  void apply(SpreadSheet s);
}
