import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;
import cs3500.freecell.view.FreecellTextView;

import static org.junit.Assert.assertEquals;

/**
 * A test class for FreeCellTextView.
 */
public class FreecellTextViewTest {
  FreecellTextView textView;
  FreecellModel model;

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


  @Before
  public void setUp() {
    // Valid deck
    loc.addAll(Arrays.asList(clubCards));
    loc.addAll(Arrays.asList(diamondCards));
    loc.addAll(Arrays.asList(spadeCards));
    loc.addAll(Arrays.asList(heartCard));
  }

  @Test
  public void testEmptyString() {
    model = new SimpleFreecellModel();
    textView = new FreecellTextView(model, new StringBuilder());
    assertEquals(textView.toString(), "");
  }

  @Test
  public void testRenderBoard() {

  }


  @Test
  public void testToString() {
    model = new SimpleFreecellModel();
    model.startGame(loc, 5, 2, false);
    textView = new FreecellTextView(model, new StringBuilder());
    assertEquals(textView.toString(), "F1:\n" + "F2:\n" + "F3:\n" + "F4:\n" + "O1:\n"
            + "O2:\n" + "C1: A♣, 6♣, J♣, 3♦, 8♦, K♦, 5♠, 10♠, 2♥, 7♥, Q♥\n"
            + "C2: 2♣, 7♣, Q♣, 4♦, 9♦, A♠, 6♠, J♠, 3♥, 8♥, K♥\n"
            + "C3: 3♣, 8♣, K♣, 5♦, 10♦, 2♠, 7♠, Q♠, 4♥, 9♥\n"
            + "C4: 4♣, 9♣, A♦, 6♦, J♦, 3♠, 8♠, K♠, 5♥, 10♥\n"
            + "C5: 5♣, 10♣, 2♦, 7♦, Q♦, 4♠, 9♠, A♥, 6♥, J♥");
  }

}