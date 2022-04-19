import org.junit.Test;

import cs3500.tictactoe.Controller;
import cs3500.tictactoe.Player;
import cs3500.tictactoe.TicTacToeController;
import cs3500.tictactoe.TicTacToeModel;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the TicTacToe controller, using mocks.
 */
public class TicTacToeControllerTest {
  MockTicTacToeView mockTicTacToeView;
  TicTacToeController controller;
  TicTacToeModel model;

  @Test
  public void testPlayGame() {
    model = new TicTacToeModel();
    Appendable in = new StringBuilder();
    mockTicTacToeView = new MockTicTacToeView(in);
    controller = new Controller(model, mockTicTacToeView);

    controller.playGame();
    controller.handleMove(2, 2);
    assertEquals(model.getTurn(), Player.O);


  }

  @Test
  public void testHandleMove() {
    model = new TicTacToeModel();
    Appendable in = new StringBuilder();
    mockTicTacToeView = new MockTicTacToeView(in);
    controller = new Controller(model, mockTicTacToeView);

    controller.playGame();
    controller.handleMove(2, 2);
    controller.handleMove(1, 2);
    assertEquals(model.getTurn(), Player.X);

  }
}
