import org.junit.Test;

import cs3500.freecell.model.multimove.MultiMoveFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;

public class MultiMoveFreecellModelTest {
  MultiMoveFreecellModel model;
  FreecellView view;

  @Test
  public void move() {
    model = new MultiMoveFreecellModel();
    model.startGame(model.getDeck(), 52, 4, false);
    view = new FreecellTextView(model, System.out);
  }
}