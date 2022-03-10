import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;
import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * A test class for controller.
 */
public class MultiMoveFreecellControllerTest {
  FreecellModel<Card> model = new MultiMoveFreecellModel();
  Appendable outPutLog = new StringBuilder();
  Readable input;
  FreecellController<Card> controller;

  // Card initialized
  Card aceHeart = new Card(Value.ACE, Suit.HEART);
  Card aceSpade = new Card(Value.ACE, Suit.SPADE);
  Card aceClub = new Card(Value.ACE, Suit.CLUB);
  Card aceDiamond = new Card(Value.ACE, Suit.DIAMOND);

  Card twoHeart = new Card(Value.TWO, Suit.HEART);
  Card twoSpade = new Card(Value.TWO, Suit.SPADE);
  Card twoClub = new Card(Value.TWO, Suit.CLUB);
  Card twoDiamond = new Card(Value.TWO, Suit.DIAMOND);

  Card threeHeart = new Card(Value.THREE, Suit.HEART);
  Card threeSpade = new Card(Value.THREE, Suit.SPADE);
  Card threeClub = new Card(Value.THREE, Suit.CLUB);
  Card threeDiamond = new Card(Value.THREE, Suit.DIAMOND);

  Card fourHeart = new Card(Value.FOUR, Suit.HEART);
  Card fourSpade = new Card(Value.FOUR, Suit.SPADE);
  Card fourClub = new Card(Value.FOUR, Suit.CLUB);
  Card fourDiamond = new Card(Value.FOUR, Suit.DIAMOND);

  Card fiveHeart = new Card(Value.FIVE, Suit.HEART);
  Card fiveSpade = new Card(Value.FIVE, Suit.SPADE);
  Card fiveClub = new Card(Value.FIVE, Suit.CLUB);
  Card fiveDiamond = new Card(Value.FIVE, Suit.DIAMOND);

  Card sixHeart = new Card(Value.SIX, Suit.HEART);
  Card sixSpade = new Card(Value.SIX, Suit.SPADE);
  Card sixClub = new Card(Value.SIX, Suit.CLUB);
  Card sixDiamond = new Card(Value.SIX, Suit.DIAMOND);

  Card sevenHeart = new Card(Value.SEVEN, Suit.HEART);
  Card sevenSpade = new Card(Value.SEVEN, Suit.SPADE);
  Card sevenClub = new Card(Value.SEVEN, Suit.CLUB);
  Card sevenDiamond = new Card(Value.SEVEN, Suit.DIAMOND);

  Card eightHeart = new Card(Value.EIGHT, Suit.HEART);
  Card eightSpade = new Card(Value.EIGHT, Suit.SPADE);
  Card eightClub = new Card(Value.EIGHT, Suit.CLUB);
  Card eightDiamond = new Card(Value.EIGHT, Suit.DIAMOND);

  Card nineHeart = new Card(Value.NINE, Suit.HEART);
  Card nineSpade = new Card(Value.NINE, Suit.SPADE);
  Card nineClub = new Card(Value.NINE, Suit.CLUB);
  Card nineDiamond = new Card(Value.NINE, Suit.DIAMOND);

  Card tenHeart = new Card(Value.TEN, Suit.HEART);
  Card tenSpade = new Card(Value.TEN, Suit.SPADE);
  Card tenClub = new Card(Value.TEN, Suit.CLUB);
  Card tenDiamond = new Card(Value.TEN, Suit.DIAMOND);

  Card jackHeart = new Card(Value.JACK, Suit.HEART);
  Card jackSpade = new Card(Value.JACK, Suit.SPADE);
  Card jackClub = new Card(Value.JACK, Suit.CLUB);
  Card jackDiamond = new Card(Value.JACK, Suit.DIAMOND);

  Card queenHeart = new Card(Value.QUEEN, Suit.HEART);
  Card queenSpade = new Card(Value.QUEEN, Suit.SPADE);
  Card queenClub = new Card(Value.QUEEN, Suit.CLUB);
  Card queenDiamond = new Card(Value.QUEEN, Suit.DIAMOND);

