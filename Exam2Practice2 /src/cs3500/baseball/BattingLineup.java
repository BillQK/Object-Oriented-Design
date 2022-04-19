package cs3500.baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BattingLineup implements Lineup {
  private final HashMap<Integer,Player> lineup;
  private final int MAX = 9;

  public BattingLineup() {
    this.lineup = new HashMap<>();
  }

  /**
   * Add a player to the lineup, at the position (order) specified.
   *
   * @param p     the player
   * @param order the player's position in the lineup (numbered from 1)
   * @throws IllegalArgumentException if a different player exists at the given order
   * @throws IllegalArgumentException if the given order is too big or too small
   * @throws IllegalArgumentException depending on implementation-specific rules
   */
  @Override
  public void addPlayer(Player p, int order) {
    if (p == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    if (order > MAX || order < 1) {
      throw new IllegalArgumentException("Invalid order");
    }
    if (lineup.containsKey(order)) {
      throw new IllegalArgumentException("Player exist at order");
    }
    for (Player player : lineup.values()) {
      if (player.getPosition().equals(p.getPosition())
      || player.getPosition().equals(Position.DESIGNATED_HITTER)
      && p.getPosition().equals(Position.PITCHER)
      || player.getPosition().equals(Position.PITCHER)
      && p.getPosition().equals(Position.DESIGNATED_HITTER)) {
        throw new IllegalArgumentException("violating the rule");
      }
    }

    this.lineup.put(order, p);
  }

  /**
   * Remove the given player from the lineup.
   *
   * @param p the player
   */
  @Override
  public void removePlayer(Player p) {
    if (lineup.containsValue(p)) {
      for (Integer key : lineup.keySet()) {
        if (lineup.get(key).equals(p)) {
          lineup.remove(key, p);
        }
      }
    }
  }

  /**
   * Get the current lineup position (order) of the given player. Positions in the lineup
   * are numbered from 1.
   *
   * @param p the player
   * @return the position (order), numbered from 1
   */
  @Override
  public int getOrder(Player p) {
    for (Integer key : lineup.keySet()) {
      if (lineup.get(key).equals(p)) {
        return key;
      }
    }
    return -1;
  }

  /**
   * Return the lineup as a List of players. The List must be in order, with each index
   * corresponding to the player's order in the lineup. The 0th index of the List is null.
   * If there is no player at a given order, the value at that index is null.
   *
   * @return the lineup
   */
  @Override
  public List<Player> getLineup() {
    List<Player> list = new ArrayList<>();
    for (int i = 0; i < MAX ; i++ ) {
       list.add(lineup.get(i));
    }
    return list;
  }

  /**
   * Report whether the lineup is complete, i.e., it has the required number of players, and meets
   * other implementation-specific criteria, if any.
   *
   * @return true if complete, false if not
   */
  @Override
  public boolean isComplete() {
    return lineup.size() == MAX;
  }
}
