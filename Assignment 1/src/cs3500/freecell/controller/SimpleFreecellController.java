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
  private final Readable input;
  private final Appendable output;
  private final Scanner scan;


  public SimpleFreecellController(FreecellModel<Card> model, Readable rd, Appendable ap) {
    if (model == null || rd == null || ap == null) {
      throw new IllegalArgumentException("Invalid the arguments");
    } else {
      this.model = model;
      this.input = rd;
      this.output = ap;
    }
    this.view = new FreecellTextView(model, output);
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
  public void playGame(List<Card> deck, int numCascades, int numOpens, boolean shuffle)
          throws IOException {
    if (deck == null) {
      throw new IllegalArgumentException("The deck cannot be null.");
    }
    try {
      model.startGame(deck, numCascades, numOpens, shuffle);
      view.renderBoard();

      while (!model.isGameOver()) {
        ArrayList<String> commandSequence = new ArrayList<>();

//        try {
//          String str = scan.next();
//          if (str.toLowerCase().equals("q")) {
//            view.renderMessage("Game Quit Prematurely");
//            return;
//          }
//        } catch (IllegalArgumentException illegalArgumentException) {
//          view.renderMessage("Game is still running");
//        }

        String a, c;
        int b;


        while (commandSequence.size() == 0) {
          try {
            a = scan.next();
            if (isValidInput(a)) {
              commandSequence.add(a);
            }
          } catch (InputMismatchException ime) {
            tryCatch("Invalid String: " + scan.next() + "\n");
          }
        }

        while (commandSequence.size() == 1) {
          try {
            b = scan.nextInt();

            commandSequence.add(String.valueOf(b));
          } catch (InputMismatchException ime) {
            tryCatch("Invalid Integer: " + scan.next() + "\n");
          }
        }

        while (commandSequence.size() == 2) {
          try {
            c = scan.next();
            if (isValidInput(c)) {
              commandSequence.add(c);
            }
          } catch (InputMismatchException ime) {
            tryCatch("Invalid String: " + scan.next() + "\n");
          }
        }

        PileType sourcePile;
        int sourcePileNum;
        int cardIndex;
        PileType destPile;
        int destPileNum;


        if (commandSequence.size() == 3) {
          sourcePile = toPile(commandSequence.get(0));
          sourcePileNum = toPileNum(commandSequence.get(0));
          cardIndex = Integer.parseInt(commandSequence.get(1));
          destPile = toPile(commandSequence.get(2));
          destPileNum = toPileNum(commandSequence.get(2));
          model.move(sourcePile, sourcePileNum, cardIndex, destPile, destPileNum);
          view.renderBoard();
        }
        else {
          commandSequence.clear();
        }


      }


    } catch (IOException ioException) {
      view.renderMessage("Could not start game");
      return;
    }

  }

  private int toPileNum(String s) {
    return Integer.parseInt(s.substring(1, s.length())) - 1;
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

  private boolean isValidInput(String a) {
    return a.length() >= 2 && goodInput(a.charAt(0))
            && Integer.parseInt(a.substring(1, a.length())) >= 0;
  }


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

  private void tryCatch(String s) {
    try {
      output.append(s);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
