package cs3500.baseball;

public interface IPitcher extends Player {
  enum Type {
    STARTER, RELIEVE, CLOSER
  }

  void addPitchinAtPlaceResult(AtPlateResult... results);

  int getPitchStat(AtPlateResult r);

  Type getType();

}
