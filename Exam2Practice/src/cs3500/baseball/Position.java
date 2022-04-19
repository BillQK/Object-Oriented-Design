package cs3500.baseball;

/**
 * Represents a player's fielding position (or designated hitter, if player does not field).
 * In some games, the pitcher does not bat and the designated hitter takes the pitcher's place in
 * batting.
 */
public enum Position {
  FIRST_BASE, SECOND_BASE, THIRD_BASE, SHORTSTOP, LEFT_FIELD, CENTER_FIELD,
  RIGHT_FIELD, CATCHER, PITCHER, DESIGNATED_HITTER
}
