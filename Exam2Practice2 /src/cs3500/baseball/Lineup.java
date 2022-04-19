package cs3500.baseball;

import java.util.List;

/**
 * Represents a "lineup" of players, as for a baseball team: an ordered roster.
 */
public interface Lineup {

  /**
   * Add a player to the lineup, at the position (order) specified.
   * @param p the player
   * @param order the player's position in the lineup (numbered from 1)
   * @throws IllegalArgumentException if a different player exists at the given order
   * @throws IllegalArgumentException if the given order is too big or too small
   * @throws IllegalArgumentException depending on implementation-specific rules
   */
  void addPlayer(Player p, int order);

  /**
   * Remove the given player from the lineup.
   * @param p the player
   */
  void removePlayer(Player p);

  /**
   * Get the current lineup position (order) of the given player. Positions in the lineup
   * are numbered from 1.
   * @param p the player
   * @return the position (order), numbered from 1
   */
  int getOrder(Player p);

  /**
   * Return the lineup as a List of players. The List must be in order, with each index
   * corresponding to the player's order in the lineup. The 0th index of the List is null.
   * If there is no player at a given order, the value at that index is null.
   * @return the lineup
   */
  List<Player> getLineup();

  /**
   * Report whether the lineup is complete, i.e., it has the required number of players, and meets
   * other implementation-specific criteria, if any.
   * @return true if complete, false if not
   */
  boolean isComplete();
}
