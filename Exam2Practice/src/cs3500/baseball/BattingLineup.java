package cs3500.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BattingLineup implements Lineup {
  public static final int FULL_LINEUP_COUNT = 9;

  private List<Player> players;

  public BattingLineup() {
    players = Arrays.asList(new Player[FULL_LINEUP_COUNT + 1]);
  }

  @Override
  public void addPlayer(Player p, int order) {
    if(p == null) {
      throw new IllegalArgumentException("Player cannot be null: use removePlayer to remove");
    }
    if (order < 1 || order > FULL_LINEUP_COUNT) {
      throw new IllegalArgumentException("Batting order must be 1-" + FULL_LINEUP_COUNT);
    }
    if(p.getPosition() == Position.DESIGNATED_HITTER
        && players.stream().anyMatch(e -> e != null && e.getPosition() == Position.PITCHER)
        || p.getPosition() == Position.PITCHER
        && players.stream().anyMatch(e -> e != null && e.getPosition() == Position.DESIGNATED_HITTER)) {
      throw new IllegalArgumentException("Cannot have both pitcher and designated hitter");
    }
    if(players.get(order) != null && !players.get(order).equals(p)) {
      throw new IllegalArgumentException("Already have a player batting " + order);
    }
    if(players.stream().anyMatch(e -> e != null && e.getPosition() == p.getPosition()
                                  && !e.equals(p))) {
      throw new IllegalArgumentException("Already have a player at " + p.getPosition());
    }
    removePlayer(p); // moving player from old order to new order
    players.set(order, p);
  }

  @Override
  public void removePlayer(Player p) {
    int i = getOrder(p);
    if(i != -1) {
      players.set(i, null);
    }
  }

  @Override
  public int getOrder(Player p) {
    if (p == null) {
      throw new IllegalArgumentException("Cannot get order for null player");
    }
    return players.indexOf(p);
  }

  @Override
  public List<Player> getLineup() {
    return new ArrayList<>(players);
  }

  @Override
  public boolean isComplete() {
    return players.stream().filter(Objects::nonNull).count() == FULL_LINEUP_COUNT;
  }
}
