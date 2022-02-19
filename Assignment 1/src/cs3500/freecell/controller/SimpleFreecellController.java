package cs3500.freecell.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;

public class SimpleFreecellController<Card> implements FreecellController<Card> {
  private final FreecellView view;
  private final FreecellModel<Card> model;
  private final Scanner scan;


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
   * @throws IllegalStateException    if writing to the Appendable object used by it fails or reading from the provided Readable fails
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
      } catch (IOException ioException) {
        throw new IllegalStateException("Appendable cannot append");
      }
    }
    try {

      view.renderBoard();
      ArrayList<String> commandSequence = new ArrayList<>();
      while (!model.isGameOver()) {

        String a, b, c;
        if (!scan.hasNext()) {
          throw new IllegalStateException("Readable does not have anymore elements");
        }

        while (commandSequence.size() == 0) {
          try {
            a = scan.next();
            if (isValidInput(a)) {
              commandSequence.add(a);
            } else if (a.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
          } catch (InputMismatchException e) {
            view.renderMessage("Invalid String: " + scan.next() + "\n");
          }
        }

        while (commandSequence.size() == 1) {
          try {
            b = scan.next();
            if (isInteger(b)) {
              commandSequence.add(b);
            } else if (b.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
          } catch (InputMismatchException e) {
            view.renderMessage("Invalid String: " + scan.next() + "\n");
          }
        }

        while (commandSequence.size() == 2) {
          try {

            c = scan.next();
            if (isValidInput(c)) {
              commandSequence.add(c);
            } else if (c.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely." + "\n");
              return;
            }
          } catch (InputMismatchException e) {
            view.renderMessage("Invalid String: " + scan.next() + "\n");
          }
        }

        PileType sourcePile;
        int sourcePileNum;
        int cardIndex;
        PileType destPile;
        int destPileNum;

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
          view.renderMessage("Invalid moves" + "\n");
        }

      }
      view.renderMessage("Game over." + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Not able to Append");
    }

  }

  private boolean isInteger(String b) {
    try {
      Integer.parseInt(b);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    return true;
  }

  private int toPileNum(String s) {
    return Integer.parseInt(s.substring(1)) - 1;
  }

  private PileType toPile(String s) throws IOException {
    switch (s.charAt(0)) {
      case 'O':
        return PileType.OPEN;
      case 'F':
        return PileType.FOUNDATION;
      case 'C':
        return PileType.CASCADE;
      default:
        throw new IOException("Bad input");
    }
  }

  private boolean isValidInput(String a) throws IOException {
    return a.length() >= 2 && goodInput(a.charAt(0)) && isInteger(a.substring(1));
  }


  private boolean goodInput(char charAt) throws IOException {
    switch (charAt) {
      case 'C':
      case 'F':
      case 'O':
        return true;
      default:
        throw new IOException("Bad Input");
    }

  }


}
