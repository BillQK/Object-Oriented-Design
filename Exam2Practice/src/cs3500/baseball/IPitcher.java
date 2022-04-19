package cs3500.baseball;

public interface IPitcher extends Player {
  enum Type {
    STARTER, RELIEVER, CLOSER
  }
  Type getType();

  void addPitchingAtPlate(AtPlateResult... o);

  int getPitchingStat(AtPlateResult o);
}
