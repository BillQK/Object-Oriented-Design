import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.Value;
import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * A test class for multi move free model test.
 */
public class MultiMoveFreecellModelTest {

  FreecellModel<Card> g1 = new MultiMoveFreecellModel();
  FreecellModel<Card> g2 = new MultiMoveFreecellModel();
  FreecellModel<Card> g3 = new MultiMoveFreecellModel();
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

  // <------------------------------- Multi Move Model Test --------------------------------------->

  @Test //
  public void testInvalidMultiMoveWithEmptySourcePile() {
    g1.startGame(loc1, 25, 4, false);
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 11);
    assertEquals(g1.getNumCardsInCascadePile(9), 0);
    // move empty source pile (failed)
    try {
      g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 11);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid source pile. No Cards Available");
    }
  }

  @Test //
  public void testMultiMove4CardsIntoAnEmptyCascades() {
    g1.startGame(g1.getDeck(), 20, 4, false);
    // set up move
    g1.move(PileType.CASCADE, 4, 2, PileType.CASCADE, 12);
    g1.move(PileType.CASCADE, 4, 1, PileType.CASCADE, 18);
    g1.move(PileType.CASCADE, 4, 0, PileType.CASCADE, 12);
    g1.move(PileType.CASCADE, 2, 2, PileType.CASCADE, 12);
    assertEquals(g1.getNumCardsInCascadePile(4), 0);
    // Multi move 4 cards
    g1.move(PileType.CASCADE, 12, 1, PileType.CASCADE, 4);
    // check
    assertEquals(g1.getNumCardsInCascadePile(4), 4);
  }

  @Test //
  public void testMultiMove2CardsIntoCascades() {
    g1.startGame(g1.getDeck(), 20, 4, false);
    // set up move
    g1.move(PileType.CASCADE, 4, 2, PileType.CASCADE, 12);
    g1.move(PileType.CASCADE, 4, 1, PileType.CASCADE, 18);
    g1.move(PileType.CASCADE, 2, 2, PileType.CASCADE, 4);
    assertEquals(g1.getNumCardsInCascadePile(4), 2);

    // Multi move 2 cards
    g1.move(PileType.CASCADE, 4, 0, PileType.CASCADE, 12);
    // check
    assertEquals(g1.getNumCardsInCascadePile(12), 5);

  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveToOpenPiles() {
    g1.startGame(g1.getDeck(), 20, 4, false);
    // set up move
    // set up move
    g1.move(PileType.CASCADE, 4, 2, PileType.CASCADE, 12);
    g1.move(PileType.CASCADE, 4, 1, PileType.CASCADE, 18);
    g1.move(PileType.CASCADE, 2, 2, PileType.CASCADE, 4);
    assertEquals(g1.getNumCardsInCascadePile(4), 2);

    // Multi move 2 cards
    g1.move(PileType.CASCADE, 4, 0, PileType.CASCADE, 12);
    // check
    assertEquals(g1.getNumCardsInCascadePile(12), 5);

    // failed move 4 cards to Open Pile
    g1.move(PileType.CASCADE, 12, 1, PileType.OPEN, 1);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveToFoundationPiles() {
    g1.startGame(g1.getDeck(), 20, 4, false);
    // set up move
    g1.move(PileType.CASCADE, 4, 2, PileType.CASCADE, 12);
    g1.move(PileType.CASCADE, 4, 1, PileType.CASCADE, 18);
    g1.move(PileType.CASCADE, 2, 2, PileType.CASCADE, 4);
    assertEquals(g1.getNumCardsInCascadePile(4), 2);

    // Multi move 2 cards
    g1.move(PileType.CASCADE, 4, 0, PileType.CASCADE, 12);
    // check
    assertEquals(g1.getNumCardsInCascadePile(12), 5);

    // failed move 4 cards to Open Pile
    g1.move(PileType.CASCADE, 12, 1, PileType.FOUNDATION, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMultiMoveNullSourcePiles() {
    g1.startGame(loc1, 25, 2, false);
    g1.move(null, 2, 1, PileType.CASCADE, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMultiMoveNullDestinationPiles() {
    g1.startGame(loc1, 25, 2, false);
    g1.move(PileType.CASCADE, 2, 1, null, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMultiMoveNullPiles() {
    g1.startGame(loc1, 25, 2, false);
    g1.move(null, 2, 1, null, 0);
  }


  @Test(expected = IllegalArgumentException.class) //
  public void testMultiMove5CardsToAnEmptyCascadePilesWith1OpenPiles() {
    g1.startGame(loc1, 25, 2, false);
    // set up move
    g1.move(PileType.CASCADE, 0, 2, PileType.OPEN, 0);
    g1.move(PileType.CASCADE, 11, 0, PileType.CASCADE, 13);

    // Only one open pile and one open cascade
    assertEquals(g1.getNumCardsInCascadePile(11), 0);
    assertNull(g1.getOpenCardAt(1));

    // compile a 5 cards build
    g1.move(PileType.CASCADE, 22, 0, PileType.CASCADE, 13);
    assertEquals(g1.getNumCardsInCascadePile(13), 6);

    // move to fill an empty cascade
    assertEquals(g1.getNumCardsInCascadePile(22), 0);
    g1.move(PileType.CASCADE, 21, 1, PileType.CASCADE, 22);
    assertEquals(g1.getNumCardsInCascadePile(22), 1);

    // invalid move
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 11);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testMultiMove5CardsToNonEmptyCascadePilesWith1OpenPiles() {
    g1.startGame(loc1, 25, 2, false);
    // set up move
    g1.move(PileType.CASCADE, 0, 2, PileType.OPEN, 0);
    g1.move(PileType.CASCADE, 11, 0, PileType.CASCADE, 13);

    // Only one open pile and one open cascade
    assertEquals(g1.getNumCardsInCascadePile(11), 0);
    assertNull(g1.getOpenCardAt(1));

    // compile a 5 cards build
    g1.move(PileType.CASCADE, 22, 0, PileType.CASCADE, 13);
    assertEquals(g1.getNumCardsInCascadePile(13), 6);

    // move to fill an empty cascade
    assertEquals(g1.getNumCardsInCascadePile(22), 0);
    g1.move(PileType.CASCADE, 21, 1, PileType.CASCADE, 22);
    assertEquals(g1.getNumCardsInCascadePile(22), 1);

    // invalid move
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveNumberOfCardsMoreThanAllowedCardSize() {
    g1.startGame(loc1, 25, 2, false);
    // set up move
    g1.move(PileType.CASCADE, 0, 2, PileType.OPEN, 0);
    g1.move(PileType.CASCADE, 11, 0, PileType.CASCADE, 13);

    // Only one open pile and one open cascade
    assertEquals(g1.getNumCardsInCascadePile(11), 0);
    assertNull(g1.getOpenCardAt(1));

    // compile a 5 cards build
    g1.move(PileType.CASCADE, 22, 0, PileType.CASCADE, 13);
    assertEquals(g1.getNumCardsInCascadePile(13), 6);

    // move to fill an empty cascade
    assertEquals(g1.getNumCardsInCascadePile(22), 0);
    g1.move(PileType.CASCADE, 21, 1, PileType.CASCADE, 22);
    assertEquals(g1.getNumCardsInCascadePile(22), 1);

    // invalid move because 5 cards > 4 allowed card size since there is one open pile
    // and cascade pile, so cannot move 5 cards into the empty piles.
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 11);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveValidBuildButInvalidMoveToCascadePile() {
    g1.startGame(loc1, 25, 2, false);
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveWithInvalidCardListDifferentSuitButNotDecreasingValue() {
    g1.startGame(loc1, 25, 2, false);
    // Ace of Diamond, King of Spade --> Two of spade
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 0);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveWithInvalidCardListDecreasingValueButNotDifferentSuit() {
    g1.startGame(g1.getDeck(), 25, 2, false);
    // Ten of club, nine of spade --> Jack of Heart
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 23);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveWithSameValueAndDifferentSuit() {
    g1.startGame(g1.getDeck(), 25, 2, false);
    // Ten of club, ten of Heart --> Jack of Heart
    g1.move(PileType.CASCADE, 10, 0, PileType.CASCADE, 23);
  }

  @Test(expected = IllegalArgumentException.class) //
  public void testInvalidMultiMoveWithInvalidBuild() {
    g1.startGame(g1.getDeck(), 25, 2, false);

    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 11);

  }

  @Test(expected = IllegalArgumentException.class) //
  public void testMultiMove13CardsToAnNonEmptyCascadePile() {
    g1.startGame(loc1, 25, 4, false);
    g1.move(PileType.CASCADE, 11, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 7, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 5, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 14, 0, PileType.CASCADE, 13);

    // move 13 cards
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 14);
    assertEquals(g1.getNumCardsInCascadePile(14), 13);

    // failed
    g1.move(PileType.CASCADE, 14, 0, PileType.CASCADE, 1);
  }

  @Test //
  public void testMultiMove13CardsToANonEmptyCascadePile() {
    g1.startGame(loc1, 25, 4, false);
    g1.move(PileType.CASCADE, 11, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 7, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 5, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 13);
    g1.move(PileType.CASCADE, 14, 0, PileType.CASCADE, 13);

    // move 13 cards
    g1.move(PileType.CASCADE, 13, 1, PileType.CASCADE, 14);
    assertEquals(g1.getNumCardsInCascadePile(14), 13);
  }

  @Test //
  public void testMultiMove2CardsToAnNonEmptyCascadePile() {
    g1.startGame(loc1, 25, 4, false);
    assertEquals(g1.getNumCardsInCascadePile(9), 2);
    g1.move(PileType.CASCADE, 9, 0, PileType.CASCADE, 11);
    assertEquals(g1.getNumCardsInCascadePile(11), 4);
  }


  // <------------------------------- One Move Test ------------------------------------------->
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithAnDuplicateDeck() {
    g1.startGame(duplicateDeck, 4, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithAnEmptyDeck() {
    List<Card> emptyDeck = new ArrayList<>();
    g1.startGame(emptyDeck, 4, 5, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithInValidCasCadePile() {
    g1.startGame(loc, 2, 1, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithInValidOpenPiles() {
    g1.startGame(loc, 5, 0, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameWithNullDeck() {
    g1.startGame(nullDeck, 4, 4, true);
  }

  @Test
  public void testGetDeck() {
    assertEquals(g1.getDeck(), loc);
  }

  @Test
  public void testShuffleGameState() {
    g1.startGame(loc, 4, 4, false);
    g2.startGame(loc, 4, 4, true);
    g3.startGame(loc, 4, 4, false);

    // Test shuffle
    assertNotEquals(g1.getCascadeCardAt(0, 1), g2.getCascadeCardAt(0, 1));
    assertNotEquals(g1.getCascadeCardAt(1, 2), g2.getCascadeCardAt(1, 2));
    assertNotEquals(g2.getCascadeCardAt(1, 6), g1.getCascadeCardAt(1, 6));
    assertNotEquals(g2.getCascadeCardAt(3, 7), g1.getCascadeCardAt(3, 7));
    assertNotEquals(g2.getCascadeCardAt(0, 8), g1.getCascadeCardAt(0, 8));
    assertNotEquals(g2.getCascadeCardAt(1, 9), g1.getCascadeCardAt(1, 9));
    assertNotEquals(g2.getCascadeCardAt(2, 10), g1.getCascadeCardAt(2, 10));
    assertNotEquals(g2.getCascadeCardAt(3, 11), g1.getCascadeCardAt(3, 11));

    // Test no shuffle
    assertEquals(g3.getCascadeCardAt(0, 0), g3.getCascadeCardAt(0, 0));
    assertEquals(g3.getCascadeCardAt(1, 1), g3.getCascadeCardAt(1, 1));
    assertEquals(g3.getCascadeCardAt(2, 2), g3.getCascadeCardAt(2, 2));
    assertEquals(g3.getCascadeCardAt(3, 3), g3.getCascadeCardAt(3, 3));
    assertEquals(g3.getCascadeCardAt(1, 4), g3.getCascadeCardAt(1, 4));
  }

  @Test
  public void testStartGame() {
    g1.startGame(loc, 4, 4, false);
    assertEquals(g1.getNumCascadePiles(), 4);
    assertEquals(g1.getNumOpenPiles(), 4);
    assertEquals(g1.getNumCardsInCascadePile(0), 13);
    assertEquals(g1.getNumCardsInCascadePile(1), 13);
    assertEquals(g1.getNumCardsInCascadePile(2), 13);
    assertEquals(g1.getNumCardsInCascadePile(3), 13);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFoundationToCascade() {
    g1.startGame(loc, 52, 4, false);

    g1.move(PileType.FOUNDATION, 1, 1, PileType.CASCADE, 0);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFoundationToOpen() {
    g1.startGame(loc, 52, 4, false);

    g1.move(PileType.FOUNDATION, 1, 1, PileType.CASCADE, 0);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFoundationToFoundation() {
    g1.startGame(loc, 52, 4, false);

    g1.move(PileType.FOUNDATION, 1, 1, PileType.FOUNDATION, 0);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveCascadeToCascadeSuit() {
    g1.startGame(loc, 52, 4, false);
    // Doesn't throw
    g1.move(PileType.CASCADE, 39, 1, PileType.CASCADE, 27);
    // throws because the color/suit doesn't match
    g1.move(PileType.CASCADE, 0, 1, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveCascadeToCascadeValue() {
    g1.startGame(loc, 52, 4, false);
    // Doesn't throw
    g1.move(PileType.CASCADE, 39, 1, PileType.CASCADE, 27);
    // throws because the value is not one smaller although the suit is same
    g1.move(PileType.CASCADE, 2, 1, PileType.CASCADE, 17);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveCascadeToFoundationValue() {
    g1.startGame(loc, 52, 4, false);
    // Doesn't throw
    g1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    // throws because the value is 3 can't add to 1 in the foundation pile
    g1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveCascadeToFoundationSuit() {
    g1.startGame(loc, 52, 4, false);
    // Doesn't throw
    g1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    // throws because the card is 2 Heart can't add to Ace of Club in the foundation pile
    g1.move(PileType.CASCADE, 27, 1, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToOpenNotEmpty() {
    g1.startGame(loc, 52, 4, false);

    // Doesn't throw exception
    g1.move(PileType.CASCADE, 1, 1, PileType.OPEN, 0);
    // Throws the exception
    g1.move(PileType.OPEN, 1, 1, PileType.FOUNDATION, 0);

  }


  @Test
  public void testMove() {
    // Pass in a 52 cascade pile
    g1.startGame(loc, 52, 4, false);

    // Cascade to Open
    g1.move(PileType.CASCADE, 1, 0, PileType.OPEN, 0);
    assertEquals(g1.getOpenCardAt(0), twoClub);
    // Cascade to Foundation
    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 0);
    assertEquals(g1.getFoundationCardAt(0, 0), aceDiamond);
    // Cascade to Cascade
    // Cascade move card aceHeart move to two Spade or Suit
    g1.move(PileType.CASCADE, 39, 0, PileType.CASCADE, 27);
    assertEquals(g1.getCascadeCardAt(27, 1), aceHeart);
    assertEquals(g1.getCascadeCardAt(27, 0), twoSpade);
    // Open to Cascade
    g1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    assertEquals(g1.getCascadeCardAt(1, 0), twoClub);
    // Open to Open
    g1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    assertEquals(g1.getOpenCardAt(0), aceClub);
    g1.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
    assertEquals(g1.getOpenCardAt(1), aceClub);
    // Open to Foundation
    g1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
    assertEquals(g1.getFoundationCardAt(1, 0), aceClub);


  }

  @Test
  public void isGameOver() {
    g1.startGame(loc, 52, 4, false);
    g2.startGame(loc, 5, 4, true);
    g1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION, 0);


    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION, 1);

    g1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 27, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 28, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 29, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 30, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 31, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 32, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 33, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 34, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 35, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 36, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 37, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 38, 0, PileType.FOUNDATION, 2);

    g1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 40, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 41, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 42, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 43, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 44, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 45, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 46, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 47, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 48, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 49, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 50, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 51, 0, PileType.FOUNDATION, 3);

    assertTrue(g1.isGameOver());
    assertFalse(g2.isGameOver());

  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartGetNumCardsInFoundationPile() {
    g1.getNumCardsInFoundationPile(0);
    g1.getNumCardsInFoundationPile(1);
    g1.getNumCardsInFoundationPile(2);
    g1.getNumCardsInFoundationPile(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInFoundationPileOutOfBound() {
    g1.startGame(loc, 52, 4, false);
    g1.getNumCardsInFoundationPile(10);
    g1.getNumCardsInFoundationPile(5);
    g1.getNumCardsInFoundationPile(100);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInFoundationPileNegative() {
    g1.startGame(loc, 52, 4, false);
    g1.getNumCardsInFoundationPile(-1);
    g1.getNumCardsInFoundationPile(-100);
  }

  @Test
  public void testGetNumCardsInFoundationPile() {
    g1.startGame(loc, 52, 4, false);

    assertEquals(g1.getNumCardsInFoundationPile(0), 0);
    assertEquals(g1.getNumCardsInFoundationPile(1), 0);
    assertEquals(g1.getNumCardsInFoundationPile(2), 0);
    assertEquals(g1.getNumCardsInFoundationPile(3), 0);

    g1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    assertEquals(g1.getNumCardsInFoundationPile(0), 1);
    assertEquals(g1.getNumCardsInFoundationPile(1), 0);
    assertEquals(g1.getNumCardsInFoundationPile(2), 0);
    assertEquals(g1.getNumCardsInFoundationPile(3), 0);

    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);

    assertEquals(g1.getNumCardsInFoundationPile(0), 1);
    assertEquals(g1.getNumCardsInFoundationPile(1), 1);
    assertEquals(g1.getNumCardsInFoundationPile(2), 0);
    assertEquals(g1.getNumCardsInFoundationPile(3), 0);

    g1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);

    assertEquals(g1.getNumCardsInFoundationPile(0), 1);
    assertEquals(g1.getNumCardsInFoundationPile(1), 1);
    assertEquals(g1.getNumCardsInFoundationPile(2), 1);
    assertEquals(g1.getNumCardsInFoundationPile(3), 0);

    g1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);
    assertEquals(g1.getNumCardsInFoundationPile(0), 1);
    assertEquals(g1.getNumCardsInFoundationPile(1), 1);
    assertEquals(g1.getNumCardsInFoundationPile(2), 1);
    assertEquals(g1.getNumCardsInFoundationPile(3), 1);


    g1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION, 0);

    assertEquals(g1.getNumCardsInFoundationPile(0), 13);

    g1.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION, 1);

    assertEquals(g1.getNumCardsInFoundationPile(1), 13);

    g1.move(PileType.CASCADE, 27, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 28, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 29, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 30, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 31, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 32, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 33, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 34, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 35, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 36, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 37, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 38, 0, PileType.FOUNDATION, 2);

    assertEquals(g1.getNumCardsInFoundationPile(2), 13);

    g1.move(PileType.CASCADE, 40, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 41, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 42, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 43, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 44, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 45, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 46, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 47, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 48, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 49, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 50, 0, PileType.FOUNDATION, 3);
    g1.move(PileType.CASCADE, 51, 0, PileType.FOUNDATION, 3);

    assertEquals(g1.getNumCardsInFoundationPile(3), 13);


  }


  @Test
  public void testGameNotStartedGetNumCascadePiles() {
    assertEquals(g1.getNumCascadePiles(), -1);
  }

  @Test
  public void testGetNumCascadePiles() {
    g1.startGame(loc, 52, 4, false);
    assertEquals(g1.getNumCascadePiles(), 52);
    g1.startGame(loc, 4, 4, true);
    assertEquals(g1.getNumCascadePiles(), 4);

  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartedGetNumCardsInCascadePile() {
    g1.getNumCardsInCascadePile(0);
    g1.getNumCardsInCascadePile(1);
    g1.getNumCardsInCascadePile(2);
    g1.getNumCardsInCascadePile(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInCascadePileNegative() {
    g1.startGame(loc, 4, 4, true);
    g1.getNumCardsInCascadePile(-1);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInCascadePileOutOfBound() {
    g1.startGame(loc, 4, 4, true);
    g1.getNumCardsInCascadePile(100);
    g1.getNumCardsInCascadePile(30);
    g1.getNumCardsInCascadePile(4);
  }


  @Test
  public void getNumCardsInCascadePile() {
    g1.startGame(loc, 4, 4, false);
    assertEquals(g1.getNumCardsInCascadePile(0), 13);
    assertEquals(g1.getNumCardsInCascadePile(1), 13);
    assertEquals(g1.getNumCardsInCascadePile(2), 13);
    assertEquals(g1.getNumCardsInCascadePile(3), 13);

    g1.move(PileType.CASCADE, 1, 12, PileType.OPEN, 0);
    assertEquals(g1.getNumCardsInCascadePile(1), 12);

    g1.move(PileType.CASCADE, 2, 12, PileType.OPEN, 1);
    assertEquals(g1.getNumCardsInCascadePile(1), 12);

    g1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 2);
    assertEquals(g1.getNumCardsInCascadePile(1), 12);

    g1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 3);
    assertEquals(g1.getNumCardsInCascadePile(1), 12);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInOpenPileNegative() {
    g1.startGame(loc, 4, 4, false);
    g1.getNumCardsInOpenPile(-1);
    g1.getNumCardsInOpenPile(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetNumCardsInOpenPileOutOfBound() {
    g1.startGame(loc, 4, 4, false);
    g1.getNumCardsInOpenPile(4);
    g1.getNumCardsInOpenPile(5);
    g1.getNumCardsInOpenPile(100);
  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartGetNumCardsInOpenPile() {
    g1.getNumCardsInOpenPile(0);
    g1.getNumCardsInOpenPile(1);
    g1.getNumCardsInOpenPile(2);
    g1.getNumCardsInOpenPile(3);
  }

  @Test
  public void testGetNumCardsInOpenPile() {
    g1.startGame(loc, 52, 4, false);
    g1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    assertEquals(g1.getNumCardsInOpenPile(0), 1);

    g1.move(PileType.CASCADE, 1, 0, PileType.OPEN, 1);
    assertEquals(g1.getNumCardsInOpenPile(1), 1);

    g1.move(PileType.CASCADE, 2, 0, PileType.OPEN, 2);
    assertEquals(g1.getNumCardsInOpenPile(2), 1);

    g1.move(PileType.CASCADE, 3, 0, PileType.OPEN, 3);
    assertEquals(g1.getNumCardsInOpenPile(3), 1);

    g1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 0);
    assertEquals(g1.getNumCardsInOpenPile(0), 0);

    g1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 1);
    assertEquals(g1.getNumCardsInOpenPile(1), 0);

    g1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 2);
    assertEquals(g1.getNumCardsInOpenPile(2), 0);

    g1.move(PileType.OPEN, 3, 0, PileType.CASCADE, 3);
    assertEquals(g1.getNumCardsInOpenPile(3), 0);

  }

  @Test()
  public void testGameNotStartedGetNumOpenPiles() {
    assertEquals(g1.getNumOpenPiles(), -1);
  }

  @Test
  public void testGetNumOpenPiles() {
    g1.startGame(loc, 4, 4, false);
    assertEquals(g1.getNumOpenPiles(), 4);
    g1.startGame(loc, 4, 10, true);
    assertEquals(g1.getNumOpenPiles(), 10);
  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartedGetFoundationCardAt() {
    g1.getFoundationCardAt(0, 0);
    g1.getFoundationCardAt(1, 0);
    g1.getFoundationCardAt(2, 1);
    g1.getFoundationCardAt(3, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetFoundationCardAtInValidPileIndex() {
    g1.startGame(loc, 52, 4, false);

    // Moves aces into the foundation piles
    g1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);

    // Invalid Pile Index
    g1.getFoundationCardAt(3, 0);
    g1.getFoundationCardAt(-1, 0);
    g1.getFoundationCardAt(10, 0);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetFoundationCardAtInValidCardIndex() {
    g1.startGame(loc, 52, 4, false);

    // Moves aces into the foundation piles
    g1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);

    // Invalid Card index
    g1.getFoundationCardAt(0, -1);
    g1.getFoundationCardAt(1, 2);
    g1.getFoundationCardAt(2, 3);
    g1.getFoundationCardAt(3, 100);
  }

  @Test
  public void testGetFoundationCardAt() {
    g1.startGame(loc, 52, 4, false);

    // Moves aces into the foundation piles
    g1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    g1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    g1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    g1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);

    assertEquals(g1.getFoundationCardAt(0, 0), aceClub);
    assertEquals(g1.getFoundationCardAt(1, 0), aceDiamond);
    assertEquals(g1.getFoundationCardAt(2, 0), aceSpade);
    assertEquals(g1.getFoundationCardAt(3, 0), aceHeart);
  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartedGetCascadeCardAt() {
    g1.getCascadeCardAt(0, 0);
    g1.getCascadeCardAt(1, 1);
    g1.getCascadeCardAt(2, 2);
    g1.getCascadeCardAt(3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidIndexGetCascadeCardAtInvalidPileIndex() {
    g1.startGame(loc, 52, 4, false);

    // Invalid Pile Index
    g1.getCascadeCardAt(-3, 0);
    g1.getCascadeCardAt(-1, 0);
    g1.getCascadeCardAt(53, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidIndexGetCascadeCardAtInvalidCardIndex() {
    g1.startGame(loc, 52, 4, false);

    // Invalid Card index

    // Doesn't throw
    g1.getCascadeCardAt(1, 1);
    g1.getCascadeCardAt(2, 3);
    // throw exception
    g1.getCascadeCardAt(0, 4);
    g1.getCascadeCardAt(3, 100);
  }

  @Test
  public void testGetCascadeCardAt() {
    g1.startGame(loc, 52, 4, false);
    assertEquals(g1.getCascadeCardAt(0, 0), aceClub);
    assertEquals(g1.getCascadeCardAt(13, 0), aceDiamond);
    assertEquals(g1.getCascadeCardAt(26, 0), aceSpade);
    assertEquals(g1.getCascadeCardAt(39, 0), aceHeart);


    g1.startGame(loc, 4, 4, false);
    assertEquals(g1.getCascadeCardAt(0, 12), tenHeart);
    assertEquals(g1.getCascadeCardAt(1, 12), jackHeart);
    assertEquals(g1.getCascadeCardAt(2, 12), queenHeart);
    assertEquals(g1.getCascadeCardAt(3, 12), kingHeart);

  }

  @Test(expected = IllegalStateException.class)
  public void testGameNotStartedGetOpenCardAt() {
    g1.getNumCardsInOpenPile(0);
    g1.getNumCardsInOpenPile(1);
    g1.getNumCardsInOpenPile(2);
    g1.getNumCardsInOpenPile(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIndexGetOpenCardAtInvalidPileIndex() {
    g1.startGame(loc, 52, 4, false);

    g1.getOpenCardAt(10);
  }


  @Test
  public void testGetOpenCardAt() {
    g1.startGame(loc, 52, 4, false);

    g1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    g1.move(PileType.CASCADE, 13, 0, PileType.OPEN, 1);
    g1.move(PileType.CASCADE, 26, 0, PileType.OPEN, 2);
    g1.move(PileType.CASCADE, 39, 0, PileType.OPEN, 3);

    assertEquals(g1.getOpenCardAt(0), aceClub);
    assertEquals(g1.getOpenCardAt(1), aceDiamond);
    assertEquals(g1.getOpenCardAt(2), aceSpade);
    assertEquals(g1.getOpenCardAt(3), aceHeart);

  }

  @Test(expected = IllegalStateException.class)
  public void testMoveWithoutStartGame() {
    g1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
  }


}