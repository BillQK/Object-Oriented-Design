import java.io.InputStreamReader;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.SimpleFreecellModel;

public class Main {
  public static void main(String[] args) {
    FreecellModel<Card> model = new SimpleFreecellModel();
    FreecellController<Card> controller = new SimpleFreecellController<>(model, new InputStreamReader(System.in), System.out);
    controller.playGame(model.getDeck(), 52, 3, false);

  }
}
