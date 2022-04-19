import java.io.IOException;

import cs3500.tictactoe.TicTacToeController;
import cs3500.tictactoe.TicTacToeView;

/**
 * Mock for the view so that we can test that the controller does the right
 * thing.
 */
public class MockTicTacToeView implements TicTacToeView {
  private final Appendable log;

  /**
   * Constructor.
   *
   * @param log the log for testing
   */
  public MockTicTacToeView(Appendable log) {
    this.log = log;
  }

  @Override
  public void addListener(TicTacToeController listener) {
    try {
      log.append("addListener was called");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void refresh() {
    try {
      log.append("refresh was called");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void makeVisible() {
    try {
      log.append("makeVisible was called");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
