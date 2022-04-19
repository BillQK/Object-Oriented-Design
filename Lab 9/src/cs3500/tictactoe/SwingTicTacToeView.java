package cs3500.tictactoe;

import javax.swing.JFrame;

/**
 * Visual view for TicTacToe using Java Swing.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView {

  /**
   * Construct the view, giving it a readonly model so it can access the latest game state.
   *
   * @param windowTitle the title of the main window
   * @param m           the game model
   */
  public SwingTicTacToeView(String windowTitle, ReadonlyTicTacToeModel m) {
    super(windowTitle);

    setSize(500, 400);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    TicTacToePanel panel = new TicTacToePanel(m);
    this.add(panel);
  }

  @Override
  public void addListener(TicTacToeController l) {
    this.addMouseListener(new Mouse(l));
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
