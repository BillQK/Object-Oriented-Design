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

  @Test
  public void testRandomInput() throws IOException {
    FreecellModel<Card> model = new SimpleFreecellModel();
    // C1, 15, and O3
    Readable input = new StringReader("G431asdf jas 23 C1 fdsawe Fasdf D1 15 Or2 O3");
    Appendable outputlog = new StringBuilder();
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outputlog);
    controller.playGame(model.getDeck(), 52, 4, false);
    assertEquals(model.getOpenCardAt(2), new Card(Value.ACE, Suit.CLUB));
    assertEquals(model.getNumCardsInCascadePile(0), 0);
  }

  @Test
  public void testGameOverPlayGame() throws IOException {
    FreecellModel<Card> model = new SimpleFreecellModel();
    Readable input = new StringReader("");
    Appendable outputlog = new StringBuilder();//    Readable input = new StringReader("C-1");
    FreecellController<Card> controller = new SimpleFreecellController<>(model,input, outputlog);
    controller.playGame(model.getDeck(), 2, 4, false);
    assertEquals(outputlog, "Invalid moves");

  }

  @Test
  public void testBadInputs() throws IOException {

  }
}