package cs3500.tictactoe;

/**
 * A single game of TicTacToe, played on a three-by-three grid with two
 * players, with the object of the game to achieve three markers in a row either
 * vertically, horizontally, or diagonally. {@link Player} X goes first.
 */
public interface TicTacToe extends ReadonlyTicTacToeModel {

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the zero-based row of the intended move; top-most row is 0
   * @param c the zero-based column of the intended move; left-most column is 0
   * @throws IllegalArgumentException if the space is occupied or the position is
   *                                  otherwise invalid
   * @throws IllegalStateException    if the game is over
   */
  void move(int r, int c);

}
