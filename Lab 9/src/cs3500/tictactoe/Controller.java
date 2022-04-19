package cs3500.tictactoe;

/**
 * A controller class for TicTacToe.
 */
public class Controller implements TicTacToeController {
  private final TicTacToe model;
  private final TicTacToeView view;

  /**
   * A constructor for Controller.
   *
   * @param model a TicTacToeModel.
   * @param view  a TicTacToeView.
   */
  public Controller(TicTacToe model, TicTacToeView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    this.model = model;
    this.view = view;
  }


  @Override
  public void playGame() {
    view.addListener(this);
    view.makeVisible();
  }

  @Override
  public void handleMove(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Cannot be less than 0");
    }
    try {
      model.move(row, col);
    } catch (IllegalArgumentException e) {
      // tell the view to print out the error message.
    }
    view.refresh();
  }
}
