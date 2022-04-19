package cs3500.tictactoe;


/**
 * Run a TicTacToe game interactively on the console.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively on the console.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    // New Hotness: Graphical User Interface:
    // 1. Create an instance of the model.
    // 2. Create an instance of the view.
    // 3. Create an instance of the controller, passing the view to its constructor.
    // 4. Call playGame() on the controller.

    TicTacToeModel model = new TicTacToeModel();
    TicTacToeView view = new SwingTicTacToeView("Tic Tac Toe", model);
    TicTacToeController control = new Controller(model, view);
    control.playGame();
  }
}
