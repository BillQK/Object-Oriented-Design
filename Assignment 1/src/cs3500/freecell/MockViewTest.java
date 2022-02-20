package cs3500.freecell;

import java.io.IOException;

import cs3500.freecell.view.FreecellView;

public class MockViewTest implements FreecellView {
  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    throw new IOException("Failed");
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    throw new IOException("Failed");
  }
}
