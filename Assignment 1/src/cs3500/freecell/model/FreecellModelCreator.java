package cs3500.freecell.model;

import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

/**
 * A factory representation of a FreecellModelCreator,
 * Its usage is to return a instance of Freecell Model object.
 */
public class FreecellModelCreator {
  /**
   * A method that return an instance of the given GameType.
   * @param type a Gametype
   * @return a Freecell Model.
   */
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

  /**
   * An enum class for GameType.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE;
  }
}
