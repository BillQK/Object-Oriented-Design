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

  @Override
  public String toString() {
    String card = model.getCascadeCardAt(0, 6).toString();
    // ...
    return getString(model);
  }

  // "capture"
  private <T> String getString(FreecellModelState<T> model) {
    T card = model.getCascadeCardAt(0, 6);
    return card.toString();
  }

}
