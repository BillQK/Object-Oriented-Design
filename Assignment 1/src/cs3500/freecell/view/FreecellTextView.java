package cs3500.freecell.view;

import cs3500.freecell.model.FreecellModelState;

public class FreecellTextView implements FreecellView {
  private final FreecellModelState<?> model;

  public FreecellTextView(FreecellModelState<?> model) {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    this.model = model;
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
    return getString(model);
  }


  private <T> String getString(FreecellModelState<T> m) {    // "capture" the wildcard
    String view = "";
    String foundation = "";
    String open = "";
    String cascade = "";
    for (int i = 0; i < m.getNumOpenPiles(); i++) {
      String card;
      if (m.getOpenCardAt(i) == null) {
        card = "";
      } else {
        card = m.getOpenCardAt(i).toString();
      }
      String row = "O" + (i + 1) + ": " + card;
      open += row + "\r\n";
    }


    for (int i = 0; i < m.getNumCascadePiles(); i++) {
      String cards = "";
      for (int j = 0; j < m.getNumCardsInCascadePile(i); j++) {
        cards += m.getCascadeCardAt(i, j).toString() + ", ";
      }
      if (cards.length() > 0) {
        cards = cards.substring(0, cards.length() - 2);
      }
      String row = "C" + (i + 1) + ": " + cards;
      cascade += row + "\r\n";
    }

    for (int i = 0; i < 4; i++) {
      String cards = "";
      for (int j = 0; j < m.getNumCardsInFoundationPile(i); i++) {
        cards += m.getFoundationCardAt(i, j).toString() + ", ";
      }
      if (cards.length() > 0) {
        cards = cards.substring(0, cards.length() - 2);
      }
      String row = "F" + (i + 1) + ": " + cards;
      foundation += row + "\r\n";
    }
    view += foundation + open + cascade;

    return view.toString();  // can call toString here
  }
}
