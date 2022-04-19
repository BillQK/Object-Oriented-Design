package cs3500.baseball;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public interface BattingLineupStrategy {
  Lineup apply(Set<Player> team, Lineup existing);
}

abstract class BestXAtOrderY implements BattingLineupStrategy {
  private Comparator<Player> comp;
  private int order;
  BestXAtOrderY(Comparator<Player> c, int ord) {
    comp = c;
    order = ord;
  }

  @Override
  public Lineup apply(Set<Player> team, Lineup existing) {
    if(team.isEmpty()) {
      throw new IllegalArgumentException("No players to choose from");
    }
    Player best = team.stream().max(comp).orElse(null);
    if(existing.getLineup().get(order) == null) {
      existing.addPlayer(best, order);
      team.remove(best);
    }
    else if(comp.compare(existing.getLineup().get(order), best) < 0) {
      team.add(existing.getLineup().get(order));
      existing.removePlayer(existing.getLineup().get(order));
      existing.addPlayer(best, order);
      team.remove(best);
    }
    return existing;
  }
}

class HighestOBAFirst extends BestXAtOrderY {
  HighestOBAFirst() {
    super((a, b) -> Double.compare(a.getOnBaseAvg(), b.getOnBaseAvg()), 1);
  }
}
class HighestSluggingFourth extends BestXAtOrderY {
  HighestSluggingFourth() {
    super((a, b) -> Double.compare(a.getSluggingAvg(), b.getSluggingAvg()), 4);
  }
}
class WorstAverageNinth extends BestXAtOrderY {
  WorstAverageNinth() {
    super((a, b) -> Double.compare(b.getBattingAvg(), a.getBattingAvg()), 9);
  }
}

class Example {
  void test() {
    Player[] lop = {new BasicPlayer("mookie", 50, Position.RIGHT_FIELD)};
    Set<Player> team = new HashSet<>(Arrays.asList(lop));
    Lineup l = new BattingLineup();
    l = new WorstAverageNinth().apply(team, l);
    l = new HighestSluggingFourth().apply(team, l);
    l = new HighestOBAFirst().apply(team, l);
  }
}