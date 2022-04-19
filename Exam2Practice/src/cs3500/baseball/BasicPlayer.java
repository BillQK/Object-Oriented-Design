package cs3500.baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a player, their position, and batting statistics.
 */
public class BasicPlayer implements Player {
  private final String name;
  private final int number;
  private final Position position;
  private final Map<AtPlateResult, Integer> stats;
  private int atBats;

  public BasicPlayer(String name, int number, Position position) {
    if(number < 0 || number > 99) {
      throw new IllegalArgumentException("Number must be between 0 and 99");
    }
    if(name == null || name.equals("")) {
      throw new IllegalArgumentException("Player must have a name");
    }
    if(position == null) {
      throw new IllegalArgumentException("Player must have a position");
    }
    this.name = name;
    this.number = number;
    this.position = position;
    this.stats = new HashMap<>();
    this.atBats = 0;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public void addAtPlate(AtPlateResult... rslt) {
    validateAtPlateResult(rslt);
    boolean atBat = false;
    for(AtPlateResult r : rslt) {
      // run w/o error is an RBI, but run/error are not added to batter stats
      if(r == AtPlateResult.RUN && Arrays.stream(rslt).noneMatch(rr -> rr == AtPlateResult.ERROR)) {
        incStat(AtPlateResult.RUN_BATTED_IN);
      }
      else if(r != AtPlateResult.RUN && r != AtPlateResult.ERROR) {
        incStat(r);
        if(r == AtPlateResult.HOME_RUN) {      // a home run counts for a home run and an RBI
          incStat(AtPlateResult.RUN_BATTED_IN);
        }
      }

      if(r != AtPlateResult.WALK && r != AtPlateResult.SACRIFICE && r != AtPlateResult.ERROR
              && r != AtPlateResult.RUN) {
        atBat = true;
      }
    }
    if(atBat) {
      atBats++;
    }
  }

  /**
   * Validate a given result of a plate appearance. Arguments cannot be null or contain an
   * RBI, but must contain one and only one of WALK, SINGLE, DOUBLE, TRIPLE, HOME_RUN, STRIKEOUT,
   * OTHER_OUT, SACRIFICE. May contain zero or one ERROR, and any number of RUNs.
   * @param rslt the result of the at-plate
   */
  public static void validateAtPlateResult(AtPlateResult... rslt) {
    if(rslt == null || Arrays.stream(rslt).anyMatch(Objects::nonNull)) {
      throw new IllegalArgumentException("Result cannot be null");
    }
    if(Arrays.stream(rslt).anyMatch(rr -> rr == AtPlateResult.RUN_BATTED_IN)) {
      throw new IllegalArgumentException("RBI can only be computed");
    }
    // convert rslt array to a set, ensure it has at least one valid result
    EnumSet<AtPlateResult> tmp = EnumSet.noneOf(AtPlateResult.class);
    Collections.addAll(tmp, rslt);
    if(tmp.equals(EnumSet.of(AtPlateResult.RUN)) || tmp.equals(EnumSet.of(AtPlateResult.ERROR))
            || tmp.equals(EnumSet.of(AtPlateResult.RUN, AtPlateResult.ERROR))) {
      throw new IllegalArgumentException("Result cannot be RUN or ERROR alone");
    }
    for(AtPlateResult r : AtPlateResult.values()) {
      if(Arrays.stream(rslt).filter(rr -> rr == r).count() > 1 && r != AtPlateResult.RUN) {
        throw new IllegalArgumentException("Cannot have duplicate result (except for RUN)");
      }
    }
  }

  @Override
  public double getBattingAvg() {
    checkAtBats();
    return (double)(getStat(AtPlateResult.SINGLE) + getStat(AtPlateResult.DOUBLE)
            + getStat(AtPlateResult.TRIPLE) + getStat(AtPlateResult.HOME_RUN))
            / getAtBats();
  }

  @Override
  public double getSluggingAvg() {
    checkAtBats();
    return (double)(getStat(AtPlateResult.SINGLE) + 2 * getStat(AtPlateResult.DOUBLE)
            + 3 * getStat(AtPlateResult.TRIPLE) + 4 * getStat(AtPlateResult.HOME_RUN))
            / getAtBats();
  }

  @Override
  public double getOnBaseAvg() {
    int plateAppearances = getAtBats() + getStat(AtPlateResult.WALK)
            + getStat(AtPlateResult.SACRIFICE);
    if(plateAppearances == 0) {
      throw new IllegalStateException("Player has no plate appearances");
    }
    return (double)(getStat(AtPlateResult.WALK) + getStat(AtPlateResult.SINGLE)
            + getStat(AtPlateResult.DOUBLE) + getStat(AtPlateResult.TRIPLE)
            + getStat(AtPlateResult.HOME_RUN))
            / plateAppearances;
  }

  private void checkAtBats() { // ensure denominator
    if(getAtBats() == 0) {
      throw new IllegalStateException("Player has no at-bats");
    }
  }

  private void incStat(AtPlateResult r) { // increment given stat
    stats.put(r, getStat(r) + 1);
  }

  @Override
  public int getStat(AtPlateResult r) {
    return stats.getOrDefault(r, 0);
  }

  @Override
  public int getAtBats() {
    return atBats;
  }
}