  Card kingHeart = new Card(Value.KING, Suit.HEART);
  Card kingSpade = new Card(Value.KING, Suit.SPADE);
  Card kingClub = new Card(Value.KING, Suit.CLUB);
  Card kingDiamond = new Card(Value.KING, Suit.DIAMOND);


  // deck initialize
  List<Card> loc = new ArrayList<>();
  List<Card> loc1 = new ArrayList<>();

  Card[] clubCards = new Card[]{aceClub, twoClub, threeClub, fourClub, fiveClub, sixClub, sevenClub,
                                eightClub, nineClub, tenClub, jackClub, queenClub, kingClub};
  Card[] diamondCards = new Card[]{aceDiamond, twoDiamond, threeDiamond, fourDiamond, fiveDiamond,
                                   sixDiamond, sevenDiamond, eightDiamond, nineDiamond, tenDiamond,
                                   jackDiamond, queenDiamond, kingDiamond};
  Card[] spadeCards = new Card[]{aceSpade, twoSpade, threeSpade, fourSpade, fiveSpade, sixSpade,
                                 sevenSpade, eightSpade, nineSpade, tenSpade, jackSpade, queenSpade,
                                 kingSpade};
  Card[] heartCard = new Card[]{aceHeart, twoHeart, threeHeart, fourHeart, fiveHeart, sixHeart,
                                sevenHeart, eightHeart, nineHeart, tenHeart, jackHeart, queenHeart,
                                kingHeart};
  // Invalid deck
  List<Card> duplicateDeck = new ArrayList<>();
  List<Card> nullDeck = new ArrayList<>();


  @Before
  public void setUp() {
    // Valid deck
    loc.addAll(Arrays.asList(clubCards));
    loc.addAll(Arrays.asList(diamondCards));
    loc.addAll(Arrays.asList(spadeCards));
    loc.addAll(Arrays.asList(heartCard));

    loc1.addAll(Arrays.asList(heartCard));
    loc1.addAll(Arrays.asList(diamondCards));
    loc1.addAll(Arrays.asList(spadeCards));
    loc1.addAll(Arrays.asList(clubCards));

    // duplicate but also have 52 cards
    duplicateDeck.addAll(loc);
    duplicateDeck.remove(1);
    duplicateDeck.add(kingDiamond);

    // null but also have 52 elements
    nullDeck.addAll(loc);
    nullDeck.remove(1);
    nullDeck.add(null);
  }

  // <------------------------------- Test MultiMove --------------------------------------------->

