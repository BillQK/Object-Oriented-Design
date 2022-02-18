import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;

import static org.junit.Assert.assertEquals;

public class SimpleFreecellControllerTest {

  @Test
  public void testPlayGame() throws IOException {
    FreecellModel<Card> model = new SimpleFreecellModel();
    Readable input = new StringReader("C1 0 O1");
    Appendable outputlog = new StringBuilder();
    FreecellController<Card> controller = new SimpleFreecellController<Card>(model, input, outputlog);
    controller.playGame(model.getDeck(), 52, 4, false);
    assertEquals(model.getNumOpenPiles(), 4);
    assertEquals(model.getOpenCardAt(0), new Card(Value.ACE, Suit.CLUB));
  }

  public void testBadInputs() throws IOException {

  }
}