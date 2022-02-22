package cs3500.freecell.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;

/**
 * A representation of a simple freecell controller which implements FreecellController interface,
 * this class receive the user input pass the input to the model and pass the model to the view
 * class.
 *
 * @param <Card> A card class
 */
public class SimpleFreecellController<Card> implements FreecellController<Card> {
  private final FreecellView view;
  private final FreecellModel<Card> model;
  private final Scanner scan;

  /**
   * A constructor for SimpleFreecellController.
   *
   * @param model a FreecellModel
   * @param rd    a Readable
   * @param ap    a Appendable
   */
  public SimpleFreecellController(FreecellModel<Card> model, Readable rd, Appendable ap) {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model");
    }
    if (rd == null) {
      throw new IllegalArgumentException("Invalid readable");
    }
    if (ap == null) {
      throw new IllegalArgumentException("Invalid appendable");
    }
    this.model = model;
    this.view = new FreecellTextView(model, ap);
    this.scan = new Scanner(rd);

  }

  /**
   * Start and play a new game of freecell with the provided deck. This deck
   * should be used as-is. This method returns only when the game is over
   * (either by winning or by quitting)
   *
   * @param deck        the deck to be used to play this game
   * @param numCascades the number of cascade piles
   * @param numOpens    the number of open piles
   * @param shuffle     shuffle the deck if true, false otherwise
   * @throws IllegalStateException    if writing to the Appendable object used by it fails or
   *                                  reading from the provided Readable fails
   * @throws IllegalArgumentException if the deck provided to it are null
   */
  @Override
  public void playGame(List<Card> deck, int numCascades, int numOpens, boolean shuffle) {
    if (deck == null) {
      throw new IllegalArgumentException("The deck cannot be null.");
    }
    try {
      model.startGame(deck, numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException e) {
      try {
        view.renderMessage("Could not start game.");
        return;
      } catch (IOException a) {
        throw new IllegalStateException("Appendable does not work correct\n");
      }
    }
    try {

      view.renderBoard();
      ArrayList<String> commandSequence = new ArrayList<>();

      while (!model.isGameOver()) {

        String a;
        String b;
        String c;
        // Source Pile input checking
        while (commandSequence.size() == 0) {
          try {
            if (scan.hasNext()) {
              a = scan.next();
            } else {
              throw new IllegalStateException("Readable is running out of elements\n");
            }

            if (a.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
            if (isValidInput(a)) {
              commandSequence.add(a);
            }
          } catch (IllegalArgumentException e) {
            view.renderMessage("Invalid SourcePile input. Please Enter Again." + "\n");
          }
        }
        // Card Index input checking
        while (commandSequence.size() == 1) {
          try {
            if (scan.hasNext()) {
              b = scan.next();
            } else {
              throw new IllegalStateException("Readable is running out of elements\n");
            }

            if (b.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
            if (isInteger(b)) {
              commandSequence.add(b);
            }
          } catch (IllegalArgumentException e) {
            view.renderMessage("Invalid Card Index. Please Enter Again." + "\n");
          }
        }
        // Destination Pile input checking
        while (commandSequence.size() == 2) {
          try {
            if (scan.hasNext()) {
              c = scan.next();
            } else {
              throw new IllegalStateException("Readable is running out of elements\n");
            }
            if (c.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
            if (isValidInput(c)) {
              commandSequence.add(c);
            }
          } catch (IllegalArgumentException e) {
            view.renderMessage("Invalid Destination Pile. Please Enter Again." + "\n");
          }
        }

        PileType sourcePile;
        int sourcePileNum;
        int cardIndex;
        PileType destPile;
        int destPileNum;

        // move method
        try {
          if (commandSequence.size() == 3) {
            sourcePile = toPile(commandSequence.get(0));
            sourcePileNum = toPileNum(commandSequence.get(0));
            cardIndex = Integer.parseInt(commandSequence.get(1)) - 1;
            destPile = toPile(commandSequence.get(2));
            destPileNum = toPileNum(commandSequence.get(2));
            model.move(sourcePile, sourcePileNum, cardIndex, destPile, destPileNum);
            commandSequence.clear();
            view.renderBoard();
          }
        } catch (IllegalArgumentException illegalArgumentException) {
          commandSequence.clear();
          view.renderMessage("Invalid move. Try Again" + "\n");
        }

      }
      view.renderMessage("Game over." + "\n");
    } catch (IOException e) {
      try {
        view.renderMessage("Could not start game.\n");
      } catch (IOException ex) {
        throw new IllegalStateException("Appendable does not working correctly.\n");
      }

    }
  }

  /**
   * A method that check to see if the String is an integer.
   *
   * @param b a String
   * @return a boolean
   * @throws IllegalArgumentException if the String is not an integer
   */
  private boolean isInteger(String b) {
    try {
      Integer.parseInt(b);
    } catch (NumberFormatException | NullPointerException e) {
      throw new IllegalArgumentException("Bad input");
    }
    return true;
  }

  /**
   * A method that return an int given the string.
   *
   * @param s a String
   * @return a integer
   */
  private int toPileNum(String s) {
    return Integer.parseInt(s.substring(1)) - 1;
  }

  /**
   * A method that return a PileType given the string.
   *
   * @param s a String
   * @return a PileType
   */
  private PileType toPile(String s) {
    switch (s.charAt(0)) {
      case 'O':
        return PileType.OPEN;
      case 'F':
        return PileType.FOUNDATION;
      case 'C':
        return PileType.CASCADE;
      default:
        throw new IllegalArgumentException("Bad input");
    }
  }

  /**
   * A method that check to see if the string is a valid input.
   *
   * @param a a String
   * @return a boolean
   */
  private boolean isValidInput(String a) {
    if (a.length() >= 2 && goodInput(a.charAt(0)) && isInteger(a.substring(1))) {
      return true;
    } else {
      throw new IllegalArgumentException("Bad input");
    }
  }

  /**
   * A method that to see if the char is a C,F,O.
   *
   * @param charAt a Char
   * @return a boolean
   */
  private boolean goodInput(char charAt) {
    switch (charAt) {
      case 'C':
      case 'F':
      case 'O':
        return true;
      default:
        return false;
    }

  }


}
