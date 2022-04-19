package cs3500.baseball;

/**
 * Represents a single player in the sport of major league baseball. A player's name and
 * jersey number together uniquely identify the player. A player is mutable, and by design
 * in general you should have only one instance for each unique player, so as to have one correct
 * set of stats for the player.
 * Note that "plate appearance" and "at-plate" are used interchangeably throughout.
 */
public interface Player {

  /**
   * Get the name of the player.
   * @return the player's name
   */
  String getName();

  /**
   * Get the jersey number of the player.
   * @return jersey number
   */
  int getNumber();

  /**
   * Get the defensive (fielding) position of the player (or designated hitter if applicable)
   * @return player's position.
   */
  Position getPosition();

  /**
   * Record the outcome of a plate appearance for the player. For example, if the player hit a
   * single which resulted in a player already on base scoring, the argument would be
   * AtPlateResult.SINGLE, AtPlateResult.RUN.
   * @param result the result(s) of the plate appearance
   */
  void addAtPlate(AtPlateResult... result);

  /**
   * Get the player's batting average: number of hits (singles + doubles + triples + home runs)
   * divided by the number of at-bats (plate appearances excluding walks and sacrifices).
   * @return player's batting average
   * @throws IllegalStateException if player has no at-bats
   */
  double getBattingAvg();

  /**
   * Get the player's slugging average: weighted number of hits (singles + 2 * doubles +
   * 3 * triples + 4 * home runs) divided by the number of at-bats (plate appearances excluding
   * walks and sacrifices).
   * @return player's slugging average
   */
  double getSluggingAvg();

  /**
   * Get the player's on-base average: number of on-base (walks + hits) divided by plate
   * appearances (at-bats + walks + sacrifices).
   * @return player's on-base average
   */
  double getOnBaseAvg();

  /**
   * Get the count of the given plate-appearance result for the player.
   * @param o the plate-appearance result
   * @return number of times the result occurred for the player
   */
  int getStat(AtPlateResult o);

  /**
   * Get the number of at-bats (plate appearances excluding walks and sacrifices) for the player.
   * @return player's at-bats
   */
  int getAtBats();
}
