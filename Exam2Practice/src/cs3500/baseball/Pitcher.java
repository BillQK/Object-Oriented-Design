package cs3500.baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pitcher extends BasicPlayer implements IPitcher {

  private final Type type;
  private final Map<AtPlateResult, Integer> pitchingStats;

  public Pitcher(String name, int number, Type type) {
    super(name, number, Position.PITCHER);
    if (type == null) {
      throw new IllegalArgumentException("Must supply pitcher type");
    }
    this.type = type;
    this.pitchingStats = new HashMap<>();
  }

  public int restDaysNeeded() {
    switch (this.type) {
      case STARTER:
        return 5;
      case RELIEVER:
        return 3;
      case CLOSER:
        return 2;
      default:
        throw new IllegalStateException("Pitcher must have a type");
    }
  }

  public Type getType() {
    return type;
  }

  public void addPitchingAtPlate(AtPlateResult... rslt) {
    validateAtPlateResult(rslt);
    Arrays.stream(rslt).forEach(o -> pitchingStats.put(o, getPitchingStat(o) + 1));
  }

  public int getPitchingStat(AtPlateResult o) {
    return pitchingStats.getOrDefault(o, 0);
  }
}
