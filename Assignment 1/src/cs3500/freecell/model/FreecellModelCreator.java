package cs3500.freecell.model;

import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

public class FreecellModelCreator {
  public static FreecellModel<Card> create(GameType type) {
    if (type == null) {
      throw new IllegalArgumentException("Game Type cannot be null");
    } else if (type == GameType.MULTIMOVE) {
      return new MultiMoveFreecellModel();
    } else if (type == GameType.SINGLEMOVE) {
      return new SimpleFreecellModel();
    } else {
      throw new IllegalArgumentException("Invalid Game Type");
    }
  }

  public enum GameType {
    SINGLEMOVE, MULTIMOVE;
  }
}
