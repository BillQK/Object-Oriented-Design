import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.SimpleFreecellModel;

public class Main {
  public static void main(String[] args) throws IOException {
    FreecellModel<Card> model = new SimpleFreecellModel();
    FreecellController<Card> controller = new SimpleFreecellController<Card>(model, new InputStreamReader(System.in), System.out);
    try {
      controller.playGame(model.getDeck(), 52, 3, false);
    } catch (IOException ioException) {
      System.out.println("Something went wrong");
    }

  }
}
