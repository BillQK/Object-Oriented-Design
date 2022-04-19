package cs3500.tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A mouse class for Mouse Listener.
 */
public class Mouse extends MouseAdapter {
  private final TicTacToeController controller;

  /**
   * A constructor for Mouse.
   *
   * @param controller a TicTacToeController.
   */
  public Mouse(TicTacToeController controller) {
    this.controller = controller;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    int row = Math.round((x - 130) / 100);
    int col = Math.round((y - 130) / 100);
    controller.handleMove(row, col);
  }
}
