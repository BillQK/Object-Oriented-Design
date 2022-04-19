package cs3500.tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * A panel that can hold the actual TicTacToe game visualization.
 * Note that this class is package-private. It's part of the View,
 * and internal to the View implementation.
 */
class TicTacToePanel extends JPanel {

  private final ReadonlyTicTacToeModel model;

  /**
   * Constructor for TicTacToe panel.
   *
   * @param m the model
   */
  TicTacToePanel(ReadonlyTicTacToeModel m) {
    model = m;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    // setSize(500, 400);
    // draw grid lines (2 vertical, 2 horizontal)
    // vertical lines
    g2.drawLine(150, 100, 150, 350);
    g2.drawLine(300, 100, 300, 350);

    // horizontal
    g2.drawLine(50, 150, 400, 150);
    g2.drawLine(50, 250, 400, 250);

    // iterate over board, draw X/O in appropriate cell
    int ypos;
    int xpos;
    for (int i = 0; i < model.getBoard().length; i++) {
      for (int j = 0; j < model.getBoard().length; j++) {
        xpos = 130 + 100 * i;
        ypos = 130 + 100 * j;
        if (model.getMarkAt(i, j) == Player.O) {
          g2.drawString("O", xpos, ypos);
        } else if (model.getMarkAt(i, j) == Player.X) {
          g2.drawString("X", xpos, ypos);
        } else {
          g2.drawString("", xpos, ypos);
        }
      }
    }
    // if game is over, draw game-over message
    // else draw whose turn it is
    if (model.isGameOver()) {
      g2.drawString(model.getWinner().toString(), 100, 100);
    } else {
      g2.drawString(model.getTurn().toString(), 50, 100);
    }

  }
}
