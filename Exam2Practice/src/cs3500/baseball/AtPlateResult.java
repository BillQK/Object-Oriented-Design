package cs3500.baseball;

/**
 * The outcome of a plate appearance. A single plate appearance may have multiple outcomes, e.g. a
 * home run and two runs, if there were two players on base when the home run occurred.
 * A WALK means the player reached first base due to 4 balls or being hit by a pitch, and does
 * not count as an at-bat.
 * A SACRIFICE means the player intentionally hit into an out in order to advance a runner already
 * on base, and does not count as an at-bat.
 * An ERROR means there was a fielding error that benefited the hitting team; if there was a RUN
 * scored, the batter is not credited with a RUN_BATTED_IN.
 */
public enum AtPlateResult {
  STRIKEOUT, OTHER_OUT, WALK, SINGLE, DOUBLE, TRIPLE, HOME_RUN, SACRIFICE,
  RUN, ERROR, RUN_BATTED_IN
}