  @Test
  public void testControllerMultiMove4CardsToEmptyCascadePile() {
    input = new StringReader("C10 1 C12 C12 1 C10");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(loc1, 25, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♥, K♦, Q♣\n" +
                      "C2: 2♥, A♠, K♣\n" +
                      "C3: 3♥, 2♠\n" +
                      "C4: 4♥, 3♠\n" +
                      "C5: 5♥, 4♠\n" +
                      "C6: 6♥, 5♠\n" +
                      "C7: 7♥, 6♠\n" +
                      "C8: 8♥, 7♠\n" +
                      "C9: 9♥, 8♠\n" +
                      "C10: 10♥, 9♠\n" +
                      "C11: J♥, 10♠\n" +
                      "C12: Q♥, J♠\n" +
                      "C13: K♥, Q♠\n" +
                      "C14: A♦, K♠\n" +
                      "C15: 2♦, A♣\n" +
                      "C16: 3♦, 2♣\n" +
                      "C17: 4♦, 3♣\n" +
                      "C18: 5♦, 4♣\n" +
                      "C19: 6♦, 5♣\n" +
                      "C20: 7♦, 6♣\n" +
                      "C21: 8♦, 7♣\n" +
                      "C22: 9♦, 8♣\n" +
                      "C23: 10♦, 9♣\n" +
                      "C24: J♦, 10♣\n" +
                      "C25: Q♦, J♣\n" +
                      "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♥, K♦, Q♣\n" +
                      "C2: 2♥, A♠, K♣\n" +
                      "C3: 3♥, 2♠\n" +
                      "C4: 4♥, 3♠\n" +
                      "C5: 5♥, 4♠\n" +
                      "C6: 6♥, 5♠\n" +
                      "C7: 7♥, 6♠\n" +
                      "C8: 8♥, 7♠\n" +
                      "C9: 9♥, 8♠\n" +
                      "C10:\n" +
                      "C11: J♥, 10♠\n" +
                      "C12: Q♥, J♠, 10♥, 9♠\n" +
                      "C13: K♥, Q♠\n" +
                      "C14: A♦, K♠\n" +
                      "C15: 2♦, A♣\n" +
                      "C16: 3♦, 2♣\n" +
                      "C17: 4♦, 3♣\n" +
                      "C18: 5♦, 4♣\n" +
                      "C19: 6♦, 5♣\n" +
                      "C20: 7♦, 6♣\n" +
                      "C21: 8♦, 7♣\n" +
                      "C22: 9♦, 8♣\n" +
                      "C23: 10♦, 9♣\n" +
                      "C24: J♦, 10♣\n" +
                      "C25: Q♦, J♣\n" +
                      "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♥, K♦, Q♣\n" +
                      "C2: 2♥, A♠, K♣\n" +
                      "C3: 3♥, 2♠\n" +
                      "C4: 4♥, 3♠\n" +
                      "C5: 5♥, 4♠\n" +
                      "C6: 6♥, 5♠\n" +
                      "C7: 7♥, 6♠\n" +
                      "C8: 8♥, 7♠\n" +
                      "C9: 9♥, 8♠\n" +
                      "C10: Q♥, J♠, 10♥, 9♠\n" +
                      "C11: J♥, 10♠\n" +
                      "C12:\n" +
                      "C13: K♥, Q♠\n" +
                      "C14: A♦, K♠\n" +
                      "C15: 2♦, A♣\n" +
                      "C16: 3♦, 2♣\n" +
                      "C17: 4♦, 3♣\n" +
                      "C18: 5♦, 4♣\n" +
                      "C19: 6♦, 5♣\n" +
                      "C20: 7♦, 6♣\n" +
                      "C21: 8♦, 7♣\n" +
                      "C22: 9♦, 8♣\n" +
                      "C23: 10♦, 9♣\n" +
                      "C24: J♦, 10♣\n" +
                      "C25: Q♦, J♣\n");
    }
  }

  @Test
  public void testControllerMultiMove2CardsTo2Cards() {
    input = new StringReader("C10 1 C12");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(loc1, 25, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♥, K♦, Q♣\n" +
                      "C2: 2♥, A♠, K♣\n" +
                      "C3: 3♥, 2♠\n" +
                      "C4: 4♥, 3♠\n" +
                      "C5: 5♥, 4♠\n" +
                      "C6: 6♥, 5♠\n" +
                      "C7: 7♥, 6♠\n" +
                      "C8: 8♥, 7♠\n" +
                      "C9: 9♥, 8♠\n" +
                      "C10: 10♥, 9♠\n" +
                      "C11: J♥, 10♠\n" +
                      "C12: Q♥, J♠\n" +
                      "C13: K♥, Q♠\n" +
                      "C14: A♦, K♠\n" +
                      "C15: 2♦, A♣\n" +
                      "C16: 3♦, 2♣\n" +
                      "C17: 4♦, 3♣\n" +
                      "C18: 5♦, 4♣\n" +
                      "C19: 6♦, 5♣\n" +
                      "C20: 7♦, 6♣\n" +
                      "C21: 8♦, 7♣\n" +
                      "C22: 9♦, 8♣\n" +
                      "C23: 10♦, 9♣\n" +
                      "C24: J♦, 10♣\n" +
                      "C25: Q♦, J♣\n" +
                      "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♥, K♦, Q♣\n" +
                      "C2: 2♥, A♠, K♣\n" +
                      "C3: 3♥, 2♠\n" +
                      "C4: 4♥, 3♠\n" +
                      "C5: 5♥, 4♠\n" +
                      "C6: 6♥, 5♠\n" +
                      "C7: 7♥, 6♠\n" +
                      "C8: 8♥, 7♠\n" +
                      "C9: 9♥, 8♠\n" +
                      "C10:\n" +
                      "C11: J♥, 10♠\n" +
                      "C12: Q♥, J♠, 10♥, 9♠\n" +
                      "C13: K♥, Q♠\n" +
                      "C14: A♦, K♠\n" +
                      "C15: 2♦, A♣\n" +
                      "C16: 3♦, 2♣\n" +
                      "C17: 4♦, 3♣\n" +
                      "C18: 5♦, 4♣\n" +
                      "C19: 6♦, 5♣\n" +
                      "C20: 7♦, 6♣\n" +
                      "C21: 8♦, 7♣\n" +
                      "C22: 9♦, 8♣\n" +
                      "C23: 10♦, 9♣\n" +
                      "C24: J♦, 10♣\n" +
                      "C25: Q♦, J♣\n");
    }
  }

  // <------------------------------- Test Controller Constructor -------------------------------->
  @Test
  public void testRenderMessage() {
    input = new StringReader("F");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" +
              "O2:\n" + "O3:\n" + "O4:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
              + "Invalid SourcePile input. Please Enter Again.\n");
    }
  }

  @Test
  public void testRenderBoard() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
              + "O2:\n" + "O3:\n" + "O4:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n");
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerWithInvalidModel() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(null, input, outPutLog);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerWithInvalidReadable() {
    controller = new SimpleFreecellController<>(model, null, outPutLog);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerWithInvalidAppendable() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, null);
  }

  // <------------------------------- Test play game ---------------------------------------->
  @Test
  public void testPlayGameWithPlayGameCallingAgain() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 2, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n");
    }
    try {
      controller.playGame(model.getDeck(), 5, 5, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" +
              "F2:\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "O2:\n" +
              "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
              "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
              "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
              "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
              "F1:\n" +
              "F2:\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "O2:\n" +
              "O3:\n" +
              "O4:\n" +
              "O5:\n" +
              "C1: A♣, 6♣, J♣, 3♦, 8♦, K♦, 5♠, 10♠, 2♥, 7♥, Q♥\n" +
              "C2: 2♣, 7♣, Q♣, 4♦, 9♦, A♠, 6♠, J♠, 3♥, 8♥, K♥\n" +
              "C3: 3♣, 8♣, K♣, 5♦, 10♦, 2♠, 7♠, Q♠, 4♥, 9♥\n" +
              "C4: 4♣, 9♣, A♦, 6♦, J♦, 3♠, 8♠, K♠, 5♥, 10♥\n" +
              "C5: 5♣, 10♣, 2♦, 7♦, Q♦, 4♠, 9♠, A♥, 6♥, J♥\n");
    }
  }


  @Test
  public void testPlayGameWithANullDeck() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(null, 1, 1, false);
    } catch (IllegalArgumentException e) {
      assertEquals("The deck cannot be null.", e.getMessage());
    }
  }

  @Test
  public void testPlayGameStartGameInvalidCascades() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 1, 1, false);
    assertEquals(outPutLog.toString(), "Could not start game.");
  }

  @Test
  public void testPlayGameStartGameInvalidCascadesNegativeNumber() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), -1, 3, false);
    assertEquals(outPutLog.toString(), "Could not start game.");
  }

  @Test
  public void testPlayGameStartGameInvalidOpenPilesNegativeNumber() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, -1, false);
    assertEquals(outPutLog.toString(), "Could not start game.");
  }

  @Test
  public void testPlayGameStartGameInvalidOpenPiles() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 0, false);
    assertEquals(outPutLog.toString(), "Could not start game.");
  }

  @Test()
  public void testPlayGameStartGameWithShuffle() {
    input = new StringReader("");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 52, 1, true);

    } catch (IllegalStateException e) {
      assertNotEquals(model.getCascadeCardAt(0, 0),
              new Card(Value.ACE, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(1, 0),
              new Card(Value.TWO, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(2, 0),
              new Card(Value.THREE, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(3, 0),
              new Card(Value.FOUR, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(4, 0),
              new Card(Value.FIVE, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(5, 0),
              new Card(Value.SIX, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(6, 0),
              new Card(Value.SEVEN, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(7, 0),
              new Card(Value.EIGHT, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(8, 0),
              new Card(Value.NINE, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(9, 0),
              new Card(Value.TEN, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(10, 0),
              new Card(Value.JACK, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(11, 0),
              new Card(Value.QUEEN, Suit.CLUB));
      assertNotEquals(model.getCascadeCardAt(12, 0),
              new Card(Value.KING, Suit.CLUB));

      assertNotEquals(model.getCascadeCardAt(13, 0),
              new Card(Value.ACE, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(14, 0),
              new Card(Value.TWO, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(15, 0),
              new Card(Value.THREE, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(16, 0),
              new Card(Value.FOUR, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(17, 0),
              new Card(Value.FIVE, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(18, 0),
              new Card(Value.SIX, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(19, 0),
              new Card(Value.SEVEN, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(20, 0),
              new Card(Value.EIGHT, Suit.DIAMOND));
      assertNotEquals(model.getCascadeCardAt(21, 0),
              new Card(Value.NINE, Suit.DIAMOND));
    }
  }

  @Test()
  public void testPlayGameUserInputInvalidStringSourcePile() {
    input = new StringReader("1C21 1 asdf 3 J9 L3 M3 V C F 1.0");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 52, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
              + "C1: A♣\n" + "C2: 2♣\n" + "C3: 3♣\n" + "C4: 4♣\n" + "C5: 5♣\n" + "C6: 6♣\n"
              + "C7: 7♣\n" + "C8: 8♣\n" + "C9: 9♣\n" + "C10: 10♣\n" + "C11: J♣\n"
              + "C12: Q♣\n" + "C13: K♣\n" + "C14: A♦\n" + "C15: 2♦\n" + "C16: 3♦\n"
              + "C17: 4♦\n" + "C18: 5♦\n" + "C19: 6♦\n" + "C20: 7♦\n" + "C21: 8♦\n"
              + "C22: 9♦\n" + "C23: 10♦\n" + "C24: J♦\n" + "C25: Q♦\n" + "C26: K♦\n"
              + "C27: A♠\n" + "C28: 2♠\n" + "C29: 3♠\n" + "C30: 4♠\n" + "C31: 5♠\n"
              + "C32: 6♠\n" + "C33: 7♠\n" + "C34: 8♠\n" + "C35: 9♠\n" + "C36: 10♠\n"
              + "C37: J♠\n" + "C38: Q♠\n" + "C39: K♠\n" + "C40: A♥\n" + "C41: 2♥\n"
              + "C42: 3♥\n" + "C43: 4♥\n" + "C44: 5♥\n" + "C45: 6♥\n" + "C46: 7♥\n"
              + "C47: 8♥\n" + "C48: 9♥\n" + "C49: 10♥\n" + "C50: J♥\n" + "C51: Q♥\n"
              + "C52: K♥\n" + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n");
    }

  }

  @Test()
  public void testPlayGameUserInputInvalidCardIndex() {
    input = new StringReader("C1 adsflkj adjk 1.0 m12 kfj4 flkjalsd");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);

    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameWithRandomInputWithCorrectMovesInBetween() {
    // C1, 1, and O3
    Readable input = new StringReader("G431asdf 1.0 23 C1 fdsawe Fasdf D1 1 Or2 O3");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 52, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n"
              + "F4:\n" + "O1:\n" + "O2:\n" + "O3:\n" + "O4:\n" + "C1: A♣\n"
              + "C2: 2♣\n" + "C3: 3♣\n" + "C4: 4♣\n" + "C5: 5♣\n" + "C6: 6♣\n"
              + "C7: 7♣\n" + "C8: 8♣\n" + "C9: 9♣\n" + "C10: 10♣\n" + "C11: J♣\n"
              + "C12: Q♣\n" + "C13: K♣\n" + "C14: A♦\n" + "C15: 2♦\n" + "C16: 3♦\n"
              + "C17: 4♦\n" + "C18: 5♦\n" + "C19: 6♦\n" + "C20: 7♦\n" + "C21: 8♦\n"
              + "C22: 9♦\n" + "C23: 10♦\n" + "C24: J♦\n" + "C25: Q♦\n" + "C26: K♦\n"
              + "C27: A♠\n" + "C28: 2♠\n" + "C29: 3♠\n" + "C30: 4♠\n" + "C31: 5♠\n"
              + "C32: 6♠\n" + "C33: 7♠\n" + "C34: 8♠\n" + "C35: 9♠\n" + "C36: 10♠\n"
              + "C37: J♠\n" + "C38: Q♠\n" + "C39: K♠\n" + "C40: A♥\n" + "C41: 2♥\n"
              + "C42: 3♥\n" + "C43: 4♥\n" + "C44: 5♥\n" + "C45: 6♥\n" + "C46: 7♥\n"
              + "C47: 8♥\n" + "C48: 9♥\n" + "C49: 10♥\n" + "C50: J♥\n" + "C51: Q♥\n"
              + "C52: K♥\n" + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid SourcePile input. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Card Index. Please Enter Again.\n"
              + "Invalid Destination Pile. Please Enter Again.\n"
              + "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" + "O2:\n"
              + "O3: A♣\n" + "O4:\n" + "C1:\n" + "C2: 2♣\n" + "C3: 3♣\n"
              + "C4: 4♣\n" + "C5: 5♣\n" + "C6: 6♣\n" + "C7: 7♣\n"
              + "C8: 8♣\n" + "C9: 9♣\n" + "C10: 10♣\n" + "C11: J♣\n"
              + "C12: Q♣\n" + "C13: K♣\n" + "C14: A♦\n" + "C15: 2♦\n"
              + "C16: 3♦\n" + "C17: 4♦\n" + "C18: 5♦\n" + "C19: 6♦\n"
              + "C20: 7♦\n" + "C21: 8♦\n" + "C22: 9♦\n" + "C23: 10♦\n"
              + "C24: J♦\n" + "C25: Q♦\n" + "C26: K♦\n" + "C27: A♠\n"
              + "C28: 2♠\n" + "C29: 3♠\n" + "C30: 4♠\n" + "C31: 5♠\n" + "C32: 6♠\n"
              + "C33: 7♠\n" + "C34: 8♠\n" + "C35: 9♠\n" + "C36: 10♠\n" + "C37: J♠\n"
              + "C38: Q♠\n" + "C39: K♠\n" + "C40: A♥\n" + "C41: 2♥\n" + "C42: 3♥\n"
              + "C43: 4♥\n" + "C44: 5♥\n" + "C45: 6♥\n" + "C46: 7♥\n" + "C47: 8♥\n" + "C48: 9♥\n"
              + "C49: 10♥\n" + "C50: J♥\n" + "C51: Q♥\n" + "C52: K♥\n");
    }

  }

  @Test
  public void testPlayGameUserInputInvalidDestinationPile() {
    input = new StringReader("C1 1 jfalkd fjlkasdj O1a Oa1 A3 aO1");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
              "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
              "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
              "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
              "Invalid Destination Pile. Please Enter Again.\n"
              + "Invalid Destination Pile. Please Enter Again.\n"
              + "Invalid Destination Pile. Please Enter Again.\n" +
              "Invalid Destination Pile. Please Enter Again.\n"
              + "Invalid Destination Pile. Please Enter Again.\n" +
              "Invalid Destination Pile. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputSpecialCharactersSourcePile1() {
    input = new StringReader(" ! @ # $ % ^ & * ( )");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" +
              "F2:\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
              "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
              "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
              "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n" +
              "Invalid SourcePile input. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputSpecialCharactersSourcePile2() {
    input = new StringReader(" _ - + = { } [ ] |  : ; < > , . / ? ` ~");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n");
    }
  }


  @Test
  public void testPlayGameUserInputSpecialCharactersCardIndex1() {
    input = new StringReader("C1 ! @ # $ % ^ & * ( )");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputSpecialCharactersCardIndex2() {
    input = new StringReader("C1 _ - + = { } [ ] |  : ; < > , . / ? ` ~");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n" +
                      "Invalid Card Index. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputSpecialCharactersDestinationPile1() {
    input = new StringReader("C1 1 ! @ # $ % ^ & * ( )");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputSpecialCharactersDestinationPile2() {
    input = new StringReader("C1 1 _ - + = { } [ ] |  : ; < > , . / ? ` ~");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 1, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n" +
                      "Invalid Destination Pile. Please Enter Again.\n");
    }
  }

  @Test
  public void testPlayGameUserInputCorrectInputButInvalidMoves() {
    input = new StringReader("C1 1 F1 F1 1 C1 O2 1 C1");
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
              + "O2:\n" + "O3:\n" + "O4:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
              + "Invalid move. Try Again\n"
              + "Invalid move. Try Again\n"
              + "Invalid move. Try Again\n");
    }

  }

  @Test
  public void testPlayGameWithValidInputValidMove() {
    this.input = new StringReader("C1 13 O1");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 4, false);

    } catch (IllegalStateException e) {
      assertEquals(model.getNumOpenPiles(), 4);
      assertEquals(model.getOpenCardAt(0), new Card(Value.TEN, Suit.HEART));
      assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n"
              + "O1:\n" + "O2:\n" + "O3:\n" + "O4:\n"
              + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
              + "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1: 10♥\n" + "O2:\n"
              + "O3:\n" + "O4:\n" + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥\n"
              + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
              + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
              + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n");
    }
  }

  @Test
  public void testPlayGameQuitWhenLookingForSourcePile() {
    input = new StringReader("q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n"
            + "O1:\n" + "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameQuitWhenLookingForCardIndex() {
    input = new StringReader("C1 q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n"
            + "O1:\n" + "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameQuitWhenLookingForDestinationPile() {
    input = new StringReader("C1 1 q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" +
            "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameQuitWhenLookingForDestinationPileWithCapitalQ() {
    input = new StringReader("C1 1 Q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" +
            "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameQuitWhenLookingForCardIndexWithCapitalQ() {
    input = new StringReader("C1 Q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" +
            "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameQuitWhenLookingForSourcePileWithCapitalQ() {
    input = new StringReader("C1 1 Q");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    assertEquals(outPutLog.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n" +
            "O2:\n" + "O3:\n" + "O4:\n"
            + "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n"
            + "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n"
            + "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n"
            + "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n"
            + "Game quit prematurely.\n");
  }

  @Test
  public void testPlayGameDoesNotQuit() {
    input = new StringReader("Q12 Qndf QAD Q1.0 q12 qndf qad q1.0");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    try {
      controller.playGame(model.getDeck(), 4, 4, false);
    } catch (IllegalStateException e) {
      assertEquals(outPutLog.toString(),
              "F1:\n" +
                      "F2:\n" +
                      "F3:\n" +
                      "F4:\n" +
                      "O1:\n" +
                      "O2:\n" +
                      "O3:\n" +
                      "O4:\n" +
                      "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♠, 7♠, J♠, 2♥, 6♥, 10♥\n" +
                      "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♠, 8♠, Q♠, 3♥, 7♥, J♥\n" +
                      "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♠, 5♠, 9♠, K♠, 4♥, 8♥, Q♥\n" +
                      "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♠, 6♠, 10♠, A♥, 5♥, 9♥, K♥\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n" +
                      "Invalid SourcePile input. Please Enter Again.\n");

    }
  }

  @Test
  public void testPlayGameGameOver() {
    input = new StringReader(
            "C1 1 F1 C2 1 F1 C3 1 F1 C4 1 F1 C5 1 F1 C6 1 F1 C7 1 F1 C8 1 F1 C9 1 F1 C10 1" +
                    " F1 C11 1 F1 C12 1 F1 C13 1 F1 C14 1 F2 C15 1 F2 C16 1 F2 C17 1 F2 C18 1 " +
                    "F2 C19 1 F2 C20 1 F2 C21 1 F2 C22 1 F2 C23 1 F2 C24 1 F2 C25 1 F2 C26 1 F2 " +
                    "C27 1 F3 C28 1 F3 C29 1 F3 C30 1 F3 C31 1 F3 C32 1 F3 C33 1 F3 C34 1 F3 " +
                    "C35 1 F3 C36 1 F3 C37 1 F3 C38 1 F3 C39 1 F3 C40 1 F4 C41 1 F4 C42 1 F4 C43 " +
                    "1 F4 C44 1 F4 C45 1 F4 C46 1 F4 C47 1 F4 C48 1 F4 C49 1 F4 C50 1 F4 C51 1 " +
                    "F4 C52 1 F4 ");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 52, 4, false);
    assertEquals(outPutLog.toString(),
            "F1:\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1: A♣\n" +
                    "C2: 2♣\n" +
                    "C3: 3♣\n" +
                    "C4: 4♣\n" +
                    "C5: 5♣\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2: 2♣\n" +
                    "C3: 3♣\n" +
                    "C4: 4♣\n" +
                    "C5: 5♣\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3: 3♣\n" +
                    "C4: 4♣\n" +
                    "C5: 5♣\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4: 4♣\n" +
                    "C5: 5♣\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5: 5♣\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6: 6♣\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7: 7♣\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8: 8♣\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9: 9♣\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10: 10♣\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11: J♣\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12: Q♣\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13: K♣\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2:\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14: A♦\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15: 2♦\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16: 3♦\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17: 4♦\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18: 5♦\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19: 6♦\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20: 7♦\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21: 8♦\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22: 9♦\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23: 10♦\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24: J♦\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25: Q♦\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26: K♦\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3:\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27: A♠\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28: 2♠\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29: 3♠\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30: 4♠\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31: 5♠\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32: 6♠\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33: 7♠\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34: 8♠\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35: 9♠\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36: 10♠\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37: J♠\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38: Q♠\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39: K♠\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4:\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40: A♥\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41: 2♥\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42: 3♥\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43: 4♥\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44: 5♥\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45: 6♥\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46: 7♥\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47: 8♥\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48: 9♥\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48:\n" +
                    "C49: 10♥\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48:\n" +
                    "C49:\n" +
                    "C50: J♥\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48:\n" +
                    "C49:\n" +
                    "C50:\n" +
                    "C51: Q♥\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48:\n" +
                    "C49:\n" +
                    "C50:\n" +
                    "C51:\n" +
                    "C52: K♥\n" +
                    "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
                    "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
                    "F3: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
                    "F4: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
                    "O1:\n" +
                    "O2:\n" +
                    "O3:\n" +
                    "O4:\n" +
                    "C1:\n" +
                    "C2:\n" +
                    "C3:\n" +
                    "C4:\n" +
                    "C5:\n" +
                    "C6:\n" +
                    "C7:\n" +
                    "C8:\n" +
                    "C9:\n" +
                    "C10:\n" +
                    "C11:\n" +
                    "C12:\n" +
                    "C13:\n" +
                    "C14:\n" +
                    "C15:\n" +
                    "C16:\n" +
                    "C17:\n" +
                    "C18:\n" +
                    "C19:\n" +
                    "C20:\n" +
                    "C21:\n" +
                    "C22:\n" +
                    "C23:\n" +
                    "C24:\n" +
                    "C25:\n" +
                    "C26:\n" +
                    "C27:\n" +
                    "C28:\n" +
                    "C29:\n" +
                    "C30:\n" +
                    "C31:\n" +
                    "C32:\n" +
                    "C33:\n" +
                    "C34:\n" +
                    "C35:\n" +
                    "C36:\n" +
                    "C37:\n" +
                    "C38:\n" +
                    "C39:\n" +
                    "C40:\n" +
                    "C41:\n" +
                    "C42:\n" +
                    "C43:\n" +
                    "C44:\n" +
                    "C45:\n" +
                    "C46:\n" +
                    "C47:\n" +
                    "C48:\n" +
                    "C49:\n" +
                    "C50:\n" +
                    "C51:\n" +
                    "C52:\n" +
                    "Game over.\n");
  }

  @Test(expected = IllegalStateException.class)
  public void testPlayGameNoElementsLeft() {
    input = new StringReader("");
    FreecellController<Card> controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
  }


  @Test(expected = IllegalStateException.class)
  public void testIOExceptionAppendable() {
    input = new StringReader("");
    outPutLog = new FaillingAppendable();
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    fail("Expected IOException did not happen");
  }

  @Test(expected = IllegalStateException.class)
  public void testIOExceptionReadable() {
    input = new FaillingReadable();
    controller = new SimpleFreecellController<>(model, input, outPutLog);
    controller.playGame(model.getDeck(), 4, 4, false);
    fail("Expected IOException did not happen");
  }


}