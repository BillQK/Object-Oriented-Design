package cs3500.freecell.view;

import java.io.IOException;

import cs3500.freecell.model.FreecellModelState;

/**
 * A representation of a Freecell Text View Class.
 */
public class FreecellTextView implements FreecellView {
  private final FreecellModelState<?> model;
  private Appendable output;


  /**
   * A constructor of FreecellTextview.
   *
   * @param model a given FreecellModelState
   * @throws IllegalStateException if the model is null
   */
  public FreecellTextView(FreecellModelState<?> model) {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    this.model = model;
  }

  public FreecellTextView(FreecellModelState<?> model, Appendable output) {
    this(model);
    this.output = output;
  }

  /**
   * Return the present state of the game as a string. The string is formatted as follows:
   * <pre>
   * F1:[b]f11,[b]f12,[b],...,[b]f1n1[n] (Cards in foundation pile 1 in order)
   * F2:[b]f21,[b]f22,[b],...,[b]f2n2[n] (Cards in foundation pile 2 in order)
   * ...
   * Fm:[b]fm1,[b]fm2,[b],...,[b]fmnm[n] (Cards in foundation pile m in
   * order)
   * O1:[b]o11[n] (Cards in open pile 1)
   * O2:[b]o21[n] (Cards in open pile 2)
   * ...
   * Ok:[b]ok1[n] (Cards in open pile k)
   * C1:[b]c11,[b]c12,[b]...,[b]c1p1[n] (Cards in cascade pile 1 in order)
   * C2:[b]c21,[b]c22,[b]...,[b]c2p2[n] (Cards in cascade pile 2 in order)
   * ...
   * Cs:[b]cs1,[b]cs2,[b]...,[b]csps (Cards in cascade pile s in order)
   *
   * where [b] is a single blankspace, [n] is newline. Note that there is no
   * newline on the last line
   * </pre>
   *
   * @return the formatted string as above
   */
  @Override
  public String toString() {
    try {
      model.getNumOpenPiles();
      model.getNumCascadePiles();
      model.getNumCardsInFoundationPile(0);
    } catch (IllegalStateException e) {
      return "";
    }
    return getString(model);
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard(){
    try {
      output.append(this.toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) {
    try {
      output.append(message + "\n");
    } catch (IOException e){
      e.printStackTrace();
    }
  }


  /**
   * a Helper method for toString() that compiles the information from the model.
   *
   * @param m   a FreecellModelState
   * @param <T> Card
   * @return a String
   */
  private <T> String getString(FreecellModelState<T> m) {    // "capture" the wildcard
    String open;
    String foundation;
    String cascade;
    String view = "";

    open = buildOpenString(m);
    foundation = buildFoundationString(m);
    cascade = buildCascadeString(m);

    view = foundation + open + cascade;

    return view;
  }

  /**
   * A method that return a Cascade String.
   *
   * @param m   a free cell model state
   * @param <T> Card
   * @return a String
   */
  private <T> String buildCascadeString(FreecellModelState<T> m) {
    String ans = "";
    for (int i = 0; i < m.getNumCascadePiles(); i++) {
      String cards = "";
      for (int j = 0; j < m.getNumCardsInCascadePile(i); j++) {
        T s = m.getCascadeCardAt(i, j);
        cards += " " + s.toString() + ",";
      }
      String a = "";
      if (cards.length() > 1) {
        a = cards.substring(0, cards.length() - 1);
      }
      String row = "C" + (i + 1) + ":" + a;
      ans += row + "\n";
    }
    ans = ans.substring(0, ans.length() - 1);
    return ans;
  }

  /**
   * A method that return a foundation string.
   *
   * @param m   a freecell model state
   * @param <T> Card
   * @return a String
   */
  private <T> String buildFoundationString(FreecellModelState<T> m) {
    String ans = "";
    for (int i = 0; i < 4; i++) {
      String cards = "";
      for (int j = 0; j < m.getNumCardsInFoundationPile(i); j++) {
        if (m.getNumCardsInFoundationPile(i) == 0) {
          cards += "";
        } else {
          cards += " " + m.getFoundationCardAt(i, j).toString() + ",";
        }
      }
      String a = "";
      if (cards.length() > 1) {
        a = cards.substring(0, cards.length() - 1);
      }
      String row = "F" + (i + 1) + ":" + a;
      ans += row + "\n";
    }
    return ans;
  }

  /**
   * a method return a Open pile String.
   *
   * @param m   a freecell model state
   * @param <T> Card
   * @return a String
   */
  private <T> String buildOpenString(FreecellModelState<T> m) {
    String ans = "";
    for (int i = 0; i < m.getNumOpenPiles(); i++) {
      String card;
      if (m.getOpenCardAt(i) == null) {
        card = "";
      } else {
        card = " " + m.getOpenCardAt(i).toString();
      }
      String row = "O" + (i + 1) + ":" + card;
      ans += row + "\n";
    }
    return ans;
  }


}
