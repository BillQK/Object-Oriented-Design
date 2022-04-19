package cs3500.baseball;

import java.util.Map;

/**
 * Represents a single game of baseball between two teams, with the ability to
 * record player plate appearances.
 */
public interface Game {
  /**
   * Add a team to this game.
   * @param team the team name
   * @throws IllegalArgumentException if already two teams
   */
  void addTeam(String team);

  /**
   * Add a plate appearance for the given player.
   * @param name player's name
   * @param number player's jersey number
   * @param result result(s) of the plate appearance
   * @throws IllegalArgumentException if no such player in the game, or result
   * is invalid
   */
  void addAtPlate(String name, int number, AtPlateResult... result);

  /**
   * Add a batting lineup for the given team.
   * @param team a team that's in this game
   * @param bl a complete batting lineup
   * @throws IllegalArgumentException if no such team in this game
   * @throws IllegalArgumentException if lineup is not complete
   */
  void addBattingLineup(String team, BattingLineup bl);

  /**
   * Return the score of the game as map of team name to runs scored.
   * @return the score
   */
  Map<String, Integer> getScore();

  /**
   * Return the name of the team currently winning, or null if the game is tied.
   * @return the currently winning team (or null)
   */
  String winning();
}
