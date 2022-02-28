package cs3500.freecell;

import java.io.InputStreamReader;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

public class Main {
  public static void main(String[] args) {
    FreecellModel<Card> model = new MultiMoveFreecellModel();
    FreecellController<Card> controller = new SimpleFreecellController<>(model, new InputStreamReader(System.in), System.out);
    controller.playGame(model.getDeck(), 25, 1, true);
  }
}
